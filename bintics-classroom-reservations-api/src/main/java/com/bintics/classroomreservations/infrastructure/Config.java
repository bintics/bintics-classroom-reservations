package com.bintics.classroomreservations.infrastructure;

import com.bintics.classroomreservations.application.CreateReservationUseCase;
import com.bintics.classroomreservations.domain.repository.ClassRoomRepository;
import com.bintics.classroomreservations.domain.repository.ReservationsRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

    @Bean
    public CreateReservationUseCase createReservationUseCase(ReservationsRepository repository, ClassRoomRepository classRoomRepository) {
        return new CreateReservationUseCase(repository, classRoomRepository);
    }

}
