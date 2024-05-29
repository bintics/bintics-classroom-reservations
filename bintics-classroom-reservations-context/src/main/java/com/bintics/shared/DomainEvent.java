package com.bintics.shared;

import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
public class DomainEvent {

    private final String eventId = UUID.randomUUID().toString();
    private final LocalDateTime createdEvent = LocalDateTime.now();
    protected int version = 1;

}
