package com.bintics.context.subscriptions.application;

import com.bintics.context.subscriptions.domain.SubscriptionId;
import com.bintics.context.subscriptions.domain.SubscriptionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetSubscriptionUseCase {

    private final SubscriptionRepository repository;

    public GetSubscriptionResponse get(GetSubscriptionRequest request) {
        var subscription = this.repository.findById(SubscriptionId.from(request.subscriptionId()));
        return new GetSubscriptionResponse(
                subscription.getId(),
                subscription.getClientId(),
                subscription.getCost(),
                subscription.getStartDate(),
                subscription.getEndDate()
        );
    }

}
