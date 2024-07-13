package com.bintics.clients.infrastructure.api;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
public class SearchClientHttpResponse {

    private long total;

    private List<ClientHttpResponse> items;

    @Data
    @AllArgsConstructor
    public static class ClientHttpResponse {
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
