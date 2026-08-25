package com.example.fundoonotes.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public class ReminderRequest {
    @NotNull
    private Integer noteId;

    @NotNull
    private List<String> reminder;

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public List<String> getReminder() {
        return reminder;
    }

    public void setReminder(List<String> reminder) {
        this.reminder = reminder;
    }
}
