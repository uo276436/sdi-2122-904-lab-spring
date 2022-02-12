package com.uniovi.sdi2122904spring.controllers;
import com.uniovi.sdi2122904spring.entities.Mark;
import org.springframework.web.bind.annotation.*;

@RestController
public class MarksController {
    @RequestMapping("/mark/list")
    public String getList() {
        return "Getting List";
    }
    /*@RequestMapping(value ="/mark/add", method = RequestMethod.POST)
    public String setMark(@RequestParam String description, @RequestParam String score) {
        return "Added: " + description + "with score: " + score;
    }*/
    @RequestMapping(value = "/mark/add", method = RequestMethod.POST)
    public String setMark(@ModelAttribute Mark mark) {
        return "added: " + mark.getDescription()
                + " with score : " + mark.getScore()
                + " id: " + mark.getId();
    }

    /*
    @RequestMapping("/mark/details")//http://localhost:8090/mark/details?id=2
    public String getDetail(@RequestParam Long id) {
     return "Getting Details =>" + id;
    }
    */
    @RequestMapping("/mark/details/{id}") //http://localhost:8090/mark/details/4
    public String getDetail(@PathVariable Long id) {
        return "Getting Details =>" + id;
    }

}
