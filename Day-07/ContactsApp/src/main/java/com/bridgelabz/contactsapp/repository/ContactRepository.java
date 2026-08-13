package com.bridgelabz.contactsapp.repository;

import com.bridgelabz.contactsapp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}