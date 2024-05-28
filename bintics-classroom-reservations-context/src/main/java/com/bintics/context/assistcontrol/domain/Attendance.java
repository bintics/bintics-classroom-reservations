package com.bintics.context.assistcontrol.domain;

import com.bintics.shared.RootAggregate;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;
import java.util.UUID;

@ToString
@EqualsAndHashCode
public class Attendance extends RootAggregate {

    @Getter
    private String id;

    private ClientId clientId;

    @Getter
    private Date checkIn;

    @Getter
    private Date checkOut;

    private SubscriptionId subscriptionId;

    public Attendance(String id, ClientId clientId, Date checkIn, Date checkOut, SubscriptionId subscription) {
        this.id = id;
        this.clientId = clientId;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.subscriptionId = subscription;
    }

    public Attendance(String id, ClientId clientId, Date checkIn, SubscriptionId subscriptionId) {
        this.id = id;
        this.clientId = clientId;
        this.checkIn = checkIn;
        this.subscriptionId = subscriptionId;
    }

    public static Attendance checkIn(ClientId clientId, SubscriptionId subscriptionId) {
        String id = UUID.randomUUID().toString();
        var now = new Date();
        var root = new Attendance(id, clientId, now, subscriptionId);
        return root;
    }

    public String getClientId() {
        return clientId.value();
    }

    public String getSubscriptionId() {
        return this.subscriptionId.value();
    }

}
