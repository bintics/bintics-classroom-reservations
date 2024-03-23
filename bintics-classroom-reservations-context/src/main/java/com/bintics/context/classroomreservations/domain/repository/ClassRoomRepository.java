package com.bintics.context.classroomreservations.domain.repository;

import com.bintics.context.classroomreservations.domain.model.ClassRoomId;

public interface ClassRoomRepository {

    ClassRoomId find(String id);

}
