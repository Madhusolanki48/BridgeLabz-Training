package com.example.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class NoteLabel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private String label;

    private boolean deleted;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
