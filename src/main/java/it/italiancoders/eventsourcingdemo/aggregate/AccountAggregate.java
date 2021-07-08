package it.italiancoders.eventsourcingdemo.aggregate;

import it.italiancoders.eventsourcingdemo.command.CreateAccountCommand;
import it.italiancoders.eventsourcingdemo.command.CreditMoneyCommand;
import it.italiancoders.eventsourcingdemo.command.DebitMoneyCommand;
import it.italiancoders.eventsourcingdemo.event.AccountCreatedEvent;
import it.italiancoders.eventsourcingdemo.event.MoneyChargedEvent;
import it.italiancoders.eventsourcingdemo.event.MoneyCreditedEvent;
import lombok.Getter;
import lombok.Setter;
import org.axonframework.commandhandling.CommandHandler;
import org.axonframework.commandhandling.gateway.CommandGateway;
import org.axonframework.commandhandling.model.AggregateIdentifier;
import org.axonframework.commandhandling.model.AggregateLifecycle;
import org.axonframework.eventsourcing.EventSourcingHandler;
import org.axonframework.spring.stereotype.Aggregate;

@Getter
@Setter
@Aggregate
public class AccountAggregate {
    @AggregateIdentifier
    private String id;

    private double accountBalance;

    private String currency;


    public AccountAggregate() {
    }

    @CommandHandler
    public AccountAggregate(CreateAccountCommand createAccountCommand){
        AggregateLifecycle.apply(new AccountCreatedEvent(createAccountCommand.id, createAccountCommand.accountBalance, createAccountCommand.currency));
    }

    @EventSourcingHandler
    protected void on(AccountCreatedEvent accountCreatedEvent){
        this.id = accountCreatedEvent.id;
        this.accountBalance = accountCreatedEvent.accountBalance;
        this.currency = accountCreatedEvent.currency;
    }


    @CommandHandler
    protected void on(CreditMoneyCommand creditMoneyCommand) {
        AggregateLifecycle.apply(new MoneyCreditedEvent(creditMoneyCommand.id, creditMoneyCommand.creditAmount, creditMoneyCommand.currency));
    }

    @EventSourcingHandler
    protected void on(MoneyCreditedEvent moneyCreditedEvent) {
        this.accountBalance += moneyCreditedEvent.creditAmount;
    }

    @CommandHandler
    protected void on(DebitMoneyCommand debitMoneyCommand){
        AggregateLifecycle.apply(new MoneyChargedEvent(debitMoneyCommand.id, debitMoneyCommand.debitAmount, debitMoneyCommand.currency));
    }

    @EventSourcingHandler
    protected void on(MoneyChargedEvent moneyChargedEvent){

        if (this.accountBalance - moneyChargedEvent.debitAmount < 0){
            throw new RuntimeException("Invalid operation");
        }

        this.accountBalance -= moneyChargedEvent.debitAmount;

    }
}
