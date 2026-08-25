package com.example.fundoonotes.dto;

import jakarta.validation.constraints.NotBlank;

public class LabelRequest {
    @NotBlank
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
}
