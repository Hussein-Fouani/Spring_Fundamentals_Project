package com.hf.spring_fundamentals_project.service;

import com.hf.spring_fundamentals_project.entities.BeerDTO;
import com.hf.spring_fundamentals_project.mappers.BeerMapper;
import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.repositories.BeerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Primary
@RequiredArgsConstructor
public class BeerServiceJPA implements BeerService {
     private final BeerRepository beerRepository;
     private final BeerMapper beerMapper;
    @Override
    public List<BeerDTO> listBeers() {
        return beerRepository.findAll()
                .stream().map(beerMapper::beer_To_BeerDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<BeerDTO> getBeerById(UUID id) {
        return Optional.ofNullable(beerMapper.beer_To_BeerDTO(  beerRepository.findById(id).orElse(null)));
    }

    @Override
    public Beer savenewBeer(Beer beer) {
        return null;
    }

    @Override
    public void updateById(UUID beerId, Beer beer) {

    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void updateBeerpatchById(UUID beerId, Beer beer) {

    }
}
