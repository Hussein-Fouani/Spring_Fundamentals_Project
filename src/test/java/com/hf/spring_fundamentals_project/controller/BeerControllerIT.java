package com.hf.spring_fundamentals_project.controller;

import com.hf.spring_fundamentals_project.entities.BeerDTO;
import com.hf.spring_fundamentals_project.repositories.BeerRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BeerControllerIT {

    @Autowired
    BeerController beerController;
    @Autowired
    BeerRepository beerRepository;


    @Test
    void testListBeers() {
       List<BeerDTO> beerDTOList =beerController.listBeers();
        assertThat(beerDTOList.size()).isEqualTo(3);

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