package com.uniovi.sdi2122904spring.controllers;
import com.uniovi.sdi2122904spring.entities.Mark;
import com.uniovi.sdi2122904spring.entities.User;
import com.uniovi.sdi2122904spring.services.MarksService;
import com.uniovi.sdi2122904spring.services.UsersService;
import com.uniovi.sdi2122904spring.validators.MarkFormValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

//@RestController
@Controller
public class MarksController {

    @Autowired //Inyectar el servicio
    private MarksService marksService;
    // Inyectamos el servicio
    @Autowired
    private UsersService usersService;
    @Autowired
    private MarkFormValidator markFormValidator;

    @RequestMapping(value = "/mark/add")
    public String getMark(Model model){
        model.addAttribute("usersList", usersService.getUsers());
        model.addAttribute("mark", new Mark());
        return "mark/add";
    }

    @RequestMapping("/mark/list")
    public String getList(Model model) {
        model.addAttribute("markList", marksService.getMarks());
        return "mark/list";
    }
    /*
    @RequestMapping("/mark/list")
    public String getList() {
        return marksService.getMarks().toString();
    }
    /*@RequestMapping(value ="/mark/add", method = RequestMethod.POST)
    public String setMark(@RequestParam String description, @RequestParam String score) {
        return "Added: " + description + "with score: " + score;
    }*/
    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@Validated Mark mark, BindingResult result, Model model) {
        markFormValidator.validate(mark, result);
        if(result.hasErrors()) {
            model.addAttribute("usersList", usersService.getUsers());
            return "/mark/add";
        }
        marksService.addMark(mark);
        return "redirect:/mark/list";
    }

    /*
    @RequestMapping("/mark/details")//http://localhost:8090/mark/details?id=2
    public String getDetail(@RequestParam Long id) {
     return "Getting Details =>" + id;
    }

    @RequestMapping("/mark/details/{id}") //http://localhost:8090/mark/details/4
    public String getDetail(@PathVariable Long id) {
        //return "Getting Details =>" + id;
        return marksService.getMark(id).toString();
    }*/
    @RequestMapping("/mark/details/{id}")
    public String getDetail(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        return "mark/details";
    }

    @RequestMapping("/mark/delete/{id}")
    public String deleteMark(@PathVariable Long id) {
        marksService.deleteMark(id);
        return "redirect:/mark/list";
    }
    @RequestMapping(value = "/mark/edit/{id}")
    public String getEdit(Model model, @PathVariable Long id) {
        model.addAttribute("mark", marksService.getMark(id));
        model.addAttribute("usersList", usersService.getUsers());
        return "mark/edit";
    }
    @RequestMapping(value="/mark/edit/{id}", method=RequestMethod.POST)
    public String setEdit(@ModelAttribute Mark mark, @PathVariable Long id){
        Mark originalMark = marksService.getMark(id);
        // modificar solo score y description
        originalMark.setScore(mark.getScore());
        originalMark.setDescription(mark.getDescription());
        marksService.addMark(originalMark);
        return "redirect:/mark/details/"+id;
    }

    @RequestMapping("/mark/list/update")
    public String updateList(Model model){
        model.addAttribute("markList", marksService.getMarks() );
        return "mark/list :: tableMarks";
    }
}
