package it.italiancoders.eventsourcingdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AccountCreateDTO {
    private double startingBalance;

    private String currency;
}
