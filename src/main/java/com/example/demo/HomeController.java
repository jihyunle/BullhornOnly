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
        model.addAttribute("bullhorns", basicBullhornRepository.findAll());
        return "list";
    }

    /* allows user to post a new message*/
    @GetMapping("/add")
    public String bullhornForm(Model model){
        model.addAttribute("bullhorn", new BasicBullhorn());
        return "bullhornform";
    }

    @PostMapping("/process")
    public String processForm(@Valid BasicBullhorn basicBullhorn, BindingResult result,
                              @RequestParam("postedDate") String postDate){
        if (result.hasErrors()){
            return "bullhornform";  /* posts a new message if entry is valid*/
        }

        Date date = new Date();

        try {
            date = new SimpleDateFormat("mm/dd/yy").parse(postDate);
        } catch (Exception e) {
            e.printStackTrace();
        }

        basicBullhorn.setPostedDate(date);
        basicBullhornRepository.save(basicBullhorn);
        return "redirect:/";    /* redirects the user to main page if invalid*/
    }

    /* takes user to the form */
    @RequestMapping("/update/{id}")
    public String updateBullhorn(@PathVariable("id") long id, Model model){
        model.addAttribute("bullhorn", basicBullhornRepository.findById(id).get());
        return "bullhornform";
    }

    /* takes user to the message details page*/
    @RequestMapping("/detail/{id}")
    public String showBullhorn(@PathVariable("id") long id, Model model){
        model.addAttribute("bullhorn", basicBullhornRepository.findById(id).get());
        return "show";
    }

    /* deletes by ID then redirects the user to main page*/
    @RequestMapping("/delete/{id}")
    public String delBullhorn(@PathVariable("id") long id){
        basicBullhornRepository.deleteById(id);
        return "redirect:/";
    }
}
