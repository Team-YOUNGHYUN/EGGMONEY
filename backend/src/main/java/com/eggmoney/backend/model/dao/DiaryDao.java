package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Record;
import com.eggmoney.backend.model.dto.Diary;


import java.util.HashMap;
import java.util.List;

public interface DiaryDao {
    // 다이어리 상세 (userSeq, regDate)
    Diary selectDiary(HashMap<Integer, String> params);

    // 운동 목록에 운동 추가
    void insertRecord(Record record);

    // 운동 목록에서 운동 삭제
    void deleteRecord(int id);

    // 코멘트 수정
    void updateComment(HashMap<Integer, String> params);
}
