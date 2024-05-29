package com.bintics.context.clients.domain;

public record ClientId(String value) {
    public ClientId {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("client_id is required");
        }
    }
}
