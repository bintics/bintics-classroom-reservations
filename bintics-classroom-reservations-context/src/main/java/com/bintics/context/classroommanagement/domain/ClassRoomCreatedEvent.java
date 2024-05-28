package com.bintics.context.classroommanagement.domain;

import com.bintics.shared.DomainEvent;
import lombok.Getter;

@Getter
public class ClassRoomCreatedEvent extends DomainEvent {

    private final String id;
    private final String name;

    public ClassRoomCreatedEvent(String id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

}
