package com.bintics.attendance.infrastructure.out.persistence.jpa;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AttendanceEntityRepository extends CrudRepository<AttendanceEntity, String> {

    @Query("SELECT a FROM AttendanceEntity a WHERE FUNCTION('DATE', a.checkInAt) = :date")
    List<AttendanceEntity> findByDate(@Param("date") Date date);

}
