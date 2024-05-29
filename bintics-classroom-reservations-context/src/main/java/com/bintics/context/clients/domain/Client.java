package com.bintics.context.clients.domain;

import com.bintics.shared.Date;
import com.bintics.shared.RootAggregate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public class Client extends RootAggregate {

    private final ClientId id;
    private final ClientName name;
    private final ClientSurname surname;
    private final ClientSecondSurname secondSurname;
    private final LocalDate birthDate;
    private final ClientGender gender;
    private final Date createdAt;
    private final Date updatedAt;

    public Client(String id, String name, String surname, String secondSurname, LocalDate birthDate, String gender, Date createdAt, Date updatedAt) {
        this.id = new ClientId(id);
        this.name = new ClientName(name);
        this.surname = new ClientSurname(surname);
        this.secondSurname = new ClientSecondSurname(secondSurname);
        this.birthDate = birthDate;
        this.gender = new ClientGender(gender);
        this.createdAt = createdAt;
        this.updatedAt = createdAt;
    }

    public static Client register(String name, String surName, String secondSurname, LocalDate birthDate, String gender) {
        var now = Date.now();
        var root = new Client(
                UUID.randomUUID().toString(),
                name,
                surName,
                secondSurname,
                birthDate,
                gender,
                now,
                now
        );
        root.record(new ClientRegisteredEvent(
                root.id(),
                root.name(),
                root.surname(),
                root.secondSurname(),
                root.birthDate(),
                root.gender(),
                root.createdAt(),
                root.updatedAt()
        ));
        return root;
    }

    public String id() {
        return this.id.value();
    }

    public String name() {
        return this.name.value();
    }

    public String surname() {
        return this.surname.value();
    }

    public String secondSurname() {
        return this.secondSurname.value();
    }

    public String gender() {
        return this.gender.value();
    }

    public LocalDate birthDate() {
        return this.birthDate;
    }

    public LocalDateTime createdAt() {
        return this.createdAt.value();
    }

    public LocalDateTime updatedAt() {
        return this.updatedAt.value();
    }

}
