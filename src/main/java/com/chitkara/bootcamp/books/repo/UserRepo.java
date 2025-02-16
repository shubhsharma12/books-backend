package com.chitkara.bootcamp.books.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitkara.bootcamp.books.entities.UserEntity;

@Repository
public interface UserRepo extends JpaRepository<UserEntity, Long>{
	
	boolean existsByEmail(String email);
	
	Optional<UserEntity> findByEmail(String email);

}
