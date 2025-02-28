package com.bridgelab.addressBookApp.controller;

import com.bridgelab.addressBookApp.dto.ContactDTO;
import com.bridgelab.addressBookApp.model.Contact;
import com.bridgelab.addressBookApp.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
public class AddressBookController {
    @Autowired
    private ContactService contactService;

    @GetMapping
    public ResponseEntity<List<Contact>> getAllContacts() {
        return ResponseEntity.ok(contactService.getAllContacts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contact> getContactById(@PathVariable Long id) {
        return contactService.getContactById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Contact> addContact(@RequestBody ContactDTO contactDTO) {
        return ResponseEntity.ok(contactService.addContact(contactDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable Long id, @RequestBody ContactDTO contactDTO) {
        return contactService.updateContact(id, contactDTO)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id) ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
    }
}
