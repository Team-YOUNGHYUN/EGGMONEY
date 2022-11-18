package com.eggmoney.backend.model.dao;

import com.eggmoney.backend.model.dto.Comment;

import java.util.HashMap;

public interface CommentDao {
    // 코멘트 등록
    void insertComment(Comment comment);

    // 코멘트 상세
    Comment commentDetail(HashMap<String, String> params);

    // 코멘트 수정
    void updateComment(Comment comment);
}
