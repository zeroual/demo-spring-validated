package com.example.demomongo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HelloControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturn200() throws Exception {
        mockMvc.perform(get("/check/0663017997"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturn400() throws Exception {
        mockMvc.perform(get("/check/abdel"))
                .andExpect(status().isBadRequest());
    }
}