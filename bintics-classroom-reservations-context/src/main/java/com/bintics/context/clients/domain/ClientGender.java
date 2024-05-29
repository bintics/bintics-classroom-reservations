package com.bintics.context.clients.domain;

public record ClientGender(String value) {

    public ClientGender {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("gender is required");
        }
        value = value.trim().toUpperCase();
        switch (value) {
            case "MALE":
            case "FEMALE":
            case "OTHER":
                break;
            default:
                throw new RuntimeException("gender no valid");
        }
    }

}
