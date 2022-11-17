package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dto.Comment;
import com.eggmoney.backend.model.dto.Diary;
import com.eggmoney.backend.model.dto.Record;

public interface DiaryService {
    // 다이어리 상세 (userSeq, regDate)
    Diary selectDiary(int userSeq, String regDate);

    // 운동 목록에 운동 추가
    void addRecord(Record record);

    // 운동 목록에서 운동 삭제
    void removeRecord(int id);

    // 코멘트 수정
    void modifyComment(Comment comment);

}
