package org.example.scheduler.controller;

import org.example.scheduler.dto.CreateScheduleRequestDto;
import org.example.scheduler.dto.CreateScheduleResponseDto;
import org.example.scheduler.dto.FindScheduleResponseDto;
import org.example.scheduler.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/schedules")
public class SchedueController {
    private final ScheduleService scheduleService;

    public SchedueController(ScheduleService scheduleService) {
        this.scheduleService = scheduleService;
    }

    @PostMapping
    public ResponseEntity<CreateScheduleResponseDto> createSchedule (@RequestBody CreateScheduleRequestDto requestDto) {
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindScheduleResponseDto> findSchedule(
            @PathVariable Long id
    ) {
        FindScheduleResponseDto schedule = scheduleService.findSchedule(id);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }
}
