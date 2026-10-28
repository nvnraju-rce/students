package com.northstar.banking.api;
import com.northstar.banking.core.*;
import com.northstar.banking.model.BankingModels.*;
import com.northstar.banking.model.ProductModels.*;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.*;
import java.util.List;
@RestController @RequestMapping("/api/modules") public class ProductController {
 private final MockCoreBankingService core;private final ProductService products;
 public ProductController(MockCoreBankingService core,ProductService products){this.core=core;this.products=products;}
 @GetMapping("/casa") public List<com.northstar.banking.model.BankingModels.Account> casa(){return core.dashboard().accounts();}
 @PostMapping("/casa") public com.northstar.banking.model.BankingModels.Account openCasa(@RequestBody CasaRequest r){return core.openCasa(new com.northstar.banking.model.ProductModels.CasaRequest(r.name(),r.type(),r.openingBalance()));}
 @GetMapping("/deposits") public List<FixedDeposit> deposits(@AuthenticationPrincipal Jwt jwt){return products.deposits(jwt.getSubject());}
 @PostMapping("/deposits") public FixedDeposit openDeposit(@AuthenticationPrincipal Jwt jwt,@RequestBody DepositRequest r){return products.openDeposit(jwt.getSubject(),r);}
 @GetMapping("/loans") public List<Loan> loans(@AuthenticationPrincipal Jwt jwt){return products.loans(jwt.getSubject());}
 @PostMapping("/loans") public Loan applyLoan(@AuthenticationPrincipal Jwt jwt,@RequestBody LoanRequest r){return products.applyLoan(jwt.getSubject(),r);}

}
