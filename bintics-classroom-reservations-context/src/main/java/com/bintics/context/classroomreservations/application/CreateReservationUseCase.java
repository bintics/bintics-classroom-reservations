package com.bintics.context.classroomreservations.application;

import com.bintics.context.classroomreservations.domain.exception.ClassRoomReservationAlreadyExistsException;
import com.bintics.context.classroomreservations.domain.model.*;
import com.bintics.context.classroomreservations.domain.repository.ClassRoomRepository;
import com.bintics.context.classroomreservations.domain.repository.ReservationsRepository;
import com.bintics.context.classroomreservations.domain.service.ClassRoomFinder;
import com.bintics.shared.DomainEventPublisher;

public class CreateReservationUseCase {

    private final ReservationsRepository repository;
    private final ClassRoomFinder classRoomFinder;
    private final DomainEventPublisher domainEventPublisher;


    public CreateReservationUseCase(ReservationsRepository repository, ClassRoomRepository classRoomRepository, DomainEventPublisher domainEventPublisher) {
        this.repository = repository;
        this.classRoomFinder = new ClassRoomFinder(classRoomRepository);
        this.domainEventPublisher = domainEventPublisher;
    }

    public void create(CreateReservationRequest request) {
        var classRoomId = this.classRoomFinder.find(request.classRoomId());
        var reservationDate = ReservationDate.from(request.reservationDate());
        var time = ReservationTime.from(request.unitTime(), request.time());

        this.ensureNoExistsReservation(classRoomId, reservationDate);

        Reservation reservation = Reservation.create(
                ReservationId.from(request.id()),
                classRoomId,
                reservationDate,
                time
        );
        this.repository.save(reservation);
        this.domainEventPublisher.publish(reservation.pullEvents());
    }

    private void ensureNoExistsReservation(ClassRoomId classRoomId, ReservationDate reservationDate) {
        Reservation existsReservation = this.repository.findByDate(classRoomId, reservationDate);
        if (existsReservation != null) {
            throw new ClassRoomReservationAlreadyExistsException();
        }
    }

}
