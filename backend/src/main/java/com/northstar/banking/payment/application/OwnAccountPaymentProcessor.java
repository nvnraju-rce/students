package com.northstar.banking.payment.application;
import com.northstar.banking.model.BankingModels.TransferRequest;
import com.northstar.banking.model.BankingModels.TransferResponse;
import com.northstar.banking.payment.domain.PaymentProcessor;
import com.northstar.banking.payment.domain.PaymentType;
import com.northstar.banking.payment.domain.PaymentModels.PaymentReceipt;
import com.northstar.banking.payment.domain.PaymentModels.PaymentRequest;
import com.northstar.banking.payment.port.out.AccountLedgerPort;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component
public class OwnAccountPaymentProcessor implements PaymentProcessor {
 private final AccountLedgerPort ledger;
 public OwnAccountPaymentProcessor(AccountLedgerPort ledger){this.ledger=ledger;}
 @Override public PaymentType type(){return PaymentType.OWN;}
 @Override public PaymentReceipt process(PaymentRequest request,BigDecimal amount,String reference){TransferResponse result=ledger.transferOwnAccounts(new TransferRequest(request.sourceAccountId(),request.destinationAccountId(),amount,request.purpose()));return new PaymentReceipt(reference,type().name(),"COMPLETED",amount,"INR",result.message());}
}
