package com.hf.spring_fundamentals_project.mappers;

import com.hf.spring_fundamentals_project.entities.BeerDTO;
import com.hf.spring_fundamentals_project.model.Beer;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDTO_To_Beer(BeerDTO dto);
    BeerDTO beer_To_BeerDTO(Beer beer_b);



}
