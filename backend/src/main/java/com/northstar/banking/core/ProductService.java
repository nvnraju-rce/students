package com.northstar.banking.core;
import com.northstar.banking.model.ProductModels.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.*;
import java.time.LocalDate;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
@Service public class ProductService {
 private final Map<String,List<FixedDeposit>> deposits=new HashMap<>(); private final Map<String,List<Loan>> loans=new HashMap<>(); private final AtomicLong seq=new AtomicLong(1); private final MockCoreBankingService core;
 public ProductService(MockCoreBankingService core){this.core=core;}
 public synchronized List<FixedDeposit> deposits(String user){return List.copyOf(deposits.getOrDefault(user,List.of()));}
 public synchronized FixedDeposit openDeposit(String user,DepositRequest r){if(r==null||r.sourceAccountId()==null||r.principal()==null||r.principal().signum()<=0||r.tenureMonths()<1||r.tenureMonths()>120)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Provide an account, positive principal and tenure from 1 to 120 months.");core.reserveForDeposit(r.sourceAccountId(),r.principal());BigDecimal rate=new BigDecimal("6.75");BigDecimal maturity=r.principal().multiply(BigDecimal.ONE.add(rate.divide(new BigDecimal("1200"),8,RoundingMode.HALF_UP)).pow(r.tenureMonths())).setScale(2,RoundingMode.HALF_UP);FixedDeposit fd=new FixedDeposit("FD-"+seq.getAndIncrement(),r.sourceAccountId(),r.principal().setScale(2,RoundingMode.HALF_UP),rate,r.tenureMonths(),maturity,LocalDate.now().plusMonths(r.tenureMonths()),"ACTIVE");deposits.computeIfAbsent(user,k->new ArrayList<>()).add(fd);return fd;}
 public synchronized List<Loan> loans(String user){return List.copyOf(loans.getOrDefault(user,List.of()));}
 public synchronized Loan applyLoan(String user,LoanRequest r){if(r==null||r.amount()==null||r.amount().signum()<=0||r.tenureMonths()<1||r.tenureMonths()>360||r.purpose()==null||r.purpose().isBlank())throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a valid amount, purpose and tenure from 1 to 360 months.");BigDecimal monthlyRate=new BigDecimal("0.12").divide(new BigDecimal("12"),10,RoundingMode.HALF_UP);double pow=Math.pow(1+monthlyRate.doubleValue(),r.tenureMonths());BigDecimal emi=r.amount().multiply(monthlyRate).multiply(BigDecimal.valueOf(pow)).divide(BigDecimal.valueOf(pow-1),2,RoundingMode.HALF_UP);Loan loan=new Loan("LN-"+seq.getAndIncrement(),r.amount().setScale(2,RoundingMode.HALF_UP),r.tenureMonths(),r.purpose().trim(),emi,"UNDER_REVIEW",LocalDate.now());loans.computeIfAbsent(user,k->new ArrayList<>()).add(loan);return loan;}
}
