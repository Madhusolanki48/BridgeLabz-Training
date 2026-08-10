package com.bridgelabz.contactsapp.service;

import com.bridgelabz.contactsapp.dto.ContactRequestDTO;
import com.bridgelabz.contactsapp.dto.ContactResponseDTO;
import com.bridgelabz.contactsapp.model.Contact;
import com.bridgelabz.contactsapp.repository.ContactRepository;
import org.springframework.stereotype.Service;

@Service
public class ContactService {

    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public ContactResponseDTO addContact(ContactRequestDTO requestDTO) {

        //maps request data to the JPA entity
        Contact contact = new Contact();

        contact.setName(requestDTO.getName());
        contact.setPhone(requestDTO.getPhone());
        contact.setEmail(requestDTO.getEmail());

        Contact savedContact = contactRepository.save(contact);

        //returns only the response fields needed by the API
        return new ContactResponseDTO(
                savedContact.getId(),
                savedContact.getName(),
                savedContact.getPhone(),
                savedContact.getEmail()
        );
    }
}
