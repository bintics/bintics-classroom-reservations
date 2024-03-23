package com.bintics.context.classroomreservations.domain.model;

public record ReservationStatus(Status status) {

    public enum Status {
        RESERVED,
        CANCELED
    }

}
