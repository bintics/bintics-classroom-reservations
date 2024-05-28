package com.bintics.context.subscriptions.application;

import java.util.Date;

public record GetSubscriptionResponse(
        String id,
        String clientId,
        String planId,
        Double cost,
        Date startDate,
        Date endDate,
        String status
) {
}
