package com.bintics.context.classroomreservations.application;

import java.time.LocalDateTime;

public record CreateReservationRequest(
        String id,
        String classRoomId,
        LocalDateTime reservationDate,
        String unitTime,
        Integer time) {
}
