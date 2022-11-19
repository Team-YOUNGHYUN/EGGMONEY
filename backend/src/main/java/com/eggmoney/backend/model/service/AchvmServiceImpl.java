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
        List<Achvm> achvmList = achvmDao.selectAchvm(userSeq);
        List<Integer> achvmIdList = achvmDao.selectAchvmId(userSeq);
        List<Achvm> list = new ArrayList<>();
        for(int id : achvmIdList){
            list.add(achvmList.get(id-1));
        }
        return list;
    }

    // 사용자가 달성하지 못한 업적 리스트 조회
    @Override
    public List<Achvm> selectFalseAchvm(int userSeq) {
        List<Achvm> achvmList = achvmDao.selectAchvm(userSeq);
        List<Integer> achvmIdList = achvmDao.selectAchvmId(userSeq);
        Collections.sort(achvmIdList);
        int size = achvmIdList.size();
        for(int idx = size-1; idx>=0; idx--){
            achvmList.remove(achvmIdList.get(idx)-1);
        }
        return achvmList;
    }

    // 사용자가 달성한 업적의 id 등록
    @Override
    public void addAchvmId(HashMap<String, Integer> params) {
        achvmDao.insertAchvmId(params);
    }
}
