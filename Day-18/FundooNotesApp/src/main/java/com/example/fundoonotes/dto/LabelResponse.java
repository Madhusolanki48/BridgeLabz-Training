package com.example.fundoonotes.dto;

public class LabelResponse {
    private int id;
    private String label;

    public LabelResponse(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }
}
