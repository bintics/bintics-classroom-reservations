package com.bintics.classroomreservations.application;

import com.bintics.classroomreservations.domain.model.Reservation;
import com.bintics.classroomreservations.domain.model.ReservationId;
import com.bintics.classroomreservations.domain.repository.ClassRoomRepository;
import com.bintics.classroomreservations.domain.repository.ReservationsRepository;
import com.bintics.classroomreservations.domain.service.ClassRoomFinder;

public class CreateReservationUseCase {

    private final ReservationsRepository repository;
    private final ClassRoomFinder classRoomFinder;

    public CreateReservationUseCase(ReservationsRepository repository, ClassRoomRepository classRoomRepository) {
        this.repository = repository;
        this.classRoomFinder = new ClassRoomFinder(classRoomRepository);
    }

    public void create(CreateReservationRequest request) {
        var classRoomId = this.classRoomFinder.find(request.classRoomId());
        Reservation reservation = Reservation.create(
                ReservationId.from(request.id()),
                classRoomId
        );
        this.repository.save(reservation);
    }

}
