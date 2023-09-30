package com.hf.spring_fundamentals_project.repositories;

import com.hf.spring_fundamentals_project.entities.Beer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface BeerRepository extends JpaRepository<Beer, UUID> {
}
