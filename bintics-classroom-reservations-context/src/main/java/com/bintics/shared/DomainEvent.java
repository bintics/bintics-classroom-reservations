package com.bintics.shared;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DomainEvent {

    private final String eventId;
    private final LocalDateTime createdEvent;

    protected DomainEvent() {
        this.eventId = UUID.randomUUID().toString();
        this.createdEvent = LocalDateTime.now();
    }

}
