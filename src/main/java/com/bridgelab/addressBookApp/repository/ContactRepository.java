package com.bridgelab.addressBookApp.repository;

import com.bridgelab.addressBookApp.model.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {}
