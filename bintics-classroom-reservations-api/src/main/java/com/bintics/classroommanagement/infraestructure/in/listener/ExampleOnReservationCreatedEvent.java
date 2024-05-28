package com.bintics.classroommanagement.infraestructure.in.listener;

import com.bintics.context.classroomreservations.domain.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ExampleOnReservationCreatedEvent {

    @EventListener
    public void on(ReservationCreatedEvent event) {
        System.out.println(event);
    }

}
