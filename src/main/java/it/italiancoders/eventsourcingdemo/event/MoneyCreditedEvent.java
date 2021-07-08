package it.italiancoders.eventsourcingdemo.event;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MoneyCreditedEvent extends BaseEvent<String> {

    public final double creditAmount;

    public final String currency;

    public MoneyCreditedEvent(String id, double creditAmount, String currency) {
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }
}
