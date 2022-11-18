package com.eggmoney.backend.model.service;

import com.eggmoney.backend.model.dto.Comment;

import java.util.HashMap;

public interface CommentService {
    // 코멘트 등록
    void registComment(Comment comment);

    // 코멘트 상세
    Comment commentDetail(HashMap<String, String> params);

    // 코멘트 수정
    void modifyComment(Comment comment);
}
