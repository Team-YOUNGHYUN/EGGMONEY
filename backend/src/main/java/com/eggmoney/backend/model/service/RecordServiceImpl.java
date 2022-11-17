package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.RecordDao;
import com.eggmoney.backend.model.dto.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private RecordDao recordDao;


    @Override
    public List<Record> selectRecordList(HashMap<String, String> params) {
        return recordDao.selectRecordList(params);
    }

    @Override
    public String selectComment(HashMap<String, String> params) {
        return recordDao.selectComment(params);
    }

    @Override
    public void addDiary(Record record) {
        recordDao.insertDiary(record);
    }

    @Override
    public void removeDiary(int id) {
        recordDao.deleteDiary(id);
    }
}
