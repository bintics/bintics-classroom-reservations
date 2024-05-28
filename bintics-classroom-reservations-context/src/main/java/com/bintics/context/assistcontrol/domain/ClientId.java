package com.bintics.context.assistcontrol.domain;

public record ClientId(String value) {

    public ClientId {
        if (value == null) {
            throw new RuntimeException("client_id is required");
        }
    }

    public static ClientId from(String value) {
        return new ClientId(value);
    }

}
