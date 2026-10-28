package com.northstar.banking.payment.application;
import com.northstar.banking.payment.domain.PaymentProcessor;
import com.northstar.banking.payment.domain.PaymentType;
import com.northstar.banking.payment.domain.PaymentModels.PaymentReceipt;
import com.northstar.banking.payment.domain.PaymentModels.PaymentRequest;
import com.northstar.banking.payment.port.out.AccountLedgerPort;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
abstract class AbstractExternalPaymentProcessor implements PaymentProcessor {
 private final PaymentType type;private final AccountLedgerPort ledger;
 AbstractExternalPaymentProcessor(PaymentType type,AccountLedgerPort ledger){this.type=type;this.ledger=ledger;}
 @Override public final PaymentType type(){return type;}
 @Override public final PaymentReceipt process(PaymentRequest request,BigDecimal amount,String reference){
  if(request.beneficiaryName()==null||request.beneficiaryName().isBlank()||request.beneficiaryAccount()==null||request.beneficiaryAccount().isBlank())throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter beneficiary name and account number.");
  if(type==PaymentType.INTERNATIONAL&&(request.currency()==null||!request.currency().matches("[A-Za-z]{3}")||request.country()==null||request.country().isBlank()))throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a destination country and a three-letter settlement currency.");
  BigDecimal fee=feeFor(amount);String purpose=request.purpose()==null||request.purpose().isBlank()?reference:request.purpose().trim()+" · "+reference;
  ledger.debitForPayment(request.sourceAccountId(),amount,fee,"Payment · "+type.name(),purpose);
  String currency=type==PaymentType.INTERNATIONAL?request.currency().toUpperCase():"INR";
  String message=type==PaymentType.INTERNATIONAL?"Demo payment queued; estimated 2% fee applied. No real funds moved.":"Demo payment recorded. No real funds moved.";
  return new PaymentReceipt(reference,type.name(),"SIMULATED",amount,currency,message);
 }
 protected abstract BigDecimal feeFor(BigDecimal amount);
}
