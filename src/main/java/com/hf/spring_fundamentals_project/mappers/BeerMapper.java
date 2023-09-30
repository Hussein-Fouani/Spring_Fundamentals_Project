package com.hf.spring_fundamentals_project.mappers;

import com.hf.spring_fundamentals_project.entities.Beer;
import com.hf.spring_fundamentals_project.model.BeerDTO;
import org.mapstruct.Mapper;

@Mapper
public interface BeerMapper {

    Beer beerDtoToBeer(BeerDTO dto);

    BeerDTO beerToBeerDto(Beer beer);

}
