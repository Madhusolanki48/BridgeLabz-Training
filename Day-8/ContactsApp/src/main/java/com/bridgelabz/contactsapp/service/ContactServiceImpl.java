package com.bridgelabz.contactsapp.service;

import com.bridgelabz.contactsapp.dto.ContactRequestDTO;
import com.bridgelabz.contactsapp.dto.ContactResponseDTO;
import com.bridgelabz.contactsapp.exception.ContactAlreadyExistsException;
import com.bridgelabz.contactsapp.exception.ContactNotFoundException;
import com.bridgelabz.contactsapp.model.Contact;
import com.bridgelabz.contactsapp.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {

    private final ContactRepository contactRepository;

    public ContactServiceImpl(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    // CREATE
    @Override
    public ContactResponseDTO createContact(ContactRequestDTO requestDTO) {

        // Check duplicate phone
        if (contactRepository.existsByPhone(requestDTO.getPhone())) {
            throw new ContactAlreadyExistsException(
                    "Phone number already exists: " + requestDTO.getPhone());
        }

        // Check duplicate email
        if (contactRepository.existsByEmail(requestDTO.getEmail())) {
            throw new ContactAlreadyExistsException(
                    "Email already exists: " + requestDTO.getEmail());
        }

        Contact contact = new Contact();
        contact.setName(requestDTO.getName());
        contact.setPhone(requestDTO.getPhone());
        contact.setEmail(requestDTO.getEmail());

        Contact savedContact = contactRepository.save(contact);

        return mapToResponseDTO(savedContact);
    }

    // READ ALL CONTACTS
    @Override
    public List<ContactResponseDTO> getAllContacts() {

        return contactRepository.findAll()
                .stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    // READ BY ID
    @Override
    public ContactResponseDTO getContactById(Long id) {

        Contact contact = findContactById(id);

        return mapToResponseDTO(contact);
    }

    // UPDATE
    @Override
    public ContactResponseDTO updateContact(
            Long id,
            ContactRequestDTO requestDTO) {

        Contact contact = findContactById(id);

        // Check if phone belongs to another contact
        if (contactRepository.existsByPhoneAndIdNot(
                requestDTO.getPhone(), id)) {

            throw new ContactAlreadyExistsException(
                    "Phone number already exists: "
                            + requestDTO.getPhone());
        }

        // Check if email belongs to another contact
        if (contactRepository.existsByEmailAndIdNot(
                requestDTO.getEmail(), id)) {

            throw new ContactAlreadyExistsException(
                    "Email already exists: "
                            + requestDTO.getEmail());
        }

        contact.setName(requestDTO.getName());
        contact.setPhone(requestDTO.getPhone());
        contact.setEmail(requestDTO.getEmail());

        Contact updatedContact = contactRepository.save(contact);

        return mapToResponseDTO(updatedContact);
    }

    // DELETE
    @Override
    public void deleteContact(Long id) {

        Contact contact = findContactById(id);

        contactRepository.delete(contact);
    }

    // FIND CONTACT
    private Contact findContactById(Long id) {

        return contactRepository.findById(id)
                .orElseThrow(() -> new ContactNotFoundException(
                        "Contact not found with id: " + id));
    }

    // ENTITY TO RESPONSE DTO
    private ContactResponseDTO mapToResponseDTO(Contact contact) {

        return new ContactResponseDTO(
                contact.getId(),
                contact.getName(),
                contact.getPhone(),
                contact.getEmail());
    }
}