package com.bintics.classroomreservations.domain.repository;

import com.bintics.classroomreservations.domain.model.ClassRoomId;

public interface ClassRoomRepository {

    ClassRoomId find(String id);

}
