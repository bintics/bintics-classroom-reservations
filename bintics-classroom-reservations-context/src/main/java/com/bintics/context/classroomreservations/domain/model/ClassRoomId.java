package com.bintics.context.classroomreservations.domain.model;


import com.bintics.context.classroomreservations.domain.exception.ClassRoomFieldRequiredException;

public record ClassRoomId(String value) {

    public ClassRoomId {
        if (value == null) {
            throw new ClassRoomFieldRequiredException("class_room_id");
        }
    }

}
