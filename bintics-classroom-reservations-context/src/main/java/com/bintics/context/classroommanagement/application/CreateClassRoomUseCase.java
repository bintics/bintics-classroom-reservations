package com.bintics.context.classroommanagement.application;

import com.bintics.context.classroommanagement.domain.ClassRoom;
import com.bintics.context.classroommanagement.domain.ClassRoomManagementRepository;
import com.bintics.shared.DomainEventPublisher;

public class CreateClassRoomUseCase {

    private final ClassRoomManagementRepository repository;
    private final DomainEventPublisher domainEventPublisher;


    public CreateClassRoomUseCase(ClassRoomManagementRepository repository, DomainEventPublisher domainEventPublisher) {
        this.repository = repository;
        this.domainEventPublisher = domainEventPublisher;
    }

    public String create(CreateClassRoomRequest request) {
        ClassRoom classRoom = ClassRoom.create(request.name());
        this.repository.save(classRoom);
        this.domainEventPublisher.publish(classRoom.pullEvents());
        return classRoom.getId();
    }

}
