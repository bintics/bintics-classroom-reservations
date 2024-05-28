package com.bintics.context.assistcontrol.domain;

public interface AttendSubscriptionRepository {

    SubscriptionId findCurrentSubscription(ClientId clientId);

}
