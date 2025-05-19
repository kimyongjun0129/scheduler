package org.example.scheduler.service;

import org.example.scheduler.dto.CreateScheduleRequestDto;
import org.example.scheduler.dto.CreateScheduleResponseDto;

public interface ScheduleService {
    CreateScheduleResponseDto saveSchedule(CreateScheduleRequestDto requestDto);
}
