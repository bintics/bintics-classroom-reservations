package com.bintics.context.clients.domain;

public record ClientName(String value) {
    public ClientName {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("name is required");
        }
    }
}
