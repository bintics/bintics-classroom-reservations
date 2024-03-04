package com.bintics.classroomreservations.domain.model;

import lombok.EqualsAndHashCode;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Reservation {

    private ReservationId id;

    private ClassRoomId classRoomId;

    public Reservation(ReservationId id, ClassRoomId classRoomId) {
        this.id = id;
        this.classRoomId = classRoomId;
    }

    public static Reservation create(ReservationId id, ClassRoomId classRoomId) {
        return new Reservation(id, classRoomId);
    }

    public String id() {
        return this.id.value();
    }

    public String classRoomId() {
        return this.classRoomId.value();
    }

}
