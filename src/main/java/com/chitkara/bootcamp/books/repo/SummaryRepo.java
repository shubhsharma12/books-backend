package com.chitkara.bootcamp.books.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.chitkara.bootcamp.books.entities.SummaryEntity;

@Repository
public interface SummaryRepo extends JpaRepository<SummaryEntity, Long> {

}
