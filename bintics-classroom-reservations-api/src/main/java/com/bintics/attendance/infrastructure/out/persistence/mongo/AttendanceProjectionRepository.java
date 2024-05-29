package com.bintics.attendance.infrastructure.out.persistence.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceProjectionRepository extends MongoRepository<AttendanceProjectionDocument, String> {
}
