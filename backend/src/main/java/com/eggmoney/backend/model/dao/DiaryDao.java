package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Diary;
import com.eggmoney.backend.model.dto.User;

import java.util.List;

public interface DiaryDao {
    // 다이어리 상세(날짜별)
    List<Diary> selectDiaryList(User user, String regDate);

    // 운동 목록에 운동 추가
    void insertDiary(Diary diary);

    // 운동 목록에서 운동 삭제
    void deleteDiary(int id);
}
