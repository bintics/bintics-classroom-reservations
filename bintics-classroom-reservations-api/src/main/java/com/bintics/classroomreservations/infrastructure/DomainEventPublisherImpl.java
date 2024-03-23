package com.bintics.classroomreservations.infrastructure;

import com.bintics.shared.DomainEvent;
import com.bintics.shared.DomainEventPublisher;
import lombok.AllArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@AllArgsConstructor
public class DomainEventPublisherImpl implements DomainEventPublisher {

    private final ApplicationEventPublisher eventPublisher;

    @Override
    public void publish(List<DomainEvent> events) {
        for (var event : events) {
            this.eventPublisher.publishEvent(event);
        }
    }

}
