package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dto.Record;

import java.util.HashMap;
import java.util.List;

public interface RecordService {
    // 날짜별 기록 목록 (이메일, 날짜)
    List<Record> selectRecordList(HashMap<String, String> params);

    // 날짜별 코멘트 (이메일, 날짜)
    String selectComment(HashMap<String, String> params);

    // 운동 목록에 운동 추가
    void addDiary(Record record);

    // 운동 목록에서 운동 삭제
    void removeDiary(int id);
}
