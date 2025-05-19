package org.example.scheduler.service;

import org.example.scheduler.dto.*;

public interface ScheduleService{
    CreateScheduleResponseDto saveSchedule(CreateScheduleRequestDto requestDto);

    FindScheduleResponseDto findSchedule(Long id);

    UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto requestDto);

    void deleteSchedule(Long id, DeleteScheduleRequestDto requestDto);
}
