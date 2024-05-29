package com.bintics.context.subscriptions.application;

import com.bintics.context.subscriptions.domain.SubscriptionRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SearchSubscriptionUseCase {

    private final SubscriptionRepository repository;

    public SearchSubscriptionResponse search(SearchSubscriptionRequest request) {
        return this.repository.search(request);
    }

}
