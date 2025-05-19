package org.example.scheduler.service;

import org.example.scheduler.dto.CreateScheduleRequestDto;
import org.example.scheduler.dto.CreateScheduleResponseDto;
import org.example.scheduler.dto.FindScheduleResponseDto;
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

        Schedule schedule = new Schedule(requestDto.getUsername(), requestDto.getTitle(), requestDto.getContent(), requestDto.getPassword());
        Schedule savedSchedule = scheduleRepository.save(schedule);

        return new CreateScheduleResponseDto(savedSchedule);
    }

    public FindScheduleResponseDto findSchedule(Long id) {
        Schedule schedule = scheduleRepository.findByIdOrElseThrow(id);
        return new FindScheduleResponseDto(schedule);
    }
}
