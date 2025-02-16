package com.chitkara.bootcamp.books.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.chitkara.bootcamp.books.dto.request.SignUpRequest;
import com.chitkara.bootcamp.books.entities.UserEntity;
import com.chitkara.bootcamp.books.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepo userRepo;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public UserEntity createUser(SignUpRequest signUpRequest) {
		// Check if customer already exist
		if (userRepo.existsByEmail(signUpRequest.getEmail())) {
			return null;
		}

		UserEntity user = new UserEntity();
		BeanUtils.copyProperties(signUpRequest, user);

		// TODO:Explain Hash the password before saving
		String hashPassword = passwordEncoder.encode(signUpRequest.getPassword());
		user.setPassword(hashPassword);
		UserEntity createdUser = userRepo.save(user);
		user.setUserId(createdUser.getUserId());
		return user;
	}

	@Override
	public UserEntity loadUserByUsername(String email) throws Exception {
		// Write logic to fetch customer from DB
		UserEntity user = userRepo.findByEmail(email)
				.orElseThrow(() -> new Exception("Customer not found with email: " + email));

		return new UserEntity(user.getEmail(), user.getPassword());
	}

}
