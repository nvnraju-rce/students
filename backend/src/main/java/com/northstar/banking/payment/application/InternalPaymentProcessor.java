package com.northstar.banking.payment.application;
import com.northstar.banking.payment.domain.PaymentType;
import com.northstar.banking.payment.port.out.AccountLedgerPort;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component public class InternalPaymentProcessor extends AbstractExternalPaymentProcessor {public InternalPaymentProcessor(AccountLedgerPort ledger){super(PaymentType.INTERNAL,ledger);}@Override protected BigDecimal feeFor(BigDecimal amount){return BigDecimal.ZERO;}}
