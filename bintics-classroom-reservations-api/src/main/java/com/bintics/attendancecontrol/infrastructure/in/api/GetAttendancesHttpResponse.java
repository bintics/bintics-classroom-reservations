package com.bintics.attendancecontrol.infrastructure.in.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAttendancesHttpResponse {

    private List<AttendanceHttpResponse> items = new LinkedList<>();

    @Getter
    @AllArgsConstructor
    public static class AttendanceHttpResponse {

        private final Client client;

        private final Subscription subscription;

        public record Client(
                String id,
                String name,
                String surname,
                String secondSurname
        ) {
        }

        public record Subscription(
                String id,
                Date subStartDate,
                Date subEndDate,
                String subStatus
        ) {
        }

    }

}
