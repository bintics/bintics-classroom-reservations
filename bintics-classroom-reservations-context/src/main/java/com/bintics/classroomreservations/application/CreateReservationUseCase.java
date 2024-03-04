package com.bintics.classroomreservations.application;

import com.bintics.classroomreservations.domain.model.ClassRoomId;
import com.bintics.classroomreservations.domain.model.Reservation;
import com.bintics.classroomreservations.domain.model.ReservationDate;
import com.bintics.classroomreservations.domain.model.ReservationId;
import com.bintics.classroomreservations.domain.repository.ClassRoomRepository;
import com.bintics.classroomreservations.domain.repository.ReservationsRepository;
import com.bintics.classroomreservations.domain.service.ClassRoomFinder;

import java.time.LocalDateTime;

public class CreateReservationUseCase {

    private final ReservationsRepository repository;
    private final ClassRoomFinder classRoomFinder;

    public CreateReservationUseCase(ReservationsRepository repository, ClassRoomRepository classRoomRepository) {
        this.repository = repository;
        this.classRoomFinder = new ClassRoomFinder(classRoomRepository);
    }

    public void create(CreateReservationRequest request) {
        var classRoomId = this.classRoomFinder.find(request.classRoomId());
        var reservationDate = ReservationDate.from(request.reservationDate());

        this.ensureNoExistsReservation(classRoomId, reservationDate);

        Reservation reservation = Reservation.create(
                ReservationId.from(request.id()),
                classRoomId,
                reservationDate
        );
        this.repository.save(reservation);
    }

    private void ensureNoExistsReservation(ClassRoomId classRoomId, ReservationDate reservationDate) {
        Reservation existsReservation = this.repository.findByDate(classRoomId, reservationDate);
        if (existsReservation != null) {
            throw new RuntimeException("reservation already exists");
        }
    }

}
