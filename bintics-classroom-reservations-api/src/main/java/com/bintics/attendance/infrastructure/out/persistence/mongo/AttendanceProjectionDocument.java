package com.bintics.attendance.infrastructure.out.persistence.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;

@Data
@Document("attendance_projection")
@AllArgsConstructor
public class AttendanceProjectionDocument {

    private final Client client;

    private final Subscription subscription;

    public record Client(
            String clientId,
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

    private Date checkIn;
    private Date checkOut;

}
