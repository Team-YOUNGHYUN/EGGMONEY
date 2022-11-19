package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.QuestDao;
import com.eggmoney.backend.model.dto.Quest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestServiceImpl implements QuestService{

    @Autowired
    private QuestDao questDao;

    @Override
    public void addQuest(int userSeq) {
        questDao.insertQuest(userSeq);
    }

    @Override
    public Quest selectQuest(int userSeq) {
        return questDao.selectQuest(userSeq);
    }

    @Override
    public void modifyQuest(Quest quest) {
        questDao.updateQuest(quest);
    }

    @Override
    public void removeQuest(int userSeq) {
        questDao.deleteQuest(userSeq);
    }
}
