package com.bintics.context.assistcontrol.domain;

public interface AttendanceSubscriptionRepository {

    SubscriptionId findCurrentSubscription(ClientId clientId);

}
