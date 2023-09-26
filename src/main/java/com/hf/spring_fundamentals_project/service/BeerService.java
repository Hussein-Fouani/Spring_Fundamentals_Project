package com.hf.spring_fundamentals_project.service;

import com.hf.spring_fundamentals_project.model.Beer;

import java.util.List;
import java.util.UUID;

public interface BeerService {
    List<Beer> listBeers();

    Beer getBeerById(UUID id);

    Beer savenewBeer(Beer beer);

    void updateById(UUID beerId, Beer beer);

    void deleteById(UUID uuid, Beer beer);


    void updateBeerpatchById(UUID beerId, Beer beer);
}
