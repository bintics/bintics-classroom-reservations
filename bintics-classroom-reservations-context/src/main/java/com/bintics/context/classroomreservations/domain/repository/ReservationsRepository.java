package com.bintics.context.classroomreservations.domain.repository;

import com.bintics.context.classroomreservations.domain.model.ClassRoomId;
import com.bintics.context.classroomreservations.domain.model.Reservation;
import com.bintics.context.classroomreservations.domain.model.ReservationDate;

public interface ReservationsRepository {

    public void save(Reservation reservation);

    Reservation findByDate(ClassRoomId classRoomId, ReservationDate reservationDate);

}
