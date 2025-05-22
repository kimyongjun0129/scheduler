package org.example.scheduler.schedule.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.scheduler.schedule.dto.*;
import org.example.scheduler.schedule.entity.Schedule;
import org.example.scheduler.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public CreateScheduleResponseDto saveSchedule(CreateScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto.getUserId(), requestDto.getTitle(), requestDto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponseDto(savedSchedule);
    }

    public FindScheduleResponseDto findSchedule(Long id, HttpServletRequest request) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        if(!schedule.getUserId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to find this schedule.");
        }

        return new FindScheduleResponseDto(schedule);
    }

    @Override
    public UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto requestDto, HttpServletRequest request) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        if(!schedule.getUserId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to update this schedule.");
        }

        schedule.updateTitle(requestDto.getTitle());
        schedule.updateContent(requestDto.getContent());

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new UpdateScheduleResponseDto(savedSchedule);
    }

    @Override
    public void deleteSchedule(Long id, HttpServletRequest request) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        if(!schedule.getUserId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to delete this schedule.");
        }

        scheduleRepository.delete(schedule);
    }
}
