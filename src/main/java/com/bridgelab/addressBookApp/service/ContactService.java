package com.bridgelab.addressBookApp.service;

import com.bridgelab.addressBookApp.dto.ContactDTO;
import com.bridgelab.addressBookApp.model.Contact;
import com.bridgelab.addressBookApp.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {
    private final ContactRepository contactRepository;

    public ContactService(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();
    }

    public Optional<Contact> getContactById(Long id) {
        return contactRepository.findById(id);
    }

    public Contact addContact(ContactDTO contactDTO) {
        Contact contact = new Contact(contactDTO.getName(), contactDTO.getPhone());
        return contactRepository.save(contact);
    }

    public Optional<Contact> updateContact(Long id, ContactDTO contactDTO) {
        return contactRepository.findById(id).map(contact -> {
            contact.setName(contactDTO.getName());
            contact.setPhone(contactDTO.getPhone());
            return contactRepository.save(contact);
        });
    }

    public boolean deleteContact(Long id) {
        if (contactRepository.existsById(id)) {
            contactRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
