package org.example.scheduler.schedule.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.example.scheduler.schedule.dto.*;
import org.example.scheduler.schedule.entity.Schedule;
import org.example.scheduler.schedule.repository.ScheduleRepository;
import org.example.scheduler.user.entity.User;
import org.example.scheduler.user.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{

    private final ScheduleRepository scheduleRepository;
    private final UserRepository userRepository;

    public CreateScheduleResponseDto saveSchedule(CreateScheduleRequestDto requestDto, HttpServletRequest request) {

        HttpSession session = request.getSession(false);
        Long logInUserId = (Long) session.getAttribute("login-userId");

        User loginUser = userRepository.findByIdOrElseThrow(logInUserId);

        Schedule schedule = new Schedule(loginUser, requestDto.getTitle(), requestDto.getContent());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponseDto(savedSchedule);
    }

    @Transactional
    public FindScheduleResponseDto findSchedule(Long id, HttpServletRequest request) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        Long scheduleOwnerId = schedule.getUser().getId();
        if(!scheduleOwnerId.equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This user is not authorized to find this schedule.");
        }

        return new FindScheduleResponseDto(schedule);
    }

    @Transactional
    public UpdateScheduleResponseDto updateSchedule(Long id, UpdateScheduleRequestDto requestDto, HttpServletRequest request) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        Long scheduleOwnerId = schedule.getUser().getId();
        if(!scheduleOwnerId.equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "This user is not authorized to update this schedule.");
        }

        schedule.updateTitle(requestDto.getTitle());
        schedule.updateContent(requestDto.getContent());

        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new UpdateScheduleResponseDto(savedSchedule);
    }

    @Transactional
    public void deleteSchedule(Long id, HttpServletRequest request) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);

        HttpSession session = request.getSession(false);

        Long loginUserId = (Long) session.getAttribute("login-userId");

        Long scheduleOwnerId = schedule.getUser().getId();
        if(!scheduleOwnerId.equals(loginUserId)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This user is not authorized to delete this schedule.");
        }

        scheduleRepository.delete(schedule);
    }
}
