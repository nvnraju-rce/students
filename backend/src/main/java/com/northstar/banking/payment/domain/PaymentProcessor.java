package com.northstar.banking.payment.domain;
import com.northstar.banking.payment.domain.PaymentModels.PaymentReceipt;
import com.northstar.banking.payment.domain.PaymentModels.PaymentRequest;
import java.math.BigDecimal;
public interface PaymentProcessor {
 PaymentType type();
 PaymentReceipt process(PaymentRequest request,BigDecimal amount,String reference);
}
