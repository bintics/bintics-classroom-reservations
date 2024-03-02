package com.bintics.classroomreservations.domain.repository;

import com.bintics.classroomreservations.domain.model.Reservation;

public interface ReservationsRepository {

    public void save(Reservation reservation);

}
