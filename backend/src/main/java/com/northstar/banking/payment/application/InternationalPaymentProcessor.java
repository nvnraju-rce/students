package com.northstar.banking.payment.application;
import com.northstar.banking.payment.domain.PaymentType;
import com.northstar.banking.payment.port.out.AccountLedgerPort;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
import java.math.RoundingMode;
@Component public class InternationalPaymentProcessor extends AbstractExternalPaymentProcessor {public InternationalPaymentProcessor(AccountLedgerPort ledger){super(PaymentType.INTERNATIONAL,ledger);}@Override protected BigDecimal feeFor(BigDecimal amount){return amount.multiply(new BigDecimal("0.02")).setScale(2,RoundingMode.HALF_UP);}}
