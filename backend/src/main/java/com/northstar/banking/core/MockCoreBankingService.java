package com.northstar.banking.core;

import com.northstar.banking.model.BankingModels.*;
import com.northstar.banking.model.ProductModels.CasaRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MockCoreBankingService {
    private final Map<String, Account> accounts = new LinkedHashMap<>();
    private final List<Transaction> transactions = new ArrayList<>();
    private final List<BankCard> cards = new ArrayList<>();
    private final AtomicLong sequence = new AtomicLong(9006);
    private final Profile profile = new Profile("Account Holder", "AH", "DEMO-10042", "2023");
    private final Insights insights = new Insights(
            new BigDecimal("12843.00"), new BigDecimal("100000.00"), new BigDecimal("68000.00"),
            List.of(new CategorySpend("Home & bills", new BigDecimal("4826.00"), "#496dea"),
                    new CategorySpend("Food & drink", new BigDecimal("2964.00"), "#8b6dec"),
                    new CategorySpend("Transport", new BigDecimal("1582.00"), "#42a888"),
                    new CategorySpend("Shopping", new BigDecimal("2141.00"), "#edaa54"),
                    new CategorySpend("Other", new BigDecimal("1330.00"), "#95a2b6")),
            List.of(new BigDecimal("2430.00"), new BigDecimal("2860.00"),
                    new BigDecimal("3190.00"), new BigDecimal("4363.00")));

    public MockCoreBankingService() {
        accounts.put("ACC-2048", new Account("ACC-2048", "Everyday account", "Savings",
                "•••• 2048", new BigDecimal("84205.55"), "INR", "ACTIVE"));
        accounts.put("ACC-8831", new Account("ACC-8831", "Growth savings", "Savings",
                "•••• 8831", new BigDecimal("126802.20"), "INR", "ACTIVE"));
        accounts.put("ACC-4620", new Account("ACC-4620", "Rainy day reserve", "Savings",
                "•••• 4620", new BigDecimal("31500.00"), "INR", "ACTIVE"));
        seedTransactions();
        cards.add(new BankCard("CARD-7104", "Northstar Everyday", "•••• 7104",
                "VISA", "09/29", false, new BigDecimal("100000.00")));
    }

    public synchronized DashboardResponse dashboard() {
        return new DashboardResponse(profile, List.copyOf(accounts.values()),
                transactions.stream().limit(30).toList(), List.copyOf(cards), insights, now());
    }

    public synchronized Account openCasa(CasaRequest request) {
        if(request==null||request.name()==null||request.name().isBlank()||request.openingBalance()==null||request.openingBalance().signum()<0||!("Savings".equalsIgnoreCase(request.type())||"Current".equalsIgnoreCase(request.type())))throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a valid account name, account type and non-negative opening balance.");
        String id="ACC-"+(2048+accounts.size()*1379);if(accounts.containsKey(id))id="ACC-"+sequence.incrementAndGet();
        Account a=new Account(id,request.name().trim(),request.type().substring(0,1).toUpperCase()+request.type().substring(1).toLowerCase(),"•••• "+id.substring(id.length()-4),request.openingBalance().setScale(2,RoundingMode.HALF_UP),"INR","ACTIVE");accounts.put(id,a);return a;
    }
    public synchronized void reserveForDeposit(String accountId, BigDecimal principal) {
        Account source=accounts.get(accountId);
        if(source==null)throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Funding account was not found.");
        if(principal==null||principal.signum()<=0||source.balance().compareTo(principal)<0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Deposit principal must be positive and within the available account balance.");
        accounts.put(source.id(),withBalance(source,source.balance().subtract(principal)));
        transactions.add(0,new Transaction("TX-"+sequence.incrementAndGet(),source.id(),"Fixed deposit opened","Deposit",principal.negate(),now(),"DEMO","Demo deposit funding"));
    }
    public synchronized void debitForPayment(String sourceAccountId, BigDecimal paymentAmount, BigDecimal fee, String category, String memo) {
        Account source = accounts.get(sourceAccountId);
        if (source == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Source account was not found.");
        BigDecimal safeFee = fee == null ? BigDecimal.ZERO : fee;
        if (paymentAmount == null || paymentAmount.signum() <= 0 || safeFee.signum() < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Payment amount or fee is invalid.");
        BigDecimal total = paymentAmount.add(safeFee);
        if (source.balance().compareTo(total) < 0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient funds including applicable payment fees.");
        accounts.put(source.id(), withBalance(source, source.balance().subtract(total)));
        OffsetDateTime time = now();
        transactions.add(0, new Transaction("TX-" + sequence.incrementAndGet(), source.id(), category, category, paymentAmount.negate(), time, "DEMO", memo));
        if (safeFee.signum() > 0) transactions.add(1, new Transaction("TX-" + sequence.incrementAndGet(), source.id(), "Payment fee", "Fee", safeFee.negate(), time, "DEMO", category));
    }

    public synchronized TransferResponse transfer(TransferRequest request) {
        if (request == null || request.sourceAccountId() == null || request.destinationAccountId() == null
                || request.amount() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Choose two accounts and enter an amount.");
        }
        BigDecimal amount;
        try {
            amount = request.amount().setScale(2, RoundingMode.UNNECESSARY);
        } catch (ArithmeticException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amount can have at most two decimal places.");
        }
        if (amount.signum() <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Amount must be greater than zero.");
        }
        if (request.sourceAccountId().equals(request.destinationAccountId())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Choose two different accounts.");
        }
        Account source = accounts.get(request.sourceAccountId());
        Account destination = accounts.get(request.destinationAccountId());
        if (source == null || destination == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "A selected demo account was not found.");
        }
        if (source.balance().compareTo(amount) < 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "The demo account has insufficient funds.");
        }

        String memo = request.memo() == null || request.memo().isBlank() ? "Demo account transfer" : request.memo().trim();
        if (memo.length() > 80) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Memo must be 80 characters or fewer.");
        }
        accounts.put(source.id(), withBalance(source, source.balance().subtract(amount)));
        accounts.put(destination.id(), withBalance(destination, destination.balance().add(amount)));
        OffsetDateTime timestamp = now();
        transactions.add(0, new Transaction("TX-" + sequence.incrementAndGet(), source.id(),
                "Transfer to " + destination.name(), "Transfer", amount.negate(), timestamp, "DEMO", memo));
        transactions.add(1, new Transaction("TX-" + sequence.incrementAndGet(), destination.id(),
                "Transfer from " + source.name(), "Transfer", amount, timestamp, "DEMO", memo));
        return new TransferResponse("Demo transfer applied in memory. No real money moved.", true, dashboard());
    }

    public synchronized BankCard setCardFrozen(String cardId, boolean frozen) {
        for (int i = 0; i < cards.size(); i++) {
            BankCard card = cards.get(i);
            if (card.id().equals(cardId)) {
                BankCard changed = new BankCard(card.id(), card.name(), card.maskedNumber(),
                        card.network(), card.expiry(), frozen, card.monthlyLimit());
                cards.set(i, changed);
                return changed;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Demo card not found.");
    }

    private Account withBalance(Account a, BigDecimal value) {
        return new Account(a.id(), a.name(), a.type(), a.maskedNumber(),
                value.setScale(2, RoundingMode.HALF_UP), a.currency(), a.status());
    }

    private OffsetDateTime now() {
        return OffsetDateTime.now(ZoneId.of("Asia/Kolkata"));
    }

    private void seedTransactions() {
        OffsetDateTime today = now();
        transactions.add(new Transaction("TX-9001", "ACC-2048", "Blue Bottle Coffee", "Food & drink",
                new BigDecimal("-680.00"), today.minusHours(2), "POSTED", "Card ending 7104"));
        transactions.add(new Transaction("TX-9002", "ACC-2048", "Transfer from Maya", "Transfer",
                new BigDecimal("12500.00"), today.minusDays(1), "POSTED", "Received"));
        transactions.add(new Transaction("TX-9003", "ACC-2048", "Metro Transit", "Transport",
                new BigDecimal("-125.00"), today.minusDays(3), "POSTED", "Card ending 7104"));
        transactions.add(new Transaction("TX-9004", "ACC-2048", "Northstar Utilities", "Home & bills",
                new BigDecimal("-8420.00"), today.minusDays(4), "POSTED", "Monthly bill"));
        transactions.add(new Transaction("TX-9005", "ACC-8831", "Monthly savings", "Savings",
                new BigDecimal("15000.00"), today.minusDays(6), "POSTED", "Automatic deposit"));
        transactions.add(new Transaction("TX-9006", "ACC-2048", "Campus Bookstore", "Shopping",
                new BigDecimal("-3875.00"), today.minusDays(8), "POSTED", "Card ending 7104"));
    }
}
