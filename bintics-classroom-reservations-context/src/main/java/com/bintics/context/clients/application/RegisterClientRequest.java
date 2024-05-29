package com.bintics.context.clients.application;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class RegisterClientRequest {

    private String name;
    private String surname;
    private String secondSurname;
    private LocalDate birthDate;
    private String gender;

}
