package com.bintics.context.classroomreservations.domain.model;

import com.bintics.context.classroomreservations.domain.event.ReservedEvent;
import com.bintics.shared.Date;
import com.bintics.shared.RootAggregate;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.ZoneId;

@ToString
@EqualsAndHashCode
public class Reservation extends RootAggregate {

    private final ReservationId id;
    private final ClassRoomId classRoomId;
    private final ReservationTime time;
    private final ReservationStatus status;
    private final ReservationDate reservationDate;
    private final Date updatedAt;

    public Reservation(ReservationId id, ClassRoomId classRoomId, ReservationDate reservationDate, ReservationTime time, ReservationStatus status, Date createdAt, Date updatedAt) {
        this.id = id;
        this.classRoomId = classRoomId;
        this.reservationDate = reservationDate;
        this.time = time;
        this.status = status;
        this.updatedAt = updatedAt;
    }

    public static Reservation create(ReservationId id, ClassRoomId classRoomId, ReservationDate reservationDate, ReservationTime time) {
        var now = Date.now();
        var model = new Reservation(id,
                classRoomId,
                reservationDate,
                time,
                new ReservationStatus(ReservationStatus.Status.RESERVED),
                now,
                now
        );
        model.record(new ReservedEvent(
                model.id.value(),
                classRoomId.value(),
                reservationDate.value(),
                model.updatedAt.value()
        ));
        return model;
    }

    public String id() {
        return this.id.value();
    }

    public String classRoomId() {
        return this.classRoomId.value();
    }

    public java.util.Date expectedEndDateTime() {
        var to = this.reservationDate.value().plus(this.time.time(), this.time.getUnit());
        long timestamp = to.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
        return new java.util.Date(timestamp);
    }

}
