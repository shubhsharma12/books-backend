package com.chitkara.bootcamp.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitkara.bootcamp.books.entities.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
