package com.uniovi.sdi2122904spring.services;

import com.uniovi.sdi2122904spring.entities.Mark;
import com.uniovi.sdi2122904spring.entities.Professor;
import com.uniovi.sdi2122904spring.repositories.MarksRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProfessorService {
    @Autowired
    private MarksRepository marksRepository;
    private List<Professor> professorList = new LinkedList<>();
    @PostConstruct
    public void init() {
        professorList.add(new Professor("1", "Ejercicio 1"));
        professorList.add(new Professor("2", "Ejercicio 2"));
    }
    public List<Professor> getProfessors() {
        return professorList;
    }
    public Professor getProfessor(String dni) {
        return professorList.stream().filter(professor -> professor.getDni().equals(dni)).findFirst().get();
    }
    public void addProfessor(Professor professor) {
        // Si en Id es null le asignamos el ultimo + 1 de la lista
        if (professor.getDni() == null) {
            professor.setDni(professorList.get(professorList.size() - 1).getDni() + 1);
        }
        professorList.add(professor);
    }
    public void deleteMark(String dni) {
        professorList.removeIf(mark -> mark.getDni().equals(dni));
    }
}
