package com.chitkara.bootcamp.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitkara.bootcamp.books.dto.request.SignUpRequest;
import com.chitkara.bootcamp.books.entities.UserEntity;
import com.chitkara.bootcamp.books.service.UserService;


@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@Autowired
	private UserService service;
	
	@PostMapping
    public ResponseEntity<?> signupCustomer(@RequestBody SignUpRequest signupRequest) {
		UserEntity createduser = service.createUser(signupRequest);
        if (createduser != null) {
            return ResponseEntity.status(HttpStatus.CREATED).body(createduser);
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to create user!");
        }
    }
}
