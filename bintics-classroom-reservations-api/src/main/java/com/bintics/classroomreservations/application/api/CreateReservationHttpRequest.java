package com.bintics.classroomreservations.application.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class CreateReservationHttpRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("classroom_id")
    private String classRoomId;

}
