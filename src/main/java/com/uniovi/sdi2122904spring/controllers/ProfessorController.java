package com.uniovi.sdi2122904spring.controllers;

import com.uniovi.sdi2122904spring.entities.Professor;
import com.uniovi.sdi2122904spring.services.MarksService;
import com.uniovi.sdi2122904spring.services.ProfessorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProfessorController {
    @Autowired //Inyectar el servicio
    private ProfessorService professorService;

    @RequestMapping("/professor/details/{dni}")
    public String getDetail(@PathVariable String dni) {
        //return professorService.getProfessor(dni).toString();
        return "details "+dni;
    }
    @RequestMapping(value = "/professor/add", method = RequestMethod.POST)
    public String setProfessor(@ModelAttribute Professor professor) {
        professorService.addProfessor(professor);
        return "added: " + professor.getDni()
                + " with dni : " + professor.getDepartment();
    }
    @RequestMapping(value = "/professor/add/{dni}")
    public String setProfessor(@PathVariable String dni) {
        return "add "+dni;
    }
    @RequestMapping("/professor/list")
    public String getList() {
        return professorService.getProfessors().toString();
    }
    @RequestMapping(value = "/professor/edit/{dni}")
    public String editProfessor(@PathVariable String dni) {
        return "editing "+dni;
    }
    @RequestMapping(value = "/professor/delete/{dni}")
    public String deleteProfessor(@PathVariable String dni) {
        //professorService.deleteMark(dni);
        return "remove "+dni;
    }
}
