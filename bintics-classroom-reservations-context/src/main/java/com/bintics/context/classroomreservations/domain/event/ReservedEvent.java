package com.bintics.context.classroomreservations.domain.event;

import com.bintics.shared.DomainEvent;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@ToString
@EqualsAndHashCode
public class ReservedEvent extends DomainEvent {

    private final String id;
    private final String classRoomId;
    private final LocalDateTime reservationDate;
    private final LocalDateTime updatedAt;

    public ReservedEvent(String id, String classRoomId, LocalDateTime reservationDate, LocalDateTime updatedAt) {
        super();
        this.id = id;
        this.classRoomId = classRoomId;
        this.reservationDate = reservationDate;
        this.updatedAt = updatedAt;
    }

}
