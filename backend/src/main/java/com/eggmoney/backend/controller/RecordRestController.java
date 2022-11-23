package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.Record;
import com.eggmoney.backend.model.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RecordRestController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private RecordService recordService;

    // 운동 목록 반환
    @GetMapping("/record/{email}")
    public ResponseEntity<List<Record>> selectRecord(@PathVariable String email){;
        return new ResponseEntity<List<Record>>(recordService.selectRecord(email), HttpStatus.OK);
    }
    // 운동 기록 날짜 목록 반환
    @GetMapping("/record/date={email}")
    public ResponseEntity<List<String>> selectDate(@PathVariable String email){;
        return new ResponseEntity<List<String>>(recordService.selectDate(email), HttpStatus.OK);
    }

    // 운동 기록 등록
    @PostMapping("/record")
    public ResponseEntity<String> insertRecord(Record record){
        recordService.addRecord(record);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 운동 기록 삭제
    @DeleteMapping("/record/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable int id){
        recordService.removeRecord(id);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

}
