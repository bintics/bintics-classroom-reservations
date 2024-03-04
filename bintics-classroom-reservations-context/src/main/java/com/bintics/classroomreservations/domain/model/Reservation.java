package com.bintics.classroomreservations.domain.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Reservation {

    private final ReservationId id;
    private final ClassRoomId classRoomId;
    private final ReservationDate reservationDate;

    public Reservation(ReservationId id, ClassRoomId classRoomId, ReservationDate reservationDate) {
        this.id = id;
        this.classRoomId = classRoomId;
        this.reservationDate = reservationDate;
    }

    public static Reservation create(ReservationId id, ClassRoomId classRoomId, ReservationDate reservationDate) {
        return new Reservation(id, classRoomId, reservationDate);
    }

    public String id() {
        return this.id.value();
    }

    public String classRoomId() {
        return this.classRoomId.value();
    }

}
