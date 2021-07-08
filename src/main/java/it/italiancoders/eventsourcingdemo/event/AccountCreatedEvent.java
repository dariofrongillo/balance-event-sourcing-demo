package it.italiancoders.eventsourcingdemo.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountCreatedEvent extends BaseEvent<String> {

    public final double accountBalance;

    public final String currency;

    public AccountCreatedEvent(String id, double accountBalance, String currency) {
        super(id);
        this.accountBalance = accountBalance;
        this.currency = currency;
    }
}
