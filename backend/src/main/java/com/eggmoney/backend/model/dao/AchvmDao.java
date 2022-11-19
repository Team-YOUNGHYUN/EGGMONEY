package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Achvm;

import java.util.HashMap;
import java.util.List;

public interface AchvmDao {
    // 사용자가 달성한 업적 리스트 조회
    List<Achvm> selectTrueAchvm(int userSeq);

    // 사용자가 달성하지 못한 업적 리스트 조회
    List<Achvm> selectFalseAchvm(int userSeq);

    // 사용자가 달성한 업적의 id 등록
    void insertAchvmId(HashMap<String, Integer> params);

    // 사용자의 업적 획득 정보 삭제 (탈퇴 시)
    void deleteAchvmId(int userSeq);
}
