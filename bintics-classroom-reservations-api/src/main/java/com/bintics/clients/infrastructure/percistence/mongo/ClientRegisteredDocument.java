package com.bintics.clients.infrastructure.percistence.mongo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Document("client_registered_events")
@AllArgsConstructor
@NoArgsConstructor
public class ClientRegisteredDocument {

    private String id;
    private String name;
    private String surname;
    private String secondSurname;
    private LocalDate birthDate;
    private String gender;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private String eventId;
    private LocalDateTime eventCreatedAt;
    private int eventVersion;

}
