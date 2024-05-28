package com.bintics.context.assistcontrol.domain;

public record SubscriptionId(String value) {

    public SubscriptionId {
        if (value == null) {
            throw new RuntimeException("subscription_id is required");
        }
    }

}
