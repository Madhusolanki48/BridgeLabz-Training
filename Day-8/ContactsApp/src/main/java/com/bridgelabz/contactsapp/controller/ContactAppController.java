package com.bridgelabz.contactsapp.controller;

import com.bridgelabz.contactsapp.dto.ContactRequestDTO;
import com.bridgelabz.contactsapp.dto.ContactResponseDTO;
import com.bridgelabz.contactsapp.service.ContactService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/contacts")
public class ContactAppController {

    private final ContactService contactService;

    public ContactAppController(ContactService contactService) {
        this.contactService = contactService;
    }

    // CREATE
    @PostMapping
    public ResponseEntity<ContactResponseDTO> createContact(
            @Valid @RequestBody ContactRequestDTO requestDTO
    ) {
        ContactResponseDTO response = contactService.createContact(requestDTO);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<ContactResponseDTO>> getAllContacts() {
        return ResponseEntity.ok(
                contactService.getAllContacts()
        );
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> getContactById(@PathVariable Long id) {
        return ResponseEntity.ok(
                contactService.getContactById(id)
        );
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<ContactResponseDTO> updateContact(
            @PathVariable Long id,
            @Valid @RequestBody ContactRequestDTO requestDTO
    ) {
        ContactResponseDTO response = contactService.updateContact(id, requestDTO);

        return ResponseEntity.ok(response);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);

        return ResponseEntity.noContent().build();
    }
}
