package com.bintics.context.classroomreservations.domain.exception;

public class ClassRoomReservationAlreadyExistsException extends RuntimeException {

    public ClassRoomReservationAlreadyExistsException() {
        super("reservation already exists");
    }
}
