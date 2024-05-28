package com.bintics.context.subscriptions.domain;

public interface SubscriptionRepository {

    Subscription findById(SubscriptionId id);

}
