package com.northstar.banking.api;
import com.northstar.banking.payment.application.PaymentService;
import com.northstar.banking.payment.domain.PaymentModels.PaymentReceipt;
import com.northstar.banking.payment.domain.PaymentModels.PaymentRequest;
import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/modules/payments")
public class PaymentController {
 private final PaymentService payments;
 public PaymentController(PaymentService payments){this.payments=payments;}
 @PostMapping public PaymentReceipt makePayment(@RequestBody PaymentRequest request){return payments.makePayment(request);}
}
