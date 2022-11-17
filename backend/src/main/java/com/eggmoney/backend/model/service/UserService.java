package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dto.User;

public interface UserService {
    // 사용자 등록
    void registUser(User user);

    // 사용자 상세
    User userDetail(String id);

    // 사용자 수정
    void modifyUser(User user);

    // 사용자 삭제
    void deleteUser(String id);

}
