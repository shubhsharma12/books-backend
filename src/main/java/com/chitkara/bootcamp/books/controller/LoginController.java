package com.chitkara.bootcamp.books.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chitkara.bootcamp.books.dto.request.LoginRequest;
import com.chitkara.bootcamp.books.dto.response.LoginResponse;
import com.chitkara.bootcamp.books.service.jwt.UserLoginService;
import com.chitkara.bootcamp.books.utils.JwtUtil;

import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/login")
public class LoginController {

	private final AuthenticationManager authenticationManager;

	private final UserLoginService userLoginService;

	private final JwtUtil jwtUtil;

	@Autowired
	public LoginController(AuthenticationManager authenticationManager, UserLoginService userLoginService,
			JwtUtil jwtUtil) {
		this.authenticationManager = authenticationManager;
		this.userLoginService = userLoginService;
		this.jwtUtil = jwtUtil;
	}

	@PostMapping
	public LoginResponse login(@RequestBody LoginRequest loginRequest, HttpServletResponse response)
			throws IOException {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword()));
		} catch (BadCredentialsException e) {
			throw new BadCredentialsException("Incorrect email or password.");
		} catch (DisabledException disabledException) {
			response.sendError(HttpServletResponse.SC_NOT_FOUND, "Customer is not activated");
			return null;
		}
		final UserDetails userDetails = userLoginService.loadUserByUsername(loginRequest.getEmail());
		final String jwt = jwtUtil.generateToken(userDetails.getUsername());

		return new LoginResponse(jwt);
	}

}
