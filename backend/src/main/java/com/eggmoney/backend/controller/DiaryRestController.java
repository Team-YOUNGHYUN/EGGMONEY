package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.Comment;
import com.eggmoney.backend.model.dto.Diary;
import com.eggmoney.backend.model.dto.Record;
import com.eggmoney.backend.model.service.DiaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class DiaryRestController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private DiaryService diaryService;

    // 다이어리 상세
    @GetMapping("/diary/{userSeq}/{regDate}")
    public ResponseEntity<Diary> selectDiary(@PathVariable int userSeq, @PathVariable String regDate){
        return new ResponseEntity<Diary>(diaryService.selectDiary(userSeq, regDate), HttpStatus.OK);
    }

    // 운동 기록 등록
    @PostMapping("/diary")
    public ResponseEntity<String> insertRecord(Record record){
        diaryService.addRecord(record);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 운동 기록 삭제
    @DeleteMapping("/diary/{id}")
    public ResponseEntity<String> deleteRecord(@PathVariable int id){
        diaryService.removeRecord(id);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 하루 갈무리 수정
    @PutMapping("/diary")
    public ResponseEntity<String> updateComment(Comment comment){
        diaryService.modifyComment(comment);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }
}
