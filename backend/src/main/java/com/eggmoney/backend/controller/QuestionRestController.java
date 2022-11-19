package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.Question;
import com.eggmoney.backend.model.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class QuestionRestController {

    @Autowired
    private QuestionService questionService;

    @GetMapping("/question")
    public ResponseEntity<List<Question>> selectList() {
        return new ResponseEntity<List<Question>>(questionService.selectList(), HttpStatus.OK);
    }

    @GetMapping("/question/{userSeq}")
    public ResponseEntity<Question> selectQuestion(@PathVariable int userSeq) {
        return new ResponseEntity<Question>(questionService.selectQuestion(userSeq), HttpStatus.OK);
    }

}
