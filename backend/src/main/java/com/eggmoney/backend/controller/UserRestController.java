package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.User;
import com.eggmoney.backend.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private UserService userService;

    // 사용자 로그인: POST, (email, password) 필요
    // 어디선가 사용자 seq 반환할 방법이 필요

    // 사용자 로그아웃: POST

    // 사용자 등록
    @PostMapping("/user")
    public ResponseEntity<String> regist(User user){
        userService.registUser(user);
        System.out.println(11111);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 사용자 상세
    @GetMapping("/user/{userSeq}")
    public ResponseEntity<String> detail(@PathVariable int userSeq){
        userService.userDetail(userSeq);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 사용자 수정
    @PutMapping("/user")
    public ResponseEntity<String> update(User user){
        userService.modifyUser(user);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 사용자 삭제
    @DeleteMapping("/user/{userSeq}")
    public ResponseEntity<String> delete(@PathVariable int userSeq){
        userService.removeUser(userSeq);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

}
