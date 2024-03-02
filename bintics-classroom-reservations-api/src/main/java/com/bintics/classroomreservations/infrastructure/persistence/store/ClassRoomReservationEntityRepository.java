package com.bintics.classroomreservations.infrastructure.persistence.store;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomReservationEntityRepository extends JpaRepository<ClassRoomReservationEntity, String> {
}
