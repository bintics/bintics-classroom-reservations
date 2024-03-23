package com.bintics.shared;

import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class DomainEvent {

    private final LocalDateTime createdEvent;

    protected DomainEvent() {
        this.createdEvent = LocalDateTime.now();
    }

}
