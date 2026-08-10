package com.bridgelabz.contactsapp.controller;

import com.bridgelabz.contactsapp.dto.ContactRequestDTO;
import com.bridgelabz.contactsapp.dto.ContactResponseDTO;
import com.bridgelabz.contactsapp.service.ContactService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/contactApp")
public class ContactAppController {

    private final ContactService contactService;

    public ContactAppController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/create")
    public ContactResponseDTO create(@RequestBody ContactRequestDTO requestDTO) {

        //saves the contact 
        return contactService.addContact(requestDTO);
    }
}
