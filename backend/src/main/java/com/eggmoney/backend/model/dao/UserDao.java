package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.User;

public interface UserDao {
    // 사용자 등록
    void insertUser(User user);

    // 사용자 상세
    User userDetail(int userSeq);

    // 사용자 수정
    void updateUser(User user);

    // 사용자 삭제
    void deleteUser(int userSeq);

    // 이메일 중복 체크
    int checkEmail(String email);

    // 닉네임 중복 체크
    int checkNickname(String nickname);

}
