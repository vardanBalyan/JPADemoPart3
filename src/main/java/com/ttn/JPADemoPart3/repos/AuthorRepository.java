package com.ttn.JPADemoPart3.repos;

import com.ttn.JPADemoPart3.entities.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}
