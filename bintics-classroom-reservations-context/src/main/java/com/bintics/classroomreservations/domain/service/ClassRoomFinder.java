package com.bintics.classroomreservations.domain.service;

import com.bintics.classroomreservations.domain.exception.ClassRoomNotFoundException;
import com.bintics.classroomreservations.domain.model.ClassRoomId;
import com.bintics.classroomreservations.domain.repository.ClassRoomRepository;

public class ClassRoomFinder {

    private final ClassRoomRepository classRoomRepository;

    public ClassRoomFinder(ClassRoomRepository classRoomRepository) {
        this.classRoomRepository = classRoomRepository;
    }

    public ClassRoomId find(String id) {
        var classRoomId = this.classRoomRepository.find(id);
        if (classRoomId == null) {
            throw new ClassRoomNotFoundException(id);
        }
        return classRoomId;
    }

}
