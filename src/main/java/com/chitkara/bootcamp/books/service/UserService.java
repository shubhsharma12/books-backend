package com.chitkara.bootcamp.books.service;

import com.chitkara.bootcamp.books.dto.request.SignUpRequest;
import com.chitkara.bootcamp.books.entities.UserEntity;

public interface UserService {
	
	UserEntity createUser(SignUpRequest signUpRequest);

	UserEntity loadUserByUsername(String email) throws Exception;

}
