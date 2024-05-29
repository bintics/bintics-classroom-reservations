package com.bintics.subscriptions.infraestructure.out;

import com.bintics.context.subscriptions.application.SearchSubscriptionRequest;
import com.bintics.context.subscriptions.application.SearchSubscriptionResponse;
import com.bintics.context.subscriptions.domain.Subscription;
import com.bintics.context.subscriptions.domain.SubscriptionId;
import com.bintics.context.subscriptions.domain.SubscriptionRepository;
import com.bintics.subscriptions.infraestructure.out.jpa.SubscriptionEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.stream.Collectors;

@Repository
@AllArgsConstructor
public class SubscriptionsRepositoryImpl implements SubscriptionRepository {

    private final SubscriptionEntityRepository repository;

    @Override
    public Subscription findById(SubscriptionId id) {
        return this.repository.findById(id.value()).map(e ->
                new Subscription(
                        SubscriptionId.from(e.getId()),
                        e.getClientId(),
                        e.getPlanId(),
                        e.getCost(),
                        e.getStartDate(),
                        e.getEndDate(),
                        e.getStatus()
                )
        ).orElse(null);
    }

    @Override
    public SearchSubscriptionResponse search(SearchSubscriptionRequest request) {
        var items = this.repository.search(
                request.id(),
                request.planId(),
                request.cost(),
                request.status(),
                request.startDate(),
                request.endDate()
        ).stream().map(
                e -> new SearchSubscriptionResponse.SearchResponse(
                        e.getId(),
                        e.getClientId(),
                        e.getPlanId(),
                        e.getCost(),
                        e.getStatus(),
                        e.getStartDate(),
                        e.getEndDate()
                )
        ).collect(Collectors.toList());
        return new SearchSubscriptionResponse(items);
    }

}
