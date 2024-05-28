package com.bintics.attendancecontrol.infrastructure.out.persistence;

import com.bintics.context.assistcontrol.domain.AttendSubscriptionRepository;
import com.bintics.context.assistcontrol.domain.ClientId;
import com.bintics.context.assistcontrol.domain.SubscriptionId;
import org.springframework.stereotype.Repository;

@Repository
public class SubscriptionRepositoryImpl implements AttendSubscriptionRepository {

    @Override
    public SubscriptionId findCurrentSubscription(ClientId clientId) {
        // TODO: Obtener id de suscripción actual al api de suscripciones.
        return new SubscriptionId("c98d720e-b62c-4711-98aa-cb7fca369386");
    }

}
