package com.bintics.attendance.infrastructure.out.persistence;

import com.bintics.attendance.infrastructure.out.persistence.jpa.AttendanceEntity;
import com.bintics.attendance.infrastructure.out.persistence.jpa.AttendanceEntityRepository;
import com.bintics.context.assistcontrol.domain.Attendance;
import com.bintics.context.assistcontrol.domain.AttendanceRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class AttendanceRepositoryImpl implements AttendanceRepository {

    private final AttendanceEntityRepository repository;

    @Override
    public void save(Attendance attendance) {
        AttendanceEntity attendanceEntity = new AttendanceEntity();
        attendanceEntity.setId(attendance.getId());
        attendanceEntity.setClientId(attendance.getClientId());
        attendanceEntity.setCheckInAt(attendance.getCheckIn());
        attendanceEntity.setSubscriptionId(attendance.getSubscriptionId());
        this.repository.save(attendanceEntity);
    }

}
