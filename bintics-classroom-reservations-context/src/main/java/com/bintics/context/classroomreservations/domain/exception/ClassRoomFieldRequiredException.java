package com.bintics.context.classroomreservations.domain.exception;

public class ClassRoomFieldRequiredException extends RuntimeException {

    public ClassRoomFieldRequiredException(String fieldName) {
        super(String.format("%s field is required.", fieldName));
    }

}
