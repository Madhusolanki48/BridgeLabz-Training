package com.example.fundoonotes.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public class ShareNoteRequest {
    @NotBlank
    @Email
    private String collaboratorEmail;

    public String getCollaboratorEmail() {
        return collaboratorEmail;
    }

    public void setCollaboratorEmail(String collaboratorEmail) {
        this.collaboratorEmail = collaboratorEmail;
    }
}
