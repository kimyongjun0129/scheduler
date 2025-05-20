package org.example.scheduler.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.scheduler.BaseEntity;


@Entity
@Table(name = "schedule")
@Getter
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Schedule() {}

    public Schedule(Long userId, String title, String content, String password) {
        this.userId = userId;
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public Schedule(Long id, Long userId, String title, String content) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.content = content;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContent(String content) {
        this.content = content;
    }
}
