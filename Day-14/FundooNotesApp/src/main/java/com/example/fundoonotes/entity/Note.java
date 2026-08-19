package com.example.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int noteId;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, length = 1000)
    private String description;

    private boolean archived;
    private boolean trashed;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
