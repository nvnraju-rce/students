package com.northstar.banking.api;

import com.northstar.banking.core.MockCoreBankingService;
import com.northstar.banking.model.BankingModels.*;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api/core")
public class BankingController {
    private final MockCoreBankingService core;

    public BankingController(MockCoreBankingService core) {
        this.core = core;
    }

    @GetMapping("/dashboard")
    public DashboardResponse dashboard() {
        return core.dashboard();
    }

    @GetMapping("/accounts")
    public List<Account> accounts() {
        return core.dashboard().accounts();
    }

    @GetMapping("/transactions")
    public List<Transaction> transactions() {
        return core.dashboard().transactions();
    }

    @GetMapping("/cards")
    public List<BankCard> cards() {
        return core.dashboard().cards();
    }

    @PostMapping("/transfers")
    public TransferResponse transfer(@RequestBody TransferRequest request) {
        return core.transfer(request);
    }

    @PatchMapping("/cards/{cardId}")
    public BankCard freezeCard(@PathVariable String cardId, @RequestBody(required = false) FreezeRequest request) {
        if (request == null || request.frozen() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Provide the frozen state.");
        }
        return core.setCardFrozen(cardId, request.frozen());
    }
}
