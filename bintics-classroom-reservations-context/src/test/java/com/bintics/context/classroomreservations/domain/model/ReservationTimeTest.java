package com.bintics.context.classroomreservations.domain.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReservationTimeTest {

    @Test
    void from() {
        var reservationTime = ReservationTime.from("sec", 1);
        assertNotNull(reservationTime, "no debería ser nulo");
        assertEquals(1, reservationTime.time());
        assertEquals(ReservationTime.Time.SEC, reservationTime.unit());
    }

}