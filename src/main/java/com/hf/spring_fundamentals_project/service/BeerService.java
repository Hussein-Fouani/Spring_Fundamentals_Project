package com.hf.spring_fundamentals_project.service;

import com.hf.spring_fundamentals_project.model.BeerDTO;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.UUID;

public interface BeerService {

    List<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID id);

    BeerDTO saveNewBeer(BeerDTO beer);

    Optional<BeerDTO> updateBeerById(UUID beerId, BeerDTO beer);

    void deleteById(UUID beerId);

    void patchBeerById(UUID beerId, BeerDTO beer);


}