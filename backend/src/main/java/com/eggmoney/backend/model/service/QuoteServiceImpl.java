package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.QuoteDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteServiceImpl implements QuoteService {

    @Autowired
    private QuoteDao quoteDao;

    @Override
    public String selectQuote(int id) {
        return quoteDao.selectQuote(id);
    }
}
