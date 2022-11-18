package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dto.Record;

import java.util.HashMap;
import java.util.List;

public interface RecordService {
    // 운동 목록 반환
    List<Record> selectRecord(HashMap<String, String> params);

    // 운동기록 추가
    void addRecord(Record record);

    // 운동 목록에서 운동 삭제
    // id는 record Id
    void removeRecord(int id);

}
