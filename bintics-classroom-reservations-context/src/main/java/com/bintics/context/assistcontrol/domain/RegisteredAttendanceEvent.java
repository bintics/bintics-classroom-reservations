package com.bintics.context.assistcontrol.domain;

import com.bintics.shared.DomainEvent;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Date;

@Getter
@AllArgsConstructor
public class RegisteredAttendanceEvent extends DomainEvent {

    private final String id;
    private final String clientId;
    private final String subscriptionId;
    private final Date checkIn;
    private final Date checkOut;

}
