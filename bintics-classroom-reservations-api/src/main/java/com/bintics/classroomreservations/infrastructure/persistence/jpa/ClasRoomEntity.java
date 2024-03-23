package com.bintics.classroomreservations.infrastructure.persistence.jpa;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
public class ClasRoomEntity implements Serializable {

    @Id
    private String id;

}
