package com.bintics.classroomreservations.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@ToString
@EqualsAndHashCode
public class Reservation {

    private ReservationId id;

    private ClassRoomId classRoomId;

    public Reservation(String id, String classRoomId) {
        this.id = new ReservationId(id);
        this.classRoomId = new ClassRoomId(classRoomId);
    }

    public static Reservation create(String id, String classRoomId) {
        return new Reservation(id, classRoomId);
    }

    public String getId() {
        return this.id.getValue();
    }

    public String getClassRoomId() {
        return this.classRoomId.getValue();
    }

}
