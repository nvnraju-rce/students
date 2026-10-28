package com.northstar.banking.model;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public final class BankingModels {
    private BankingModels() {}

    public record Profile(String name, String initials, String customerId, String memberSince) {}
    public record Account(String id, String name, String type, String maskedNumber,
                          BigDecimal balance, String currency, String status) {}
    public record Transaction(String id, String accountId, String counterparty, String category,
                              BigDecimal amount, OffsetDateTime occurredAt, String status, String note) {}
    public record BankCard(String id, String name, String maskedNumber, String network,
                           String expiry, boolean frozen, BigDecimal monthlyLimit) {}
    public record CategorySpend(String category, BigDecimal amount, String color) {}
    public record Insights(BigDecimal monthlySpend, BigDecimal savingsGoal, BigDecimal savedTowardGoal,
                           List<CategorySpend> categories, List<BigDecimal> weeklySpend) {}
    public record DashboardResponse(Profile profile, List<Account> accounts, List<Transaction> transactions,
                                    List<BankCard> cards, Insights insights, OffsetDateTime updatedAt) {}
    public record TransferRequest(String sourceAccountId, String destinationAccountId,
                                  BigDecimal amount, String memo) {}
    public record TransferResponse(String message, boolean simulated, DashboardResponse dashboard) {}
    public record FreezeRequest(Boolean frozen) {}
}
