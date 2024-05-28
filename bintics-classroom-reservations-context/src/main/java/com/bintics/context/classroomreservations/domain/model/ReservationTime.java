package com.bintics.context.classroomreservations.domain.model;

import com.bintics.context.classroomreservations.domain.exception.ClassRoomException;
import com.bintics.context.classroomreservations.domain.exception.ClassRoomFieldRequiredException;

import java.time.temporal.ChronoUnit;

public record ReservationTime(Time unit, int time) {

    public static ReservationTime from(String unit, Integer time) {
        if (unit == null) {
            throw new ClassRoomFieldRequiredException("unit");
        }
        if (unit != null && unit.trim().length() == 0) {
            throw new ClassRoomFieldRequiredException("unit");
        }
        if (time == null) {
            throw new ClassRoomFieldRequiredException("time");
        }
        if (time <= 0) {
            throw new ClassRoomException("time can not is zero");
        }
        for (var u : Time.values()) {
            var uu = u.toString();
            var un = unit.trim().toLowerCase();
            if (uu.equals(un)) {
                return new ReservationTime(u, time);
            }
        }
        throw new RuntimeException("no valid reservation time");
    }

    public ChronoUnit getUnit() {
        return switch (this.unit) {
            case SEC -> ChronoUnit.SECONDS;
            case MIN -> ChronoUnit.MINUTES;
            case HOURS -> ChronoUnit.HOURS;
        };
    }

    public enum Time {
        SEC("sec"),
        MIN("min"),
        HOURS("hours");

        String unit;

        Time(String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return this.unit.toLowerCase();
        }
    }

}
