package com.bintics.context.clients.domain;

import com.bintics.shared.DomainEvent;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
public class ClientRegisteredEvent extends DomainEvent {

    private final String id;
    private final String name;
    private final String surName;
    private final String secondSurname;
    private final LocalDate birthDate;
    private final String gender;
    private final LocalDateTime createdAt;
    private final LocalDateTime updatedAt;

    public ClientRegisteredEvent(String id, String name, String surName, String secondSurname, LocalDate birthDate, String gender, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.name = name;
        this.surName = surName;
        this.secondSurname = secondSurname;
        this.birthDate = birthDate;
        this.gender = gender;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

}
