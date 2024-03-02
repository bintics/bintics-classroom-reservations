package com.bintics.classroomreservations.application;

import com.bintics.classroomreservations.domain.model.Reservation;
import com.bintics.classroomreservations.domain.repository.ReservationsRepository;

public class CreateReservationUseCase {

    private final ReservationsRepository repository;

    public CreateReservationUseCase(ReservationsRepository repository) {
        this.repository = repository;
    }

    public void create(CreateReservationRequest request) {
        Reservation reservation = Reservation.create(request.id(), request.classRoomId());
        this.repository.save(reservation);
    }

}
