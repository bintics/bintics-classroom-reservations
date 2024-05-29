package com.bintics.context.clients.domain;

public record ClientSecondSurname(String value) {

    public ClientSecondSurname {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("second_surname is required");
        }
    }

}
