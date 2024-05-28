package com.bintics.attendancecontrol.infrastructure.in.api;

import lombok.Data;

import java.util.LinkedList;
import java.util.List;

@Data
public class GetAttendancesHttpRequest {

    private List<AttendanceHttpResponse> items = new LinkedList<>();

}
