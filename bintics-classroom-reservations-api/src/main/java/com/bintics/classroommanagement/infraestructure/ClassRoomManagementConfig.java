package com.bintics.classroommanagement.infraestructure;

import com.bintics.context.classroommanagement.application.CreateClassRoomUseCase;
import com.bintics.context.classroommanagement.domain.ClassRoomManagementRepository;
import com.bintics.shared.DomainEventPublisher;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClassRoomManagementConfig {

    @Bean
    public CreateClassRoomUseCase createClassRoomUseCase(ClassRoomManagementRepository repository, DomainEventPublisher domainEventPublisher) {
        return new CreateClassRoomUseCase(repository, domainEventPublisher);
    }

}
