package com.bintics.context.assistcontrol.application;

import com.bintics.context.assistcontrol.domain.*;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class RegisterAttendanceUseCase {

    private final ClientRepository clientRepository;

    private final AttendanceSubscriptionRepository subscriptionRepository;

    private final AttendanceRepository attendanceRepository;

    public void register(RegisterAttendanceRequest request) {
        var clientId = ClientId.from(request.clientId());

        if (!this.clientRepository.exists(clientId)) {
            throw new RuntimeException("client not found");
        }

        var subscriptionId = this.subscriptionRepository.findCurrentSubscription(clientId);
        if (subscriptionId == null) {
            throw new RuntimeException("you do not have an active subscription");
        }

        var attendance = Attendance.checkIn(clientId, subscriptionId);
        this.attendanceRepository.save(attendance);
    }

}
