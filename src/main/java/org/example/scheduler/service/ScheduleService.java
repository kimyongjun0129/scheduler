package org.example.scheduler.service;

import org.example.scheduler.dto.CreateScheduleRequestDto;
import org.example.scheduler.dto.CreateScheduleResponseDto;
import org.example.scheduler.dto.FindScheduleResponseDto;

public interface ScheduleService{
    CreateScheduleResponseDto saveSchedule(CreateScheduleRequestDto requestDto);

    FindScheduleResponseDto findSchedule(Long id);
}
