package com.bintics.classroommanagement.infraestructure.out.persistence;

import com.bintics.classroommanagement.infraestructure.out.persistence.jpa.ClassRoomEntity;
import com.bintics.classroommanagement.infraestructure.out.persistence.jpa.ClassRoomManagementEntityRepository;
import com.bintics.context.classroommanagement.domain.ClassRoom;
import com.bintics.context.classroommanagement.domain.ClassRoomManagementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class ClassRoomManagementRepositoryImpl implements ClassRoomManagementRepository {

    private final ClassRoomManagementEntityRepository classRoomEntityRepository;

    @Override
    public void save(ClassRoom classRoom) {
        ClassRoomEntity entity = new ClassRoomEntity();
        entity.setId(classRoom.getId());
        entity.setName(classRoom.getName());
        this.classRoomEntityRepository.save(entity);
    }

}
