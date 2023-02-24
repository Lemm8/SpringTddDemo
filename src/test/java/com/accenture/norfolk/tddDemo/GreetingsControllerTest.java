package com.accenture.norfolk.tddDemo;

import com.accenture.norfolk.tddDemo.controllers.GreetingsController;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(GreetingsController.class)
public class GreetingsControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void itShouldGreet_WhenGetGreet() throws Exception {
        mvc.perform(MockMvcRequestBuilders.get("/greetings?firstName=Luis&lastName=Meza")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("Hi, Luis Meza! Welcome to this system"));
    }
}
