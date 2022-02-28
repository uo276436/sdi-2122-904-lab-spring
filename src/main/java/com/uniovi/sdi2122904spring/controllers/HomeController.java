package com.uniovi.sdi2122904spring.controllers;
import com.uniovi.sdi2122904spring.entities.Mark;
import com.uniovi.sdi2122904spring.entities.User;
import com.uniovi.sdi2122904spring.services.MarksService;
import com.uniovi.sdi2122904spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;
import java.util.LinkedList;

@Controller
public class HomeController {

    @Autowired //Inyectar el servicio
    private MarksService marksService;
    // Inyectamos el servicio
    @Autowired
    private UsersService usersService;
    @RequestMapping("/")
    public String index(Model model, Pageable pageable, Principal principal, @RequestParam(value = "", required = false) String searchText) {
        String dni = principal.getName(); // DNI es el name de la autenticación
        User user = usersService.getUserByDni(dni);
        Page<Mark> marks = new PageImpl<Mark>(new LinkedList<Mark>());
        marks = marksService.getMarksForUser(pageable, user);
        model.addAttribute("markList", marks);
        model.addAttribute("page", marks);
        return "index";
    }
}