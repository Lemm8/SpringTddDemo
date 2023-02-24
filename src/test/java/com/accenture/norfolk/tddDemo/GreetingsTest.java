package com.accenture.norfolk.tddDemo;

import com.accenture.norfolk.tddDemo.services.GreetService;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GreetingsTest {

    @Test
    void itShouldGreetGivenFirstAndLastName() {
        GreetService greetService = new GreetService();
        String greetingsMessage = greetService.greeting("Luis", "Meza");
        assertEquals(greetingsMessage, "Hi, Luis Meza! Welcome to this system");
    }
}
