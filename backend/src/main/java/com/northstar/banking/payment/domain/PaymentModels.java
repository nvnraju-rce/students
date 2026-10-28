package com.northstar.banking.payment.domain;
import java.math.BigDecimal;
public final class PaymentModels {
 private PaymentModels() {}
 public record PaymentRequest(String paymentType,String sourceAccountId,String destinationAccountId,String beneficiaryName,String beneficiaryAccount,String bankName,String country,String currency,BigDecimal amount,String purpose) {}
 public record PaymentReceipt(String reference,String paymentType,String status,BigDecimal amount,String currency,String message) {}
}
