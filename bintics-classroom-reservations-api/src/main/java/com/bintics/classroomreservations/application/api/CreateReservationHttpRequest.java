package com.bintics.classroomreservations.application.api;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CreateReservationHttpRequest {

    @JsonProperty("id")
    private String id;

    @JsonProperty("classroom_id")
    private String classRoomId;

    @JsonProperty("reservation_date")
    private LocalDateTime reservationDate;

}
