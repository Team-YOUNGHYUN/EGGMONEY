package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.QuestionDao;
import com.eggmoney.backend.model.dto.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    private QuestionDao questionDao;


    @Override
    public List<Question> selectList() {
        return questionDao.selectList();
    }

    @Override
    public Question selectQuestion(int userSeq) {
        return questionDao.selectQuestion(userSeq);
    }
}
