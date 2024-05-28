package com.bintics.classroommanagement.infraestructure.in.api;

import com.bintics.context.classroommanagement.application.CreateClassRoomRequest;
import com.bintics.context.classroommanagement.application.CreateClassRoomUseCase;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/classrooms")
@AllArgsConstructor
public class CreateClassRoomController {

    private final CreateClassRoomUseCase useCase;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateClassRoomHttpRequest request) {
        var classRoomId = this.useCase.create(new CreateClassRoomRequest(
                request.getName()
        ));
        return ResponseEntity.created(
                ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/{id}")
                        .buildAndExpand(classRoomId)
                        .toUri()
        ).build();
    }

}
