package com.bintics.classroomreservations.infrastructure.persistence;

import com.bintics.context.classroomreservations.domain.model.ClassRoomId;
import com.bintics.context.classroomreservations.domain.model.Reservation;
import com.bintics.context.classroomreservations.domain.model.ReservationDate;
import com.bintics.context.classroomreservations.domain.repository.ReservationsRepository;
import com.bintics.classroomreservations.infrastructure.persistence.jpa.ClassRoomReservationEntity;
import com.bintics.classroomreservations.infrastructure.persistence.jpa.ClassRoomReservationEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
@AllArgsConstructor
public class ClassRoomReservationRepositoryImpl implements ReservationsRepository {

    private final ClassRoomReservationEntityRepository repository;

    @Override
    public void save(Reservation reservation) {
        var entity = new ClassRoomReservationEntity();
        entity.setId(reservation.id());
        entity.setClassRoomId(reservation.classRoomId());
        var date = new Date();
        entity.setCreatedAt(date);
        entity.setUpdatedAt(date);
        this.repository.save(entity);
    }

    @Override
    public Reservation findByDate(ClassRoomId classRoomId, ReservationDate reservationDate) {
        //this.repository.
        return null;
    }

}
