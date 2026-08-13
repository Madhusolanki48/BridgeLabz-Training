package com.bridgelabz.contactsapp.service;


import com.bridgelabz.contactsapp.dto.ContactRequestDTO;
import com.bridgelabz.contactsapp.dto.ContactResponseDTO;

import java.util.List;

public interface ContactService {

    ContactResponseDTO createContact(
            ContactRequestDTO requestDTO
    );

    List<ContactResponseDTO> getAllContacts();

    ContactResponseDTO getContactById(Long id);

    ContactResponseDTO updateContact(Long id, ContactRequestDTO requestDTO);

    void deleteContact(Long id);
}
