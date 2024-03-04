package com.bintics.classroomreservations.domain.exception;

public class ClassRoomNotFoundException extends RuntimeException {

    public ClassRoomNotFoundException(String id) {
        super(String.format("class room not found: [%s]", id));
    }

}
