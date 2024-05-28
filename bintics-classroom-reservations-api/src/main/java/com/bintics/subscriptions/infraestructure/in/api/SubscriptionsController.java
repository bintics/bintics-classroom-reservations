package com.bintics.subscriptions.infraestructure.in.api;

import com.bintics.classroomreservations.infrastructure.in.api.CreateReservationHttpRequest;
import com.bintics.context.classroomreservations.application.CreateReservationRequest;
import com.bintics.context.subscriptions.application.GetSubscriptionRequest;
import com.bintics.context.subscriptions.application.GetSubscriptionResponse;
import com.bintics.context.subscriptions.application.GetSubscriptionUseCase;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@AllArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionsController {

    private final GetSubscriptionUseCase useCase;

    @GetMapping("/{subscriptionId}")
    public GetSubscriptionResponse get(@PathVariable String subscriptionId) {
        return this.useCase.get(new GetSubscriptionRequest(subscriptionId));
    }

}
