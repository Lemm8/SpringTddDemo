package com.accenture.norfolk.tddDemo;

import com.accenture.norfolk.tddDemo.controllers.GreetingsController;
import com.accenture.norfolk.tddDemo.services.GreetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = GreetingsController.class)
@AutoConfigureMockMvc
public class GreetingsControllerTest {

    @Autowired
    private MockMvc mvc;
    @MockBean
    private GreetService greetService;

    @BeforeEach
    public void setUp(){
        when(greetService.greeting(any(), any())).
            thenCallRealMethod();
    }

    @Test
    void itShouldGreet_WhenGetGreet() throws Exception {
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get("http://localhost:7000/greetings")
                        .param("firstName", "Luis")
                        .param("lastName", "Meza")
                .accept(MediaType.ALL_VALUE))
                .andDo(MockMvcResultHandlers.print())
                .andExpect(status().isOk())
                .andReturn();
        String content = result.getResponse().getContentAsString();
        assertEquals("Hi, Luis Meza! Welcome to this system", content);
    }
}
