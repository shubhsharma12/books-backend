package com.chitkara.bootcamp.books.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitkara.bootcamp.books.dto.response.UserDetail;
import com.chitkara.bootcamp.books.entities.UserEntity;
import com.chitkara.bootcamp.books.service.UserService;
import com.chitkara.bootcamp.books.utils.JwtUtil;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService service;

	@Autowired
	private JwtUtil jwtUtil;

	@GetMapping("/user/info")
	public ResponseEntity<UserDetail> getUserDetail(HttpServletRequest request) throws Exception {

		String authHeader = request.getHeader("Authorization");
		String token = null;
		String email = null;

		if (authHeader != null && authHeader.startsWith("Bearer ")) {
			token = authHeader.substring(7);
			email = jwtUtil.extractEmail(token);
		}

		UserEntity userEntity = service.loadUserByUsername(email);

		return ResponseEntity.ok(new UserDetail(userEntity.getFirstName() + " " + userEntity.getLastName()));

	}

}
