package com.uniovi.sdi2122904spring.repositories;

import com.uniovi.sdi2122904spring.entities.Mark;
import com.uniovi.sdi2122904spring.entities.Professor;
import org.springframework.data.repository.CrudRepository;

public interface ProfessorRepository extends CrudRepository<Professor, Long> {
}