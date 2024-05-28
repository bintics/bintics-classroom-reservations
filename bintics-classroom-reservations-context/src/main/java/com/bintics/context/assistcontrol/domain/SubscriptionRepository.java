package com.bintics.context.assistcontrol.domain;

public interface SubscriptionRepository {

    SubscriptionId findCurrentSubscription(ClientId clientId);

}
