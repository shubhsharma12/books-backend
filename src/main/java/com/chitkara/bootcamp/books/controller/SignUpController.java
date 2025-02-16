package com.chitkara.bootcamp.books.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitkara.bootcamp.books.dto.request.SignUpRequest;


@RestController
@RequestMapping("/signup")
public class SignUpController {
	
	@PostMapping
    public ResponseEntity<String> signupCustomer(@RequestBody SignUpRequest signupRequest) {
       return null;
    }
}
