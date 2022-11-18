package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dao.CommentDao;
import com.eggmoney.backend.model.dto.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class CommentServiceImpl implements CommentService{

    @Autowired
    private CommentDao commentDao;

    // 코멘트 등록
    @Override
    public void registComment(Comment comment) {
        commentDao.insertComment(comment);
    }

    // 코멘트 상세
    @Override
    public Comment commentDetail(HashMap<String, String> params) {
        return commentDao.commentDetail(params);
    }

    // 코멘트 수정
    @Override
    public void modifyComment(Comment comment) {
        commentDao.updateComment(comment);
    }
}
