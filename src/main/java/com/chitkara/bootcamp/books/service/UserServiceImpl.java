package com.chitkara.bootcamp.books.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chitkara.bootcamp.books.dto.request.SignUpRequest;
import com.chitkara.bootcamp.books.entities.User;
import com.chitkara.bootcamp.books.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepo userRepo;

	@Override
	public User createUser(SignUpRequest signUpRequest) {
		 //Check if customer already exist
        if (userRepo.existsByEmail(signUpRequest.getEmail())) {
            return null;
        }

        User user = new User();
        BeanUtils.copyProperties(signUpRequest,user);

        //TODO:Explain Hash the password before saving
//        String hashPassword = passwordEncoder.encode(signUpRequest.getPassword());
//        user.setPassword(hashPassword);
        User createdUser = userRepo.save(user);
        user.setUserId(createdUser.getUserId());
        return user;
	}
	
	@Override
    public User	loadUserByUsername(String email) throws Exception {
        // Write logic to fetch customer from DB
        User user = userRepo.findByEmail(email)
                .orElseThrow(() -> new Exception("Customer not found with email: " + email));

        return new User(user.getEmail(), user.getPassword());
    }

}
