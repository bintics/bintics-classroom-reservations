package com.bintics.shared;

import com.bintics.context.classroomreservations.domain.exception.ClassRoomFieldRequiredException;

import java.time.LocalDateTime;

public record Date(LocalDateTime value) {

    public Date {
        if (value == null) {
            throw new ClassRoomFieldRequiredException("date");
        }
    }

    public static Date now() {
        return new Date(LocalDateTime.now());
    }

}
