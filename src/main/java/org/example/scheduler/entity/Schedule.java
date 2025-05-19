package org.example.scheduler.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Table(name = "schedule")
@Getter
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    private String password;

    public Schedule() {}

    public Schedule(String username, String title, String content, String password) {
        this.username = username;
        this.title = title;
        this.content = content;
        this.password = password;
    }

    public Schedule(Long id, String username, String title, String content) {
        this.id = id;
        this.username = username;
        this.title = title;
        this.content = content;
    }
}
