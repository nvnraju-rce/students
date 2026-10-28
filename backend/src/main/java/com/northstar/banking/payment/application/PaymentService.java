package com.northstar.banking.payment.application;
import com.northstar.banking.payment.domain.PaymentProcessor;
import com.northstar.banking.payment.domain.PaymentType;
import com.northstar.banking.payment.domain.PaymentModels.PaymentReceipt;
import com.northstar.banking.payment.domain.PaymentModels.PaymentRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
@Service
public class PaymentService {
 private final Map<PaymentType,PaymentProcessor> processors=new EnumMap<>(PaymentType.class);private final AtomicLong references=new AtomicLong(5000);
 public PaymentService(List<PaymentProcessor> implementations){for(PaymentProcessor processor:implementations){if(processors.putIfAbsent(processor.type(),processor)!=null)throw new IllegalStateException("Duplicate payment processor registered for "+processor.type());}}
 public PaymentReceipt makePayment(PaymentRequest request){
  if(request==null||request.sourceAccountId()==null||request.amount()==null)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Enter a source account and payment amount.");
  PaymentType type;try{type=PaymentType.valueOf(request.paymentType()==null?"":request.paymentType().trim().toUpperCase());}catch(IllegalArgumentException error){throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Unsupported payment type.");}
  BigDecimal amount;try{amount=request.amount().setScale(2,RoundingMode.UNNECESSARY);}catch(ArithmeticException error){throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Amount can have at most two decimal places.");}
  if(amount.signum()<=0)throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Amount must be greater than zero.");
  PaymentProcessor processor=processors.get(type);if(processor==null)throw new ResponseStatusException(HttpStatus.NOT_IMPLEMENTED,"No processor is registered for this payment type.");
  return processor.process(request,amount,"PAY-"+references.incrementAndGet());
 }
}
