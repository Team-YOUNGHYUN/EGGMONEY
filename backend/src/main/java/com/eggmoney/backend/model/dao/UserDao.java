package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.User;

import java.util.HashMap;

public interface UserDao {
    // 사용자 등록
    void insertUser(User user);

    // 사용자 상세
    User userDetail(String email);

    // 사용자 수정
    void updateUser(User user);

    // 사용자 삭제
    void deleteUser(int userSeq);

    // 이메일 중복 체크
    int checkEmail(String email);

    // 닉네임 중복 체크
    int checkNickname(String nickname);

    // 비밀번호 일치 검사
    int checkPassword(HashMap<String, String> params);

    // 비밀번호 찾기 답변 일치 검사
    int checkFindpw(HashMap<String, String> params);

    // 비밀번호 수정
    void updatePassword(HashMap<String, String> params);

    // 비밀번호 찾기 답변 수정
    void updateFindpw(HashMap<String, String> params);

}
