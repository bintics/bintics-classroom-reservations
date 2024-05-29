package com.bintics.attendancecontrol.infrastructure.in.api;

import com.bintics.attendancecontrol.infrastructure.out.persistence.mongo.AttendanceProjectionRepository;
import com.bintics.context.assistcontrol.application.RegisterAttendanceRequest;
import com.bintics.context.assistcontrol.application.RegisterAttendanceUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Collectors;

@RestController
@RequestMapping("/attendances-control")
@AllArgsConstructor
public class AttendancesController {

    private final RegisterAttendanceUseCase useCase;

    private final AttendanceProjectionRepository attendanceProjectionRepository;

    @GetMapping("/attendances")
    public GetAttendancesHttpResponse getAttendances() {
        var items = this.attendanceProjectionRepository.findAll()
                .stream()
                .map(d -> new GetAttendancesHttpResponse.AttendanceHttpResponse(
                        d.getClient() == null ? null :
                                new GetAttendancesHttpResponse.AttendanceHttpResponse.Client(
                                        d.getClient().clientId(),
                                        d.getClient().name(),
                                        d.getClient().surname(),
                                        d.getClient().secondSurname()
                                ),
                        d.getSubscription() == null ? null :
                                new GetAttendancesHttpResponse.AttendanceHttpResponse.Subscription(
                                        d.getSubscription().id(),
                                        d.getSubscription().subStartDate(),
                                        d.getSubscription().subEndDate(),
                                        d.getSubscription().subStatus()
                                )
                )).collect(Collectors.toList());
        return new GetAttendancesHttpResponse(items);
    }

    @PostMapping("/check-in")
    public void checkIn(@RequestBody CheckInHttpRequest request) {
        this.useCase.register(new RegisterAttendanceRequest(request.getClientId()));
    }

}
