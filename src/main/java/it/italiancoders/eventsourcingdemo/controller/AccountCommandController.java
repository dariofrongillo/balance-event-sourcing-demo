package it.italiancoders.eventsourcingdemo.controller;

import it.italiancoders.eventsourcingdemo.dto.AccountCreateDTO;
import it.italiancoders.eventsourcingdemo.dto.MoneyCreditDTO;
import it.italiancoders.eventsourcingdemo.dto.MoneyDebitDTO;
import it.italiancoders.eventsourcingdemo.service.AccountCommandService;
import it.italiancoders.eventsourcingdemo.service.AccountQueryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping(value = "/bank-accounts")
public class AccountCommandController {

    private final AccountCommandService accountCommandService;

    private final AccountQueryService accountQueryService;

    public AccountCommandController(AccountCommandService accountCommandService,
                                    AccountQueryService accountQueryService) {
        this.accountCommandService = accountCommandService;
        this.accountQueryService = accountQueryService;
    }


    @GetMapping("/events/{accountNumber}")
    public List<Object> getEvents(@PathVariable(value = "accountNumber") String accountNumber){
        return accountQueryService.listEventsForAccount(accountNumber);

    }


    @PostMapping
    public CompletableFuture<String> createAccount(@RequestBody AccountCreateDTO accountCreateDTO){
        return accountCommandService.createAccount(accountCreateDTO);
    }

    @PutMapping(value = "/credits/{accountNumber}")
    public CompletableFuture<String> creditMoneyToAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                          @RequestBody MoneyCreditDTO moneyCreditDTO){
        return accountCommandService.creditMoneyToAccount(accountNumber, moneyCreditDTO);
    }

    @PutMapping(value = "/debits/{accountNumber}")
    public CompletableFuture<String> debitMoneyFromAccount(@PathVariable(value = "accountNumber") String accountNumber,
                                                           @RequestBody MoneyDebitDTO moneyDebitDTO){
        return accountCommandService.debitMoneyFromAccount(accountNumber, moneyDebitDTO);
    }
}
