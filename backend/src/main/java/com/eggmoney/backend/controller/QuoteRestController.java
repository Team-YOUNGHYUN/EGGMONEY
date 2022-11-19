package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.service.QuoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api", produces = "application/text;charset=utf8")
public class QuoteRestController {

    @Autowired
    private QuoteService quoteService;

    @GetMapping("/quote")
    public ResponseEntity<String> selectQuote(){
        return new ResponseEntity<String>(quoteService.selectQuote(), HttpStatus.OK);
    }
}
