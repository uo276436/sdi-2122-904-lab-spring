package com.uniovi.sdi2122904spring.services;

import com.uniovi.sdi2122904spring.entities.Mark;
import com.uniovi.sdi2122904spring.entities.Professor;
import com.uniovi.sdi2122904spring.repositories.MarksRepository;
import com.uniovi.sdi2122904spring.repositories.ProfessorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private ProfessorRepository professorRepository;

    public List<Professor> getProfessors() {
        List<Professor> professor = new ArrayList<Professor>();
        professorRepository.findAll().forEach(professor::add);
        return professor;
    }
    public Professor getProfessor(String dni) {
        return professorRepository.findById(Long.valueOf(dni)).get();
    }
    public void addProfessor(Professor professor) {
        professorRepository.save(professor);
    }
    public void deleteMark(String dni) {
        professorRepository.deleteById(Long.valueOf(dni));
    }
}
