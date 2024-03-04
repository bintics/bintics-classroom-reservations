package com.bintics.classroomreservations.domain.model;

public record ReservationId(String value) {

    public ReservationId {
        if (value == null) {
            throw new RuntimeException("reservation_id is required");
        }
    }

    public static ReservationId from(String id) {
        return new ReservationId(id);
    }

}
