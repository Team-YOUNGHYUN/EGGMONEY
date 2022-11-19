package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Quest;

public interface QuestDao {
    // 퀘스트 등록(회원가입 시)
    void insertQuest(int userSeq);

    // 퀘스트 상세
    Quest selectQuest(int userSeq);

    // 퀘스트 수정
    void updateQuest(Quest quest);

    // 퀘스트 삭제 (탈퇴 시)
    void deleteQuest(int userSeq);

}
