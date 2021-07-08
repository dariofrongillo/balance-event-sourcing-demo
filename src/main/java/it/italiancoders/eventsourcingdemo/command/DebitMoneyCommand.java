package it.italiancoders.eventsourcingdemo.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DebitMoneyCommand extends BaseCommand<String> {

    public final double debitAmount;

    public final String currency;

    public DebitMoneyCommand(String id, double creditAmount, String currency) {
        super(id);
        this.debitAmount = creditAmount;
        this.currency = currency;
    }
}
