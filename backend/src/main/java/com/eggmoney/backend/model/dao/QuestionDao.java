package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Question;

import java.util.HashMap;
import java.util.List;

public interface QuestionDao {
    // 질문 목록 반환
    List<Question> selectList();

    // 사용자가 선택한 질문 반환
    Question selectQuestion(int userSeq);
}
