package com.bintics.classroomreservations.infrastructure;

import com.bintics.context.classroomreservations.application.CreateReservationUseCase;
import com.bintics.context.classroomreservations.domain.repository.ClassRoomRepository;
import com.bintics.context.classroomreservations.domain.repository.ReservationsRepository;
import com.bintics.shared.DomainEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateReservationUseCase createReservationUseCase(ReservationsRepository repository, ClassRoomRepository classRoomRepository, DomainEventPublisher domainEventPublisher) {
        return new CreateReservationUseCase(
                repository,
                classRoomRepository,
                domainEventPublisher
        );
    }

}
