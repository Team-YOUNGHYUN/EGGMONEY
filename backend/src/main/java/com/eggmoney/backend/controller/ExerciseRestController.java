package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.Exercise;
import com.eggmoney.backend.model.service.ExerciseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ExerciseRestController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private ExerciseService exerciseService;

    @GetMapping("/exercise/part")
    public ResponseEntity<List<String>> selectAllExercisePart(){
        return new ResponseEntity<List<String>>(exerciseService.selectAllExercisePart(), HttpStatus.OK);
    }

    @GetMapping("/exercise")
    public ResponseEntity<List<Exercise>> selectAllExercise(){
        return new ResponseEntity<List<Exercise>>(exerciseService.selectAllExercise(), HttpStatus.OK);
    }

}
