package com.bintics.context.subscriptions.domain;

import com.bintics.shared.RootAggregate;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@AllArgsConstructor
public class Subscription extends RootAggregate {

    private final SubscriptionId id;
    @Getter
    private String clientId;
    @Getter
    private String planId;
    @Getter
    private Double cost;
    @Getter
    private Date startDate;
    @Getter
    private Date endDate;
    @Getter
    private String status;

    public Subscription(SubscriptionId id) {
        this.id = id;
    }

    public String getId() {
        return this.id.value();
    }

}
