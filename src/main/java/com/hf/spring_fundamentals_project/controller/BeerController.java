package com.hf.spring_fundamentals_project.controller;

import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@AllArgsConstructor
public class BeerController {
    private final BeerService beerService;

    @RequestMapping("/api/v1/beer")
    public List<Beer> listBeers(){
        return beerService.listBeers();

    }

    public Beer getBeerById(UUID id) {

        log.debug("Get Bear by ID -in services. id" + id.toString());
        return beerService.getBeerById(id);
    }
}
