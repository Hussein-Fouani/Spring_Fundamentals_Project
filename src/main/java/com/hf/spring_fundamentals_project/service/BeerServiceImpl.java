package com.hf.spring_fundamentals_project.service;

import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    BeerService beerService;

    @Override
    public Beer getBeerById(UUID id) {
        return Beer.builder().id(id)
                        .version(1)
                                .beerName("Galaxy Cat")
                                        .beerStyle(BeerStyle.Pale_ALe)
                                                .upc("12345")
                                                        .price(new BigDecimal("13.06"))
                                                                .quantityonHand("122")
                                                                        .createdDate(LocalDateTime.now())
                                                                                .updatedDate(LocalDateTime.now()).build();
    }
}
