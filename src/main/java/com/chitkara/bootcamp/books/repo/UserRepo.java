package com.chitkara.bootcamp.books.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitkara.bootcamp.books.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{
	
	boolean existsByEmail(String email);
	
	Optional<User> findByEmail(String email);

}
