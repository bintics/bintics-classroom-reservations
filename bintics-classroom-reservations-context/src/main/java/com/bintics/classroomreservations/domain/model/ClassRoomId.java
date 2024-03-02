package com.bintics.classroomreservations.domain.model;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@EqualsAndHashCode
public class ClassRoomId {

    private final String value;

    public ClassRoomId(String value) {
        this.value = value;
    }

}
