package com.northstar.banking.payment.adapter.out;
import com.northstar.banking.core.MockCoreBankingService;
import com.northstar.banking.model.BankingModels.TransferRequest;
import com.northstar.banking.model.BankingModels.TransferResponse;
import com.northstar.banking.payment.port.out.AccountLedgerPort;
import org.springframework.stereotype.Component;
import java.math.BigDecimal;
@Component
public class DemoAccountLedgerAdapter implements AccountLedgerPort {
 private final MockCoreBankingService ledger;
 public DemoAccountLedgerAdapter(MockCoreBankingService ledger){this.ledger=ledger;}
 @Override public TransferResponse transferOwnAccounts(TransferRequest request){return ledger.transfer(request);}
 @Override public void debitForPayment(String sourceAccountId,BigDecimal paymentAmount,BigDecimal fee,String category,String memo){ledger.debitForPayment(sourceAccountId,paymentAmount,fee,category,memo);}
}
