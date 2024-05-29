package com.bintics.context.subscriptions.domain;

import com.bintics.context.subscriptions.application.SearchSubscriptionRequest;
import com.bintics.context.subscriptions.application.SearchSubscriptionResponse;

public interface SubscriptionRepository {

    Subscription findById(SubscriptionId id);

    SearchSubscriptionResponse search(SearchSubscriptionRequest request);

}
