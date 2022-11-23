package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.UserDao;
import com.eggmoney.backend.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

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
    public User userDetail(String email) {
        User user = userDao.userDetail(email);
        user.setPassword("");
        user.setPwFindAnswer("");
        return user;
    }

    // 사용자 수정
    @Override
    public void modifyUser(User user) {
        userDao.updateUser(user);
    }

    // 사용자 삭제
    @Override
    public void removeUser(int userSeq) {
        userDao.deleteUser(userSeq);
    }

    @Override
    public int checkEmail(String email) {
        return userDao.checkEmail(email);
    }

    @Override
    public int checkNickName(String nickname) {
        return userDao.checkNickname(nickname);
    }

    @Override
    public int checkPassword(HashMap<String, String> params) {
        return userDao.checkPassword(params);
    }

    @Override
    public int checkFindpw(HashMap<String, String> params) {
        return userDao.checkFindpw(params);
    }

    @Override
    public void updatePassword(HashMap<String, String> params){
        userDao.updatePassword(params);
    }

    @Override
    public void updateFindpw(HashMap<String, String> params) {
        userDao.updateFindpw(params);
    }

}
