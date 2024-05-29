package com.bintics.context.subscriptions.application;

import java.util.Date;
import java.util.List;

public record SearchSubscriptionResponse(List<SearchResponse> items) {
    public record SearchResponse(
            String id,
            String clientId,
            String planId,
            Double cost,
            String status,
            Date startDate,
            Date endDate
    ) {
    }

}
