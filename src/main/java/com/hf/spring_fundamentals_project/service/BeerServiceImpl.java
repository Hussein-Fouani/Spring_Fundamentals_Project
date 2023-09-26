package com.hf.spring_fundamentals_project.service;

import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.model.BeerStyle;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.*;

@Service
@Slf4j
public class BeerServiceImpl implements BeerService {
    BeerService beerService;

    @Override
    public List<Beer> listBeers(){
        return new ArrayList<>(beerMap.values());
    }

    public Map<UUID, Beer> beerMap;

    @Override
    public Beer getBeerById(UUID id) {
        return beerMap.get(id);
    }

    @Override
    public Beer savenewBeer(Beer beer) {
        Beer beer1 = Beer.builder().
                id(beer.getId())
                        .beerName(beer.getBeerName())
                                .beerStyle(beer.getBeerStyle())
                                        .quantityonHand(beer.getQuantityonHand())
                                                .createdDate(beer.getCreatedDate())
                                                        .price(beer.getPrice())
                                                            .version(1)
                                                                .upc(beer.getUpc()).build();

        beerMap.put(beer.getId(),beer1) ;
        return beer1;
    }

    @Override
    public void updateById(UUID beerId, Beer beer) {

        Beer beer1  = beerMap.get( beer);
        beer1.setBeerName(beer.getBeerName());
        beer1.setBeerStyle(beer.getBeerStyle());
        beer1.setPrice(beer.getPrice());
        beer1.setCreatedDate(beer.getCreatedDate());
        beer1.setQuantityonHand(beer.getQuantityonHand());
        beer1.setVersion(beer.getVersion());
        beer1.setUpdatedDate(beer.getUpdatedDate());
        beerMap.put(beer1.getId(),beer1);
    }

    @Override
    public void deleteById(UUID uuid, Beer beer) {
        Beer beer1 = beerMap.remove(beer.getId());
    }

    @Override
    public void updateBeerpatchById(UUID beerId, Beer beer) {

    }

    public BeerServiceImpl() {
        beerMap = new HashMap<>();
        Beer beer1 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Galaxy Cat")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356")
                .price(new BigDecimal("12.99"))
                .quantityonHand(122)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer2 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Crank")
                .beerStyle(BeerStyle.PALE_ALE)
                .upc("12356222")
                .price(new BigDecimal("11.99"))
                .quantityonHand(392)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        Beer beer3 = Beer.builder()
                .id(UUID.randomUUID())
                .version(1)
                .beerName("Sunshine City")
                .beerStyle(BeerStyle.IPA)
                .upc("12356")
                .price(new BigDecimal("13.99"))
                .quantityonHand(144)
                .createdDate(LocalDateTime.now())
                .updatedDate(LocalDateTime.now())
                .build();

        beerMap.put (beer1.getId(), beer1);
        beerMap.put(beer2.getId(), beer2);
        beerMap.put(beer3.getId(), beer3);
    }
}

