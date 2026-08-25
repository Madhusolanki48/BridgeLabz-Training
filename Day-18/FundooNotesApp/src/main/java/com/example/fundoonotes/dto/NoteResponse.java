package com.example.fundoonotes.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;

public class NoteResponse {
    private int noteId;
    private String title;
    private String description;
    private boolean pined;
    private boolean archived;
    private boolean trashed;
    private String color;
    private String typeOfNote;
    private String imageUrl;
    private String linkUrl;
    private Set<String> labels;
    private List<LocalDateTime> reminders;
    private List<CheckListResponse> checkLists;

    public NoteResponse(int noteId, String title, String description, boolean pined,
                        boolean archived, boolean trashed, String color, String typeOfNote,
                        String imageUrl, String linkUrl, Set<String> labels,
                        List<LocalDateTime> reminders, List<CheckListResponse> checkLists) {
        this.noteId = noteId;
        this.title = title;
        this.description = description;
        this.pined = pined;
        this.archived = archived;
        this.trashed = trashed;
        this.color = color;
        this.typeOfNote = typeOfNote;
        this.imageUrl = imageUrl;
        this.linkUrl = linkUrl;
        this.labels = labels;
        this.reminders = reminders;
        this.checkLists = checkLists;
    }

    public int getNoteId() {
        return noteId;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public boolean isPined() {
        return pined;
    }

    public boolean isArchived() {
        return archived;
    }

    public boolean isTrashed() {
        return trashed;
    }

    public String getColor() {
        return color;
    }

    public String getTypeOfNote() {
        return typeOfNote;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getLinkUrl() {
        return linkUrl;
    }

    public Set<String> getLabels() {
        return labels;
    }

    public List<LocalDateTime> getReminders() {
        return reminders;
    }

    public List<CheckListResponse> getCheckLists() {
        return checkLists;
    }
}
