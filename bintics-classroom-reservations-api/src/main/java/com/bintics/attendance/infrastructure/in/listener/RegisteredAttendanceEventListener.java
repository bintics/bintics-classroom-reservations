package com.bintics.attendance.infrastructure.in.listener;

import com.bintics.attendance.infrastructure.out.persistence.mongo.AttendanceProjectionDocument;
import com.bintics.attendance.infrastructure.out.persistence.mongo.AttendanceProjectionRepository;
import com.bintics.clients.infrastructure.percistence.jpa.ClientEntityRepository;
import com.bintics.context.assistcontrol.domain.RegisteredAttendanceEvent;
import com.bintics.subscriptions.infraestructure.out.jpa.SubscriptionEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;

@Component
@AllArgsConstructor
public class RegisteredAttendanceEventListener {

    private final ClientEntityRepository clientEntityRepository;

    private final SubscriptionEntityRepository subscriptionEntityRepository;

    private final MongoTemplate template;

    @EventListener
    public void on(RegisteredAttendanceEvent event) {
        var client = this.clientEntityRepository.findById(event.getClientId())
                .map(e -> new AttendanceProjectionDocument.Client(
                        e.getId(),
                        e.getName(),
                        e.getSurname(),
                        e.getSecondSurname()
                )).orElse(null);
        var subscription = this.subscriptionEntityRepository.findById(event.getSubscriptionId())
                .map(e -> new AttendanceProjectionDocument.Subscription(
                        e.getId(),
                        e.getStartDate(),
                        e.getEndDate(),
                        e.getStatus()
                )).orElse(null);
        var attendance = new AttendanceProjectionDocument(
                client,
                subscription,
                event.getCheckIn(),
                event.getCheckOut()
        );

        var attendedDate = event.getCheckIn();
        String formatCollectionName = String.format("attendance_%s_%s_%s",
                getNumWithTwoDigits(attendedDate, "YYYY"),
                getNumWithTwoDigits(attendedDate, "MM"),
                getNumWithTwoDigits(attendedDate, "dd"));
        this.template.save(attendance, formatCollectionName);
    }

    public static String getNumWithTwoDigits(Date date, String format) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
        return localDate.format(formatter);
    }

}
