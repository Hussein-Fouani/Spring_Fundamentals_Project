package com.hf.spring_fundamentals_project;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hf.spring_fundamentals_project.controller.BeerController;
import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.service.BeerService;
import com.hf.spring_fundamentals_project.service.BeerServiceImpl;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.awt.*;
import java.util.UUID;

import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class SpringFundamentalsProjectApplicationTests {

    MockMvc mockito;

    @MockBean
    BeerService beerService;
    BeerServiceImpl beerServiceimpl = new BeerServiceImpl();

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testlistBeers() throws Exception {
        given(beerService.listBeers()).willReturn(beerServiceimpl.listBeers());

        mockito.perform(get("api/v1/beer").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()",is(3)));

    }

    @Test
    void testCreateNewBear() throws JsonProcessingException {
        Beer beer = beerServiceimpl.listBeers().get(0);
        System.out.println(objectMapper.writeValueAsString(beer));
    }

    @Test
    void contextLoads() throws Exception {
        Beer testcase = beerServiceimpl.listBeers().get(0);
        mockito.perform(get("api/v1/beer/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect( jsonPath("$.id",is(testcase.getId().toString())));
        given(beerService.getBeerById(testcase.getId())).willReturn(testcase);
    }

}
