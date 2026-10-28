package com.northstar.banking.payment.port.out;
import com.northstar.banking.model.BankingModels.TransferRequest;
import com.northstar.banking.model.BankingModels.TransferResponse;
import java.math.BigDecimal;
public interface AccountLedgerPort {
 TransferResponse transferOwnAccounts(TransferRequest request);
 void debitForPayment(String sourceAccountId,BigDecimal paymentAmount,BigDecimal fee,String category,String memo);
}
