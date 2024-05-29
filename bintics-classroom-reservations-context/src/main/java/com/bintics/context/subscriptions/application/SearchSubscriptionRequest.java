package com.bintics.context.subscriptions.application;

import java.util.Date;

public record SearchSubscriptionRequest(
        String id,

        String clientId,

        String planId,

        Double cost,

        String status,

        Date startDate,

        Date endDate
) {
}
