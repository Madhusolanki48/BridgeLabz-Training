package com.bridgelabz.contactsapp.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ContactRequestDTO {

    @NotBlank(message = "Name is required!")
    private String name;

    @NotBlank(message = "Phone number is required!")
    private String phone;

    @NotBlank(message = "Email is required")
    @Email(message = "Please provide a valid email address!")
    private String email;
}
