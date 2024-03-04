package com.bintics.classroomreservations.application;

import java.time.LocalDateTime;

public record CreateReservationRequest(String id, String classRoomId, LocalDateTime reservationDate) {
}
