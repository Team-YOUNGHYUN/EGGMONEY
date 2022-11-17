package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.DiaryDao;
import com.eggmoney.backend.model.dto.Diary;
import com.eggmoney.backend.model.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiaryServiceImpl implements DiaryService{

    @Autowired
    private DiaryDao diaryDao;

    @Override
    public List<Diary> selectDiaryList(User user, String regDate) {
        return diaryDao.selectDiaryList(user, regDate);
    }

    @Override
    public void addDiary(Diary diary) {
        diaryDao.insertDiary(diary);
    }

    @Override
    public void removeDiary(int id) {
        diaryDao.deleteDiary(id);
    }
}
