package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Comment;
import com.eggmoney.backend.model.dto.Record;
import com.eggmoney.backend.model.dto.Diary;

public interface DiaryDao {
    // 다이어리 상세
    Diary selectDiary(int userSeq, String regDate);

    // 운동 목록에 운동 추가
    void insertRecord(Record record);

    // 운동 목록에서 운동 삭제
    void deleteRecord(int id);

    // 코멘트 수정
    void updateComment(Comment comment);
}
