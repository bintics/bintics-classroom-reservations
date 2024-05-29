package com.bintics.attendancecontrol.infrastructure.out.persistence.mongo;

import com.bintics.clients.infrastructure.percistence.mongo.ClientRegisteredDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceProjectionRepository extends MongoRepository<AttendanceProjectionDocument, String> {
}
