package com.accenture.norfolk.tddDemo.services;

import org.springframework.stereotype.Service;

@Service
public class GreetService {
    public String greeting(String firstName, String lastName) {
        return String.valueOf(new StringBuilder("Hi, ")
                .append(firstName)
                .append(" " + lastName)
                .append("! Welcome to this system"));
    }
}
