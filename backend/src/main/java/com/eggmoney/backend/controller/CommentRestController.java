package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.Comment;
import com.eggmoney.backend.model.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class CommentRestController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private CommentService commentService;

    // 코멘트 등록
    @PostMapping("/comment")
    public ResponseEntity<String> insertComment(Comment comment){
        commentService.registComment(comment);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    @GetMapping("/comment")
    // 코멘트 상세
    public ResponseEntity<Comment> commentDetail(String email, String date){
        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("date", date);
        return new ResponseEntity<Comment>(commentService.commentDetail(params), HttpStatus.OK);
    }

    // 코멘트 수정
    @PutMapping("/comment")
    public ResponseEntity<String> updateComment(Comment comment){
        commentService.modifyComment(comment);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

}
