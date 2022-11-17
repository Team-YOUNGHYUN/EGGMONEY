package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.UserDao;
import com.eggmoney.backend.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    // 사용자 등록
    @Override
    public void registUser(User user) {
        userDao.insertUser(user);
    }

    // 사용자 상세
    @Override
    public User userDetail(String id) {
        return userDao.userDetail(id);
    }

    // 사용자 수정
    @Override
    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    // 사용자 삭제
    @Override
    public void deleteUser(String id) {
        userDao.deleteUser(id);
    }
}
