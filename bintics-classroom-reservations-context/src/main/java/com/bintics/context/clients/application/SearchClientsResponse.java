package com.bintics.context.clients.application;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class SearchClientsResponse {

    private long total;

    private List<ClientResponse> items;

    @Data
    @AllArgsConstructor
    public static class ClientResponse {
        private String id;
        private String name;
        private String surname;
        private String secondSurname;
        private LocalDate birthDate;
        private String gender;
        private LocalDateTime createdAt;
        private LocalDateTime updatedAt;
    }

}
