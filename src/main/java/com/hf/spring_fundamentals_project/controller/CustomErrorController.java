package com.hf.spring_fundamentals_project.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@ControllerAdvice
public class CustomErrorController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    ResponseEntity handleErrors(MethodArgumentNotValidException e){
        List errorList = e.getFieldErrors().stream().map(fieldError->{
            Map<String,String> er = new HashMap<>();
            er.put(fieldError.getField(),fieldError.getDefaultMessage());
            return er;
        }).toList();
        return  ResponseEntity.badRequest().body(e.getBindingResult().getFieldErrors());

    }
}
