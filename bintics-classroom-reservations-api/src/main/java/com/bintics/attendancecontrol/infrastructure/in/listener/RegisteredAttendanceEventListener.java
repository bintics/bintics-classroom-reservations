package com.bintics.attendancecontrol.infrastructure.in.listener;

import com.bintics.attendancecontrol.infrastructure.out.persistence.mongo.AttendanceProjectionDocument;
import com.bintics.attendancecontrol.infrastructure.out.persistence.mongo.AttendanceProjectionRepository;
import com.bintics.clients.infrastructure.percistence.jpa.ClientEntityRepository;
import com.bintics.context.assistcontrol.domain.RegisteredAttendanceEvent;
import com.bintics.subscriptions.infraestructure.out.jpa.SubscriptionEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RegisteredAttendanceEventListener {

    private final AttendanceProjectionRepository attendanceProjectionRepository;

    private final ClientEntityRepository clientEntityRepository;

    private final SubscriptionEntityRepository subscriptionEntityRepository;

    @EventListener
    public void on(RegisteredAttendanceEvent event) {
        var client = this.clientEntityRepository.findById(event.getClientId())
                .map(e -> new AttendanceProjectionDocument.Client(
                        e.getId(),
                        e.getName(),
                        e.getSurname(),
                        e.getSecondSurname()
                )).orElse(null);
        var subscription = this.subscriptionEntityRepository.findById(event.getSubscriptionId())
                .map(e -> new AttendanceProjectionDocument.Subscription(
                        e.getId(),
                        e.getStartDate(),
                        e.getEndDate(),
                        e.getStatus()
                )).orElse(null);
        this.attendanceProjectionRepository.save(new AttendanceProjectionDocument(
                client,
                subscription
        ));
    }

}
