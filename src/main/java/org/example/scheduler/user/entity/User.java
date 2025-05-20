package org.example.scheduler.user.entity;

import jakarta.persistence.*;
import lombok.Getter;
import org.example.scheduler.BaseEntity;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String username;
    private String email;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User() {

    }
}
