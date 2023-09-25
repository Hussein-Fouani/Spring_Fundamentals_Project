package com.hf.spring_fundamentals_project.controller;

import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
@Slf4j
@AllArgsConstructor
public class BeerController {
    private final BeerService beerService;

    public Beer getBeerById(UUID id) {
        return beerService.getBeerById(id);
    }
}
