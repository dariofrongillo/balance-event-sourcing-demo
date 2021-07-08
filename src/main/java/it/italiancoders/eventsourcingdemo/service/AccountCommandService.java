package it.italiancoders.eventsourcingdemo.service;

import it.italiancoders.eventsourcingdemo.dto.AccountCreateDTO;
import it.italiancoders.eventsourcingdemo.dto.MoneyCreditDTO;
import it.italiancoders.eventsourcingdemo.dto.MoneyDebitDTO;

import java.util.concurrent.CompletableFuture;

public interface AccountCommandService {

    CompletableFuture<String> createAccount(AccountCreateDTO accountCreateDTO);
    CompletableFuture<String> creditMoneyToAccount(String accountNumber, MoneyCreditDTO moneyCreditDTO);
    CompletableFuture<String> debitMoneyFromAccount(String accountNumber, MoneyDebitDTO moneyDebitDTO);
}
