package com.bintics.classroomreservations.infrastructure.in.listener;

import com.bintics.classroomreservations.infrastructure.out.persistence.jpa.ClasRoomEntity;
import com.bintics.classroomreservations.infrastructure.out.persistence.jpa.ClassRoomEntityRepository;
import com.bintics.context.classroommanagement.domain.ClassRoomCreatedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class RecordClassRoomOnClassRoomCreatedEvent {

    private final ClassRoomEntityRepository repository;

    @EventListener
    public void on(ClassRoomCreatedEvent event) {
        ClasRoomEntity entity = new ClasRoomEntity();
        entity.setId(event.getId());
        this.repository.save(entity);
    }

}
