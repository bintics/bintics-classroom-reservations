package com.bintics.subscriptions.infraestructure.in.api;

import com.bintics.context.subscriptions.application.*;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@AllArgsConstructor
@RequestMapping("/subscriptions")
public class SubscriptionsController {

    private final GetSubscriptionUseCase getSubscriptionUseCase;

    private final SearchSubscriptionUseCase searchSubscriptionUseCase;

    @GetMapping("/{subscriptionId}")
    public GetSubscriptionResponse get(@PathVariable String subscriptionId) {
        return this.getSubscriptionUseCase.get(new GetSubscriptionRequest(subscriptionId));
    }

    @GetMapping
    public SearchSubscriptionResponse search(
            @RequestParam(required = false) String id,
            @RequestParam(required = false) String clientId,
            @RequestParam(required = false) String planId,
            @RequestParam(required = false) Double cost,
            @RequestParam(required = false) String status,
            @RequestParam(required = false) Date startDate,
            @RequestParam(required = false) Date endDate
    ) {
        return this.searchSubscriptionUseCase.search(new SearchSubscriptionRequest(
                id,
                clientId,
                planId,
                cost,
                status,
                startDate,
                endDate
        ));
    }

}
