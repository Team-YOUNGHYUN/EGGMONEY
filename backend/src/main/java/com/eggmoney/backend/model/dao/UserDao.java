package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.User;

public interface UserDao {
    // 사용자 등록
    void insertUser(User user);

    // 사용자 상세
    User userDetail(String email);

    // 사용자 수정
    void updateUser(User user);

    // 사용자 삭제
    void deleteUser(String email);

}
