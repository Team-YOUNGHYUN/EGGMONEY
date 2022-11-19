package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dto.Quest;

public interface QuestService {
    // 퀘스트 등록(회원가입 시)
    void addQuest(int userSeq);

    // 퀘스트 상세
    Quest selectQuest(int userSeq);

    // 퀘스트 수정
    void modifyQuest(Quest quest);

    // 퀘스트 삭제 (탈퇴 시)
    void removeQuest(int userSeq);
}
