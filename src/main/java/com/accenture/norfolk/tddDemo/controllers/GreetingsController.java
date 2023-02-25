package com.accenture.norfolk.tddDemo.controllers;

import com.accenture.norfolk.tddDemo.services.GreetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@RequestMapping("greetings")
public class GreetingsController {

    @Autowired
    private GreetService greetService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public String greet(@RequestParam final String firstName, @RequestParam final String lastName) {
        return greetService.greeting(firstName, lastName);
    }
}
