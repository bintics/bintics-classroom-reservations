package com.bintics.subscriptions.infraestructure.in.api;

import com.bintics.context.subscriptions.application.GetSubscriptionRequest;
import com.bintics.context.subscriptions.application.GetSubscriptionResponse;
import com.bintics.context.subscriptions.application.GetSubscriptionUseCase;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
