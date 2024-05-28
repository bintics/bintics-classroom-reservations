package com.bintics.subscriptions.infraestructure.out;

import com.bintics.context.subscriptions.domain.Subscription;
import com.bintics.context.subscriptions.domain.SubscriptionId;
import com.bintics.context.subscriptions.domain.SubscriptionRepository;
import com.bintics.subscriptions.infraestructure.out.jpa.SubscriptionEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

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
                        e.getCost(),
                        e.getStartDate(),
                        e.getEndDate()
                )
        ).orElse(null);
    }

}
