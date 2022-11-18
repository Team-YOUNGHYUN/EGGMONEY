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
    public List<Record> selectRecord(HashMap<String, String> params) {
        return recordDao.selectRecord(params);
    }

    @Override
    public void addRecord(Record record) {
        recordDao.insertRecord(record);
    }

    @Override
    public void removeRecord(int id) {
        recordDao.deleteRecord(id);
    }

}
