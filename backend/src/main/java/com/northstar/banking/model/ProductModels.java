package com.northstar.banking.model;
import java.math.BigDecimal;
import java.time.LocalDate;
public final class ProductModels {
 private ProductModels() {}
 public record CasaRequest(String name,String type,BigDecimal openingBalance) {}
 public record DepositRequest(String sourceAccountId,BigDecimal principal,int tenureMonths) {}
 public record FixedDeposit(String id,String sourceAccountId,BigDecimal principal,BigDecimal annualRate,int tenureMonths,BigDecimal maturityValue,LocalDate maturityDate,String status) {}
 public record LoanRequest(BigDecimal amount,int tenureMonths,String purpose) {}
 public record Loan(String id,BigDecimal amount,int tenureMonths,String purpose,BigDecimal indicativeMonthlyPayment,String status,LocalDate appliedOn) {}
 public record ProfileUpdate(String name,String mobileNo,String emailId) {}
}
