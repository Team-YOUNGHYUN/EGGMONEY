package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/api")
public class QuoteRestController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quote")
    public ResponseEntity<String> selectQuote(int id){
        Random rand = new Random();
        id = rand.nextInt(20);
        return new ResponseEntity<String>(quoteService.selectQuote(id), HttpStatus.OK);
    }
}
