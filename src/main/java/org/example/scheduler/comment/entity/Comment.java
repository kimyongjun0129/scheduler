package org.example.scheduler.comment.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.example.scheduler.BaseEntity;
import org.example.scheduler.schedule.entity.Schedule;
import org.example.scheduler.user.entity.User;

@Entity
@Getter
public class Comment extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @JoinColumn(name = "user_id", nullable = false)
    @ManyToOne
    private User user;

    @JoinColumn(name = "schedule_id", nullable = false)
    @ManyToOne
    private Schedule schedule;

    public Comment(String content, User user, Schedule schedule) {
        this.content = content;
        this.user = user;
        this.schedule = schedule;
    }

    public Comment() {

    }

    public void updateContent(String content) {
        this.content = content;
    }
}
