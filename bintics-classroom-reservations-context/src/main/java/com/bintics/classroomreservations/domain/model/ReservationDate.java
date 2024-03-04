package com.bintics.classroomreservations.domain.model;

import java.time.LocalDateTime;

public record ReservationDate(LocalDateTime value) {
    public static ReservationDate from(LocalDateTime value) {
        return new ReservationDate(value);
    }
}
