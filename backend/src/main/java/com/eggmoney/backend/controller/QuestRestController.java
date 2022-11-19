package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.Quest;
import com.eggmoney.backend.model.service.QuestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class QuestRestController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private QuestService questService;

    // 퀘스트 등록(회원가입 시)
    @PostMapping("/quest/{userSeq}")
    public ResponseEntity<String> insertQuest(@PathVariable int userSeq){
        questService.addQuest(userSeq);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 퀘스트 상세
    @GetMapping("/quest/{userSeq}")
    public ResponseEntity<Quest> selectQuest(@PathVariable int userSeq){
        return new ResponseEntity<Quest>(questService.selectQuest(userSeq), HttpStatus.OK);
    }

    // 퀘스트 수정
    @PutMapping("/quest")
    public ResponseEntity<String> updateQuest(Quest quest){
        questService.modifyQuest(quest);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 퀘스트 삭제 (탈퇴 시)
    @DeleteMapping("/quest/{userSeq}")
    public ResponseEntity<String> deleteQuest(@PathVariable int userSeq){
        questService.removeQuest(userSeq);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }
}
