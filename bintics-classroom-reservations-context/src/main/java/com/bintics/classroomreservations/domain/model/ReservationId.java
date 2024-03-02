package com.bintics.classroomreservations.domain.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ReservationId {

    private final String value;

    public ReservationId(String value) {
        this.value = value;
    }

}
