package org.example.scheduler.entity;

import lombok.Getter;

import java.util.Date;

@Getter
public class Schedule {
    private Long id;
    private String username;
    private String title;
    private String content;
    private String password;
    private Date createdAt;
    private Date updatedAt;

    public Schedule(String username, String title, String content, String password) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public Schedule(Long id, String username, String title, String content, Date createdAt, Date updatedAt) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}
