package it.italiancoders.eventsourcingdemo.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreditMoneyCommand extends BaseCommand<String> {

    public final double creditAmount;

    public final String currency;

    public CreditMoneyCommand(String id, double creditAmount, String currency) {
        super(id);
        this.creditAmount = creditAmount;
        this.currency = currency;
    }
}
