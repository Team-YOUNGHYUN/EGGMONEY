package com.eggmoney.backend.model.dto;

import java.util.List;

public class Diary {
    private List<Record> recordList;
    private String comment;

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
