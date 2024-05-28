package com.bintics.classroommanagement.infraestructure.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomManagementEntityRepository extends JpaRepository<ClassRoomEntity, String> {
}
