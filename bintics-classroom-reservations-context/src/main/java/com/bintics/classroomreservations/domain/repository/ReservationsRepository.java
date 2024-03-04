package com.bintics.classroomreservations.domain.repository;

import com.bintics.classroomreservations.domain.model.ClassRoomId;
import com.bintics.classroomreservations.domain.model.Reservation;
import com.bintics.classroomreservations.domain.model.ReservationDate;

import java.time.LocalDateTime;

public interface ReservationsRepository {

    public void save(Reservation reservation);

    Reservation findByDate(ClassRoomId classRoomId, ReservationDate reservationDate);

}
