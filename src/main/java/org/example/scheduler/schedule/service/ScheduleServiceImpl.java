package org.example.scheduler.schedule.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.example.scheduler.schedule.dto.*;
import org.example.scheduler.schedule.entity.Schedule;
import org.example.scheduler.schedule.repository.ScheduleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.security.sasl.AuthenticationException;

@Service
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;

    public ScheduleServiceImpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public CreateScheduleResponseDto saveSchedule(CreateScheduleRequestDto requestDto) {
        if (requestDto.getUserId() == null || requestDto.getTitle() == null || requestDto.getContent() == null || requestDto.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no content.");
        }

        Schedule schedule = new Schedule(requestDto.getUserId(), requestDto.getTitle(), requestDto.getContent(), requestDto.getPassword());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponseDto(savedSchedule);
    }

    public FindScheduleResponseDto findSchedule(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        return new FindScheduleResponseDto(schedule);
    }

    @Override
    public UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        if(requestDto.getTitle() == null || requestDto.getContent() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no content.");
        }

        if(!schedule.getPassword().equals(requestDto.getPassword())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This password does not the same as schedule password.");
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

        if (session == null || session.getAttribute("login-userId") == null) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "로그인을 먼저 시도해주세요.");
        }

        Long loginUserId = (Long) session.getAttribute("login-userId");

        if(!schedule.getUserId().equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to delete this schedule.");
        }

        scheduleRepository.delete(schedule);
    }
}
