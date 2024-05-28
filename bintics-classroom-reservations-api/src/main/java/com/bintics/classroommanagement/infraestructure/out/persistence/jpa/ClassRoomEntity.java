package com.bintics.classroommanagement.infraestructure.out.persistence.jpa;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Entity
@Table(name = "class_room")
@Data
public class ClassRoomEntity implements Serializable {

    @Id
    @Column
    private String id;

    @Column
    private String name;

}
