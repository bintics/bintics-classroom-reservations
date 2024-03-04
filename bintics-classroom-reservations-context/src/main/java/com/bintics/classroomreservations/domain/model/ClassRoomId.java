package com.bintics.classroomreservations.domain.model;


public record ClassRoomId(String value) {

    public ClassRoomId {
        if (value == null) {
            throw new RuntimeException("class_room_id is required");
        }
    }

}
