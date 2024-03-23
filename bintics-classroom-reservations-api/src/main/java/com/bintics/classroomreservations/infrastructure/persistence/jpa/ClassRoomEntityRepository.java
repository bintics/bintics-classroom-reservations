package com.bintics.classroomreservations.infrastructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomEntityRepository extends JpaRepository<ClasRoomEntity, String> {
}
