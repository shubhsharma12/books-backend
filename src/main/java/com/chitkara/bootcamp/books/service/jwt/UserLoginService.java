package com.chitkara.bootcamp.books.service.jwt;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.chitkara.bootcamp.books.entities.UserEntity;
import com.chitkara.bootcamp.books.repo.UserRepo;

@Service
public class UserLoginService implements UserDetailsService {

	@Autowired
	private UserRepo userRepo;

	@Override
	public User loadUserByUsername(String email) throws UsernameNotFoundException {
		UserEntity userFromDb = userRepo.findByEmail(email)
				.orElseThrow(() -> new UsernameNotFoundException("Customer not found with email: " + email));
		return new User(userFromDb.getEmail(), userFromDb.getPassword(), Collections.emptyList());
	}

}
