package com.bintics.clients.infrastructure.listener;

import com.bintics.clients.infrastructure.percistence.mongo.ClientCreatedEventsStore;
import com.bintics.clients.infrastructure.percistence.mongo.ClientRegisteredDocument;
import com.bintics.context.clients.domain.ClientRegisteredEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ClientCreatedEventListener {

    private final ClientCreatedEventsStore store;

    @EventListener
    public void on(ClientRegisteredEvent event) {
        this.store.save(new ClientRegisteredDocument(
                event.getId(),
                event.getName(),
                event.getSurname(),
                event.getSecondSurname(),
                event.getBirthDate(),
                event.getGender(),
                event.getCreatedAt(),
                event.getUpdatedAt(),
                event.getEventId(),
                event.getEventCreatedAt(),
                event.getEventVersion()
        ));
    }

}
