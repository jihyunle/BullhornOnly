package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    BasicBullhornRepository basicBullhornRepository;

    /* lists all message entries*/
    @RequestMapping("/")
    public String listBullhorn(Model model){
        model.addAttribute("basicBullhorns", basicBullhornRepository.findAll());
        return "list";
    }

    /* allows user to post a new message*/
    @GetMapping("/add")
    public String bullhornForm(Model model){
        model.addAttribute("basicBullhorn", new BasicBullhorn());
        return "basicBullhornform";
    }

    @PostMapping("/process")
    public String processForm(@Valid BasicBullhorn basicBullhorn, BindingResult result,
                              @RequestParam("postedDate") String postedDate){
        if (result.hasErrors()){
            return "basicbullhornform";  /* posts a new message if entry is valid*/
        }

        Date date = new Date();

        try {
            date = new SimpleDateFormat("MM-dd-YY").parse(postedDate);

        } catch (Exception e) {
            e.printStackTrace();

        }

        basicBullhorn.setPostedDate(date);
        basicBullhornRepository.save(basicBullhorn);
        return "redirect:/";    /* redirects the user to main page if invalid*/
    }


    /* takes user to the message details page*/
    @RequestMapping("/detail/{id}")
    public String showBullhorn(@PathVariable("id") long id, Model model){
        model.addAttribute("basicBullhorn", basicBullhornRepository.findById(id).get());
        return "show";
    }

    /* takes user to the message form */
    @RequestMapping("/update/{id}")
    public String updateBullhorn(@PathVariable("id") long id, Model model){
        model.addAttribute("basicBullhorn", basicBullhornRepository.findById(id).get());
        return "basicBullhornform";
    }

    /* deletes by ID then redirects the user to main page*/
    @RequestMapping("/delete/{id}")
    public String delBullhorn(@PathVariable("id") long id){
        basicBullhornRepository.deleteById(id);
        return "redirect:/";
    }
}
