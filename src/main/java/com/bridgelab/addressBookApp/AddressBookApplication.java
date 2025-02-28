package com.bridgelab.addressBookApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class AddressBookApplication {
	public static void main(String[] args) {
		SpringApplication.run(AddressBookApplication.class, args);
	}
}