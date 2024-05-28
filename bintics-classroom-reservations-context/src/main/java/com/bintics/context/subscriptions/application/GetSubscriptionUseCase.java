package com.bintics.context.subscriptions.application;

import com.bintics.context.subscriptions.domain.SubscriptionId;
import com.bintics.context.subscriptions.domain.SubscriptionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GetSubscriptionUseCase {

    private final SubscriptionRepository repository;

    public GetSubscriptionResponse get(GetSubscriptionRequest request) {
        var subscription = this.repository.findById(SubscriptionId.from(request.subscriptionId()));
        if (subscription == null) {
            throw new RuntimeException("subscription not found");
        }
        return new GetSubscriptionResponse(
                subscription.getId(),
                subscription.getClientId(),
                subscription.getPlanId(),
                subscription.getCost(),
                subscription.getStartDate(),
                subscription.getEndDate(),
                subscription.getStatus()
        );
    }

}
