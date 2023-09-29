package com.hf.spring_fundamentals_project.controller;

import com.hf.spring_fundamentals_project.entities.BeerDTO;
import com.hf.spring_fundamentals_project.mappers.BeerMapper;
import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.repositories.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerIT {

    @Autowired
    BeerController beerController;
    @Autowired
    BeerRepository beerRepository;

    @Autowired
    BeerMapper beerMapper;


    @Test
    void updateExistingBeer(){
        Beer beer =  beerRepository.findAll().get(0);
        BeerDTO beerDTO = beerMapper.beer_To_BeerDTO(beer);
        beerDTO.setId(null);
        beerDTO.setVersion(null);
        final String beerName = "Updated";

        ResponseEntity response = beerController.UpdateByID(beer.getId(),beerDTO);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(204));

        Beer updatedBeer = beerRepository.findById(beer.getId()).get();
        assertThat(updatedBeer.getBeerName()).isEqualTo(beerName);
    }

    @Test
    void testListBeers() {
       List<BeerDTO> beerDTOList =beerController.listBeers();
        assertThat(beerDTOList.size()).isEqualTo(3);

    }

    @Test
    void testByIdBeerNotFound() {
        assertThrows(NotFoundException.class,()-> beerController.getBeerById(UUID.randomUUID()));

    }


    @Test
    @Rollback
    @Transactional
    void saveBeerTest() {
        BeerDTO beerDTO = BeerDTO.builder()
                .beerName("New Beer")
                .build();

        ResponseEntity response = beerController.handePost(beerDTO);
        assertThat(response.getStatusCode()).isEqualTo(HttpStatusCode.valueOf(201));
        assertThat(response.getHeaders().getLocation()).isNotNull();
        String[] locationUUID = response.getHeaders().getLocation().getPath().split("/");
        UUID savedUUID = UUID.fromString(locationUUID[4]);
        Beer beer = beerRepository.findById(savedUUID).get() ;
        assertThat(beer).isNotNull();

    }

    @Test
    void testBeerById() {
        Beer beer = beerRepository.findAll().get(0);
        BeerDTO beerDTO = beerController.getBeerById(beer.getId());
        assertThat(beerDTO).isNotNull();
    }

    @Transactional
    @Rollback
    @Test
    void testEmptylist() {
        beerRepository.deleteAll();
        List<BeerDTO> beerDTOList =beerController.listBeers();
        assertThat(beerDTOList.size()).isEqualTo(0);

    }
}