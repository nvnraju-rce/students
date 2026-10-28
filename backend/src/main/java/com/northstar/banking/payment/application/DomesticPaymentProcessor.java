package com.northstar.banking.payment.application;
import com.northstar.banking.payment.domain.PaymentType;
import com.northstar.banking.payment.port.out.AccountLedgerPort;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component public class DomesticPaymentProcessor extends AbstractExternalPaymentProcessor {public DomesticPaymentProcessor(AccountLedgerPort ledger){super(PaymentType.DOMESTIC,ledger);}@Override protected BigDecimal feeFor(BigDecimal amount){return BigDecimal.ZERO;}}
