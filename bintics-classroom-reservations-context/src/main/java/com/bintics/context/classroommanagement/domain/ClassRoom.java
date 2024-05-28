package com.bintics.context.classroommanagement.domain;


import com.bintics.shared.RootAggregate;
import lombok.Getter;

import java.util.UUID;

public class ClassRoom extends RootAggregate {

    @Getter
    private final String name;

    @Getter
    private final String id;

    public ClassRoom(String id, String name) {
        this.name = name;
        this.id = id;
    }

    public static ClassRoom create(String name) {
        if (name == null) {
            throw new ClassRoomManagementException("name is required");
        }
        if (name != null && name.isEmpty()) {
            throw new ClassRoomManagementException("name is required");
        }
        ClassRoom classroom = new ClassRoom(UUID.randomUUID().toString(), name);
        classroom.record(new ClassRoomCreatedEvent(
                classroom.getId(),
                classroom.getName()
        ));
        return classroom;
    }

}
