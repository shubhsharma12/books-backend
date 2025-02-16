package com.chitkara.bootcamp.books.service;

import com.chitkara.bootcamp.books.dto.request.SignUpRequest;
import com.chitkara.bootcamp.books.entities.User;

public interface UserService {
	
	User createUser(SignUpRequest signUpRequest);

	User loadUserByUsername(String email) throws Exception;

}
