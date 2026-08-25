package com.example.fundoonotes.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    private boolean pined;
    private boolean archived;
    private boolean trashed;
    private String color;
    private String typeOfNote;
    private String imageUrl;
    private String linkUrl;

    @ElementCollection
    @CollectionTable(name = "note_reminders", joinColumns = @JoinColumn(name = "note_id"))
    @Column(name = "reminder_time", nullable = false)
    private List<LocalDateTime> reminders = new ArrayList<>();

    @OneToMany(mappedBy = "note", cascade = CascadeType.ALL)
    private List<NoteCheckList> checkLists = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToMany
    @JoinTable(
            name = "note_note_labels",
            joinColumns = @JoinColumn(name = "note_id"),
            inverseJoinColumns = @JoinColumn(name = "label_id")
    )
    private Set<NoteLabel> labels = new HashSet<>();
}
