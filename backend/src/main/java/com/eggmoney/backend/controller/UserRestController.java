package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.User;
import com.eggmoney.backend.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api")
public class UserRestController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private UserService userService;

    // 사용자 등록
    @PostMapping("/user")
    public ResponseEntity<String> regist(User user){
        userService.registUser(user);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 사용자 상세
    @GetMapping("/user/{email}")
    public ResponseEntity<User> detail(@PathVariable String email){
        return new ResponseEntity<User>(userService.userDetail(email), HttpStatus.OK);
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

    // 이메일 중복 체크
    @GetMapping("/check/email={email}")
    public ResponseEntity<Integer> checkEmail(@PathVariable String email){
        return new ResponseEntity<Integer>(userService.checkEmail(email), HttpStatus.OK);
    }

    // 닉네임 중복 체크
    @GetMapping("/check/nickname={nickname}")
    public ResponseEntity<Integer> checkNickname(@PathVariable String nickname){
        return new ResponseEntity<Integer>(userService.checkNickName(nickname), HttpStatus.OK);
    }


    // 비밀번호 일치 검사
//    int checkPassword(HashMap<String, String> params);
    @GetMapping("/check/password")
    public ResponseEntity<Integer> checkPassword(String email, String password){
        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        return new ResponseEntity<Integer>(userService.checkPassword(params), HttpStatus.OK);
    }

    // 비밀번호 찾기 답변 일치 검사
//    int checkFindpw(HashMap<String, String> params);
    @GetMapping("/check/findpw")
    public ResponseEntity<Integer> checkFindpw(String email, String pwFindAnswer){
        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("pwFindAnswer", pwFindAnswer);
        return new ResponseEntity<Integer>(userService.checkFindpw(params), HttpStatus.OK);
    }

    // 비밀번호 수정
//    void updatePassword(HashMap<String, String> params);
    @PutMapping("/check/password")
    public ResponseEntity<String> updatePassword(String email, String password){
        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("password", password);
        userService.updatePassword(params);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 비밀번호 찾기 답변 수정
//    void updateFindpw(HashMap<String, String> params);
    @PutMapping("/check/findpw")
    public ResponseEntity<String> updateFindpw(String email, String pwFindAnswer){
        HashMap<String, String> params = new HashMap<>();
        params.put("email", email);
        params.put("pwFindAnswer", pwFindAnswer);
        userService.updateFindpw(params);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }


}
