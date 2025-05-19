package org.example.scheduler.repository;

import org.example.scheduler.entity.Schedule;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class JdbcTemplateScheduleRespository implements ScheduleRepository{
    private final JdbcTemplate jdbcTemplate;

    public JdbcTemplateScheduleRespository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public Schedule saveSchedule(String username, String title, String content, String password) {
        SimpleJdbcInsert jdbcInsert = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("schedule")
                .usingGeneratedKeyColumns("id")
                .usingColumns("username", "title", "content", "password");

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("username", username);
        parameters.put("title", title);
        parameters.put("content", content);
        parameters.put("password", password);

        Number key = jdbcInsert.executeAndReturnKey(new MapSqlParameterSource(parameters));
        long id = key.longValue();

        String sql = "SELECT id, title, username, content, created_at, updated_at FROM schedule WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, (rs, rowNum) ->
                new Schedule(
                        rs.getLong("id"),
                        rs.getString("title"),
                        rs.getString("username"),
                        rs.getString("content"),
                        rs.getDate("created_at"),
                        rs.getDate("updated_at")
                )
                ,id
        );
    }
}
