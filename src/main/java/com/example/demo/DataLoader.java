package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class DataLoader implements CommandLineRunner {
    @Autowired
    MessageRepository repository;

    @Override
    public void run(String...strings) throws Exception{

        Message message = new Message("Who wants an Americano",
                "Hey, I'm about to make a run to Java Junction. Who's in?",
                "J.Lee");
        String sDate1 = "03-01-19";
        Date date1 = new SimpleDateFormat("MM-dd-YY").parse(sDate1);
        message.setPostedDate(date1);
        repository.save(message);


        message = new Message("I am!",
                "@J.Lee Can you get me a shot of espresso? I have a deadline today and missed my morning coffee. Thanks!",
                "M.Choi");
        sDate1 = "03-01-19";
        date1 = new SimpleDateFormat("MM-dd-YY").parse(sDate1);
        message.setPostedDate(date1);
        repository.save(message);


        message = new Message("Election day",
                "About to get some donuts for the election view party, who's interested?",
                "H.Hermoine");
        sDate1 = "11-04-18";
        date1 = new SimpleDateFormat("MM-dd-YY").parse(sDate1);
        message.setPostedDate(date1);
        repository.save(message);


        message = new Message("Japanese stationary",
                "I am looking for a new planner for the new year. Are there any japanese brands that you recommend?",
                "R.Weasley");
        sDate1 = "01-15-19";
        date1 = new SimpleDateFormat("MM-dd-YY").parse(sDate1);
        message.setPostedDate(date1);
        repository.save(message);


        message = new Message("Matcha coffee?",
                "@R.Weasley I have no japanese planner but I can offer you a matcha green tea latte..",
                "C.Weasley");
        sDate1 = "01-15-19";
        date1 = new SimpleDateFormat("MM-dd-YY").parse(sDate1);
        message.setPostedDate(date1);
        repository.save(message);


        message = new Message(" :x ",
                "@C.Weasley Oh you fancy shmancy.",
                "R.Weasley");
        sDate1 = "01-15-19";
        date1 = new SimpleDateFormat("MM-dd-YY").parse(sDate1);
        message.setPostedDate(date1);
        repository.save(message);

    }


}

