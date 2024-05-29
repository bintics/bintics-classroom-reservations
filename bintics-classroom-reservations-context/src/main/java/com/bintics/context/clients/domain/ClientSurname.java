package com.bintics.context.clients.domain;

public record ClientSurname(String value) {

    public ClientSurname {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("surname is required");
        }
    }

}
