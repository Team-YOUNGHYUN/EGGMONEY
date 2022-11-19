package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.AchvmDao;
import com.eggmoney.backend.model.dto.Achvm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AchvmServiceImpl implements AchvmService{

    @Autowired
    private AchvmDao achvmDao;

    // 사용자가 달성한 업적 리스트 조회
    @Override
    public List<Achvm> selectTrueAchvm(int userSeq) {
        return achvmDao.selectTrueAchvm(userSeq);
    }

    // 사용자가 달성하지 못한 업적 리스트 조회
    @Override
    public List<Achvm> selectFalseAchvm(int userSeq) {
        return achvmDao.selectFalseAchvm(userSeq);
    }

    // 사용자가 달성한 업적의 id 등록
    @Override
    public void addAchvmId(HashMap<String, Integer> params) {
        achvmDao.insertAchvmId(params);
    }

    @Override
    public void removeAchvmId(int userSeq) {
        achvmDao.deleteAchvmId(userSeq);
    }


}
