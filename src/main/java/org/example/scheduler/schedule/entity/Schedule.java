package org.example.scheduler.schedule.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.scheduler.BaseEntity;
import org.example.scheduler.user.entity.User;


@Entity
@Table(name = "schedule")
@Getter
public class Schedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 100)
    private String content;

    public Schedule() {}

    public Schedule(User user, String title, String content) {
        this.user = user;
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
