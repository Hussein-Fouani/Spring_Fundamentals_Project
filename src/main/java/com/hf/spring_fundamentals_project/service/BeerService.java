package com.hf.spring_fundamentals_project.service;

import com.hf.spring_fundamentals_project.entities.BeerDTO;
import com.hf.spring_fundamentals_project.model.Beer;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface BeerService {
    List<BeerDTO> listBeers();

    Optional<BeerDTO> getBeerById(UUID id);

    Beer savenewBeer(Beer beer);

    void updateById(UUID beerId, Beer beer);

    void deleteById(UUID uuid);


    void updateBeerpatchById(UUID beerId, Beer beer);
}
