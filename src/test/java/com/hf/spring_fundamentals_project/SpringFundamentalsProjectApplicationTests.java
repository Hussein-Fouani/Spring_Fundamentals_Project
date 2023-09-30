package com.hf.spring_fundamentals_project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hf.spring_fundamentals_project.controller.BeerController;
import com.hf.spring_fundamentals_project.entities.Beer;
import com.hf.spring_fundamentals_project.model.BeerDTO;
import com.hf.spring_fundamentals_project.service.BeerService;
import com.hf.spring_fundamentals_project.service.BeerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import static com.hf.spring_fundamentals_project.controller.BeerController.BEER_PATH;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(BeerController.class)
class SpringFundamentalsProjectApplicationTests {

    MockMvc mockito;


    @MockBean
    BeerService beerService;
    BeerServiceImpl beerServiceimpl ;

    @Captor
    ArgumentCaptor<UUID> uuidArgumentCaptor;

    @Captor
    ArgumentCaptor<Beer> beerArgumentCaptor;


    @Autowired
    ObjectMapper objectMapper;

    @BeforeEach
    void setup(){
        beerServiceimpl = new BeerServiceImpl();
    }



//    @Test
////    void testDeleteBeer() throws Exception {
////        BeerDTO beer = beerServiceimpl.listBeers().get(0);
////
////        mockito.perform(delete(BEER_PATH +"/"+ beer.getId()).accept(MediaType.APPLICATION_JSON))
////                .andExpect(status().isNoContent());
////        uuidArgumentCaptor = ArgumentCaptor.forClass(UUID.class);
////        verify(beerService).deleteById(uuidArgumentCaptor.capture());
////
////        assertThat(beer.getId()).isEqualTo(uuidArgumentCaptor.getValue());
////    }

    @Test
    void testlistBeers() throws Exception {
        given(beerService.listBeers()).willReturn(beerServiceimpl.listBeers());

        mockito.perform(get(BEER_PATH).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$.length()",is(3)));

    }

    @Test
    void testCreateNewBear() throws Exception {
        BeerDTO beer = beerServiceimpl.listBeers().get(0);
        beer.setVersion(null);
        beer.setId(null);
        given(beerServiceimpl.saveNewBeer(any(BeerDTO.class))).willReturn(beerServiceimpl.listBeers().get(1));
        mockito.perform(post(BEER_PATH).accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON).content(objectMapper.writeValueAsString(beer)))
                .andExpect(status().isCreated())
                .andExpect(header().exists("locations"));
    }

    @Test
    void contextLoads() throws Exception {
        BeerDTO testcase = beerServiceimpl.listBeers().get(0);
        mockito.perform(get(BEER_PATH +"/" + UUID.randomUUID()).accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect(content().contentType(MediaType.APPLICATION_JSON)).andExpect( jsonPath("$.id",is(testcase.getId().toString())));
        given(beerService.getBeerById(testcase.getId())).willReturn(Optional.of(testcase));
    }

}
