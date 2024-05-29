package com.bintics.clients.infrastructure.api;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RegisterClientHttpRequest {

    private String name;
    private String surname;
    private String secondSurname;
    private LocalDate birthDate;
    private String gender;

}
