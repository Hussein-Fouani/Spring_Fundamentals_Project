package com.hf.spring_fundamentals_project;

import com.hf.spring_fundamentals_project.controller.BeerController;
import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.service.BeerService;
import com.hf.spring_fundamentals_project.service.BeerServiceImpl;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class SpringFundamentalsProjectApplicationTests {

    MockMvc mockito;

    @MockBean
    BeerService beerService;
    BeerServiceImpl beerServiceimpl = new BeerServiceImpl();


    @Test
    void contextLoads() throws Exception {
        mockito.perform(get("api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
        Beer testcase = beerServiceimpl.listBeers().get(0);
        given(beerService.getBeerById(any(UUID.class))).willReturn(testcase);
    }

}
