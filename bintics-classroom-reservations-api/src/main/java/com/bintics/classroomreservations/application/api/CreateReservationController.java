package com.bintics.classroomreservations.application.api;

import com.bintics.context.classroomreservations.application.CreateReservationRequest;
import com.bintics.context.classroomreservations.application.CreateReservationUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/classroom-reservations")
public class CreateReservationController {

    private final CreateReservationUseCase useCase;

    @PostMapping
    public void create(@RequestBody CreateReservationHttpRequest request) {
        this.useCase.create(new CreateReservationRequest(
                request.getId(),
                request.getClassRoomId(),
                request.getReservationDate()
        ));
    }

}
