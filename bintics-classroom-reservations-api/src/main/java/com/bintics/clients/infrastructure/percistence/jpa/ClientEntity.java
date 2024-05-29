package com.bintics.clients.infrastructure.percistence.jpa;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable {

    @Id
    private String id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String secondSurname;

    @Column
    private String gender;

    @Column
    private LocalDate birthDate;

    @Column
    private LocalDateTime createdAt;

    @Column
    private LocalDateTime updatedAt;

}
