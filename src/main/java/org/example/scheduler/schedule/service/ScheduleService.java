package org.example.scheduler.schedule.service;

import jakarta.servlet.http.HttpServletRequest;
import org.example.scheduler.schedule.dto.*;

public interface ScheduleService{
    CreateScheduleResponseDto saveSchedule(CreateScheduleRequestDto requestDto);

    FindScheduleResponseDto findSchedule(Long id, HttpServletRequest request);

    UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto requestDto, HttpServletRequest request);

    void deleteSchedule(Long id, HttpServletRequest request);
}
