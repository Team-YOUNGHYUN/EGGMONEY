package com.eggmoney.backend.controller;

import com.eggmoney.backend.model.dto.Achvm;
import com.eggmoney.backend.model.service.AchvmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/api")
public class AchvmRestController {

    private static final String SUCCESS = "success";
    private static final String FAIL = "fail";

    @Autowired
    private AchvmService achvmService;

    // 사용자가 달성한 업적 리스트 조회
    @GetMapping("/achvm/true/{userSeq}")
    public ResponseEntity<List<Achvm>> selectTrueAchvm(@PathVariable int userSeq){
        return new ResponseEntity<List<Achvm>>(achvmService.selectTrueAchvm(userSeq), HttpStatus.OK);
    }

    // 사용자가 달성하지 못한 업적 리스트 조회
    @GetMapping("/achvm/false/{userSeq}")
    public ResponseEntity<List<Achvm>> selectFalseAchvm(@PathVariable int userSeq){
        return new ResponseEntity<List<Achvm>>(achvmService.selectFalseAchvm(userSeq), HttpStatus.OK);
    }

    // 사용자가 달성한 업적의 id 등록
    @PutMapping("/achvm/{userSeq}={achvmId}")
    public ResponseEntity<String> selectTrueAchvm(@PathVariable int userSeq, @PathVariable int achvmId){
        HashMap<String, Integer> params = new HashMap<>();
        params.put("userSeq", userSeq);
        params.put("achvmId", achvmId);
        achvmService.addAchvmId(params);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

    // 사용자의 업적 획득 정보 삭제 (탈퇴 시)
//    void deleteAchvmId(int userSeq);
    @DeleteMapping("/achvm/{userSeq}")
    public ResponseEntity<String> deleteAchvmId(@PathVariable int userSeq){
        achvmService.removeAchvmId(userSeq);
        return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
    }

}
