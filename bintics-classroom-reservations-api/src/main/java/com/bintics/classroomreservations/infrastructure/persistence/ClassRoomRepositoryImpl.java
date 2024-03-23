package com.bintics.classroomreservations.infrastructure.persistence;

import com.bintics.context.classroomreservations.domain.model.ClassRoomId;
import com.bintics.context.classroomreservations.domain.repository.ClassRoomRepository;
import com.bintics.classroomreservations.infrastructure.persistence.jpa.ClasRoomEntity;
import com.bintics.classroomreservations.infrastructure.persistence.jpa.ClassRoomEntityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@AllArgsConstructor
public class ClassRoomRepositoryImpl implements ClassRoomRepository {

    private final ClassRoomEntityRepository repository;

    @Override
    public ClassRoomId find(String id) {
        Optional<ClasRoomEntity> classRoomId = this.repository.findById(id);
        if (classRoomId.isPresent()) {
            return new ClassRoomId(classRoomId.get().getId());
        }
        return null;
    }

}
