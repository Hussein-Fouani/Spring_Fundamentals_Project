package com.hf.spring_fundamentals_project;

import com.hf.spring_fundamentals_project.controller.BeerController;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class SpringFundamentalsProjectApplicationTests {

    MockMvc mockito;
    @Test
    void contextLoads() throws Exception {
        mockito.perform(get("api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
