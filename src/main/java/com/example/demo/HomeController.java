package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
    @Autowired
    BasicBullhornRepository basicBullhornRepository;

    /* lists all message entries*/
    @RequestMapping("/")
    public String listBullhorn(Model model){
        model.addAttribute("bullhorns", basicBullhornRepository.findAll());
        return "list";
    }
}
