package org.example.scheduler.schedule.controller;

import jakarta.servlet.http.HttpServletRequest;
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
    public ResponseEntity<CreateScheduleResponseDto> createSchedule (
            @RequestBody CreateScheduleRequestDto requestDto,
            HttpServletRequest request
    ) {
        return new ResponseEntity<>(scheduleService.saveSchedule(requestDto, request), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<FindScheduleResponseDto> findSchedule(
            @PathVariable Long id,
            HttpServletRequest request
    ) {
        FindScheduleResponseDto schedule = scheduleService.findSchedule(id, request);
        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<UpdateScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody UpdateScheduleRequestDto requestDto,
            HttpServletRequest request
    ) {
        UpdateScheduleResponseDto schedule = scheduleService.updateSchedule(id, requestDto, request);

        return new ResponseEntity<>(schedule, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(
            @PathVariable Long id,
            HttpServletRequest request
    ) {
        scheduleService.deleteSchedule(id, request);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
