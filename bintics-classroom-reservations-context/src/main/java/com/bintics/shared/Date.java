package com.bintics.shared;

import com.bintics.context.classroomreservations.domain.exception.ClassRoomFieldRequiredException;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public record Date(LocalDateTime value) {

    public Date {
        if (value == null) {
            throw new ClassRoomFieldRequiredException("date");
        }
    }

    public static Date now() {
        return new Date(LocalDateTime.now());
    }

    public java.util.Date toDate() {
        Instant instant = this.value.atZone(ZoneId.systemDefault()).toInstant();
        return java.util.Date.from(instant);
    }
}
