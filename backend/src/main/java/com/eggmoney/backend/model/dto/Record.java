package com.eggmoney.backend.model.dto;

public class Record {
    private int id;
    private int userSeq;
    private String regDate;
    private String exercisePart;
    private String exerciseName;
    private int setCnt;
    private int timeCnt;

    public Record() {
    }

    public Record(int id, int userSeq, String regDate, String exercisePart, String exerciseName, int setCnt, int timeCnt) {
        this.id = id;
        this.userSeq = userSeq;
        this.regDate = regDate;
        this.exercisePart = exercisePart;
        this.exerciseName = exerciseName;
        this.setCnt = setCnt;
        this.timeCnt = timeCnt;
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

    public String getExercisePart() {
        return exercisePart;
    }

    public void setExercisePart(String exercisePart) {
        this.exercisePart = exercisePart;
    }

    public String getExerciseName() {
        return exerciseName;
    }

    public void setExerciseName(String exerciseName) {
        this.exerciseName = exerciseName;
    }

    public int getSetCnt() {
        return setCnt;
    }

    public void setSetCnt(int setCnt) {
        this.setCnt = setCnt;
    }

    public int getTimeCnt() {
        return timeCnt;
    }

    public void setTimeCnt(int timeCnt) {
        this.timeCnt = timeCnt;
    }

}
