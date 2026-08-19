package com.example.fundoonotes.dto;

public class NoteResponse {
    private int noteId;
    private String title;
    private String description;
    private boolean archived;
    private boolean trashed;

    public NoteResponse(int noteId, String title, String description, boolean archived, boolean trashed) {
        this.noteId = noteId;
        this.title = title;
        this.description = description;
        this.archived = archived;
        this.trashed = trashed;
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

    public boolean isArchived() {
        return archived;
    }

    public boolean isTrashed() {
        return trashed;
    }
}
