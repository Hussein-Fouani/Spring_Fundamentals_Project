package com.hf.spring_fundamentals_project.controller;

import com.hf.spring_fundamentals_project.model.Beer;
import com.hf.spring_fundamentals_project.service.BeerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@Slf4j
@AllArgsConstructor
public class BeerController {
    public final BeerService beerService;

    public static final String beerPath ="api/v1/beer";
    public static final String beerIDPath =beerPath + "/{beerId}";

    @DeleteMapping("beerIDPath")
    public ResponseEntity deleteById(@PathVariable  UUID beerId,Beer beer){

        beerService.deleteById(beerId);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("beerIDPath")
    public ResponseEntity updateBeerPatchById(@PathVariable UUID beerId,Beer beer){
        beerService.updateBeerpatchById(beerId,beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }


    @PutMapping("beerIDPath")
    public ResponseEntity UpdateByID(@PathVariable UUID beerId, @RequestBody Beer beer){
        beerService.updateById(beerId,beer);
        return new ResponseEntity(HttpStatus.NO_CONTENT);

    }
    public ResponseEntity handePost(@RequestBody Beer beer){
        Beer beer1 = beerService.savenewBeer(beer);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Location","/api/v1/beer/" + beer1.getId().toString());

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PostMapping
    @GetMapping(beerPath)
    public List<Beer> listBeers(){
        return beerService.listBeers();

    }


    @GetMapping(value = "beerIDPath")
    public Beer getBeerById(@PathVariable("beerId") UUID beerId) {

        log.debug("Get Bear by ID -in services. id" + beerId.toString());
        return beerService.getBeerById(beerId).orElseThrow(NotFoundException::new);
    }
}
