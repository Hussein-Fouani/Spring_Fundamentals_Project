package com.hf.spring_fundamentals_project.controller;

import com.hf.spring_fundamentals_project.service.BeerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

@Controller
@AllArgsConstructor
public class BeerController {
    private final BeerService beerService;
}
