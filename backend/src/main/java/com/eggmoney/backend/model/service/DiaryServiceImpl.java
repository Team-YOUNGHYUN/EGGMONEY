package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.DiaryDao;
import com.eggmoney.backend.model.dto.Comment;
import com.eggmoney.backend.model.dto.Diary;
import com.eggmoney.backend.model.dto.Record;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiaryServiceImpl implements DiaryService {

    @Autowired
    private DiaryDao diaryDao;

    @Override
    public Diary selectDiary(int userSeq, String regDate) {
        return diaryDao.selectDiary(userSeq, regDate);
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
    public void modifyComment(Comment comment) {
        diaryDao.updateComment(comment);
    }
}
