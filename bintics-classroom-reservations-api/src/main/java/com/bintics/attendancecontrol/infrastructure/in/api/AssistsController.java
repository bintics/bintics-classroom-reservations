package com.bintics.attendancecontrol.infrastructure.in.api;

import com.bintics.context.assistcontrol.application.RegisterAttendanceRequest;
import com.bintics.context.assistcontrol.application.RegisterAttendanceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/attendances-control")
@AllArgsConstructor
public class AssistsController {

    private final RegisterAttendanceUseCase useCase;

    @GetMapping("/attendances")
    public GetAttendancesHttpRequest getAttendances() {
        return new GetAttendancesHttpRequest();
    }

    @PostMapping("/check-in")
    public void checkIn(@RequestBody CheckInHttpRequest request) {
        this.useCase.register(new RegisterAttendanceRequest(request.getClientId()));
    }

}
