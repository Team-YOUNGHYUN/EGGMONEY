package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.DiaryDao;
import com.eggmoney.backend.model.dto.Diary;
import com.eggmoney.backend.model.dto.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class RecordServiceImpl implements RecordService {

    @Autowired
    private DiaryDao diaryDao;

    @Override
    public Diary selectDiary(HashMap<Integer, String> params) {
        return diaryDao.selectDiary(params);
    }

    @Override
    public void addRecord(Record record) {
        diaryDao.insertRecord(record);
    }

    @Override
    public void removeRecord(int id) {
        diaryDao.deleteRecord(id);
    }

    @Override
    public void modifyComment(HashMap<Integer, String> params) {
        diaryDao.updateComment(params);
    }
}
