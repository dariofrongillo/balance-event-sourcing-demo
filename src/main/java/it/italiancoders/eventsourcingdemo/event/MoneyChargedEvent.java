package it.italiancoders.eventsourcingdemo.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyChargedEvent extends BaseEvent<String> {

    public final double debitAmount;

    public final String currency;

    public MoneyChargedEvent(String id, double debitAmount, String currency) {
        super(id);
        this.debitAmount = debitAmount;
        this.currency = currency;
    }
}
