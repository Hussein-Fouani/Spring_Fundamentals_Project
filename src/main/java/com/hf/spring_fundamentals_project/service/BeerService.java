package com.hf.spring_fundamentals_project.service;

import com.hf.spring_fundamentals_project.model.Beer;

import java.util.UUID;

public interface BeerService {
    Beer getBeerById(UUID id);
}
