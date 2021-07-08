package it.italiancoders.eventsourcingdemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MoneyCreditDTO {
    private double creditAmount;

    private String currency;
}
