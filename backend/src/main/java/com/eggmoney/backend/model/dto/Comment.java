package com.eggmoney.backend.model.dto;

public class Comment {
    private int id;
    private int userSeq;
    private String regDate;
    private String content;

    public Comment(int id, int userSeq, String regDate, String content) {
        this.id = id;
        this.userSeq = userSeq;
        this.regDate = regDate;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
