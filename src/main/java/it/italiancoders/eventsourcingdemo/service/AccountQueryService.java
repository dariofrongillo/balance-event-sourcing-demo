package it.italiancoders.eventsourcingdemo.service;

import java.util.List;

public interface AccountQueryService {
    List<Object> listEventsForAccount(String accountNumber);
}
