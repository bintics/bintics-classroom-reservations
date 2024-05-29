package com.bintics.attendancecontrol.infrastructure.out.persistence;

import com.bintics.context.assistcontrol.domain.AttendSubscriptionRepository;
import com.bintics.context.assistcontrol.domain.ClientId;
import com.bintics.context.assistcontrol.domain.SubscriptionId;
import com.bintics.context.subscriptions.application.SearchSubscriptionRequest;
import com.bintics.context.subscriptions.domain.SubscriptionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AttendSubscriptionRepositoryImpl implements AttendSubscriptionRepository {

    private final SubscriptionRepository repository;

    @Override
    public SubscriptionId findCurrentSubscription(ClientId clientId) {
        // TODO: Obtener id de suscripción actual al api de suscripciones.
        var result = this.repository.search(
                new SearchSubscriptionRequest(
                        null,
                        clientId.value(),
                        null,
                        null,
                        null,
                        null,
                        null
                )
        );
        var subscription = result.items().get(0);
        return new SubscriptionId(subscription.id());
    }

}
