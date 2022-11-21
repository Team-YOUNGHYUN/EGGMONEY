package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Record;

import java.util.HashMap;
import java.util.List;

public interface RecordDao {
    // 운동 기록 목록 반환
    List<Record> selectRecord(HashMap<String, String> params);

    // 운동 기록 추가
    void insertRecord(Record record);

    // 운동 기록 삭제
    void deleteRecord(int id);

}
