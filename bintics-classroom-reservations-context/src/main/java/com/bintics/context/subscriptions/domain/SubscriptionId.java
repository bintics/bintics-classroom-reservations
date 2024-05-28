package com.bintics.context.subscriptions.domain;

public record SubscriptionId(String value) {

    public SubscriptionId {
        if (value == null || value.isEmpty()) {
            throw new RuntimeException("subscription_id is required");
        }
    }

    public static SubscriptionId from(String value) {
        return new SubscriptionId(value);
    }

}
