package org.example.scheduler.repository;

import org.example.scheduler.entity.Schedule;

public interface ScheduleRepository {
    Schedule saveSchedule(String username, String title, String content, String password);
}
