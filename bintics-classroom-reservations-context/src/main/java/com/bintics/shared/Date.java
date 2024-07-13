package com.bintics.shared;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public record Date(LocalDateTime value) {

    public Date {
        if (value == null) {
            throw new FieldRequiredException("date");
        }
        ZonedDateTime utcDateTime = value.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC"));
        value = utcDateTime.toLocalDateTime();
    }

    public static Date now() {
        return new Date(LocalDateTime.now());
    }

    public java.util.Date toDate() {
        Instant instant = this.value.atZone(ZoneId.systemDefault()).withZoneSameInstant(ZoneId.of("UTC")).toInstant();
        return java.util.Date.from(instant);
    }

}
