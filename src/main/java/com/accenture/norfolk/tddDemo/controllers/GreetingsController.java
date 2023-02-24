package com.accenture.norfolk.tddDemo.controllers;

import com.accenture.norfolk.tddDemo.services.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("greetings")
public class GreetingsController {

    @Autowired
    private GreetService greetService;

    @GetMapping
    public String greet(@RequestParam final String firstName, @RequestParam final String lastName) {
        return greetService.greeting(firstName, lastName);
    }
}
