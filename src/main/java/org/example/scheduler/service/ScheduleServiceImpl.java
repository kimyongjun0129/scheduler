package org.example.scheduler.service;

import org.example.scheduler.dto.CreateScheduleRequestDto;
import org.example.scheduler.dto.CreateScheduleResponseDto;
import org.example.scheduler.entity.Schedule;
import org.example.scheduler.repository.ScheduleRepository;
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
        if (requestDto.getUsername() == null || requestDto.getTitle() == null || requestDto.getContent() == null || requestDto.getPassword() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "There is no content.");
        }

        Schedule schedule = scheduleRepository.saveSchedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContent(), requestDto.getPassword());

        if (schedule == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "This schedule Does not exists");
        }

        return new CreateScheduleResponseDto(schedule);
    }
}
