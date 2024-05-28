package com.bintics.attendancecontrol.infrastructure;

import com.bintics.context.assistcontrol.application.RegisterAttendanceUseCase;
import com.bintics.context.assistcontrol.domain.AttendSubscriptionRepository;
import com.bintics.context.assistcontrol.domain.AttendanceRepository;
import com.bintics.context.assistcontrol.domain.ClientRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AttendanceControlConfig {

    @Bean
    public RegisterAttendanceUseCase registerAttendanceUseCase(ClientRepository clientRepository, AttendSubscriptionRepository subscriptionRepository, AttendanceRepository attendanceRepository) {
        return new RegisterAttendanceUseCase(clientRepository, subscriptionRepository, attendanceRepository);
    }

}
