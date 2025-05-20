package org.example.scheduler.schedule.controller;

import org.example.scheduler.schedule.dto.*;
import org.example.scheduler.schedule.service.ScheduleService;
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

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto requestDto
    ) {
        UpdateScheduleResponseDto schedule = scheduleService.updateSchedule(id, requestDto);

        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long id,
            @RequestBody DeleteScheduleRequestDto requestDto
    ) {
        scheduleService.deleteSchedule(id, requestDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
