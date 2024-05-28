package com.bintics.classroomreservations.infrastructure.out.persistence;

import com.bintics.classroomreservations.infrastructure.out.persistence.jpa.ClassRoomReservationEntity;
import com.bintics.classroomreservations.infrastructure.out.persistence.jpa.ClassRoomReservationEntityRepository;
import com.bintics.context.classroomreservations.domain.model.ClassRoomId;
import com.bintics.context.classroomreservations.domain.model.Reservation;
import com.bintics.context.classroomreservations.domain.model.ReservationDate;
import com.bintics.context.classroomreservations.domain.repository.ReservationsRepository;
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
        //TODO: obtener el estatis del root aggregate
        entity.setStatus("pending");
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
