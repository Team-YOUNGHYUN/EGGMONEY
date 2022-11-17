package com.eggmoney.backend.model.dto;

public class Record {
    private String regDate;
    private String exercisePart;
    private String exerciseName;
    private int setCnt;
    private int timeCnt;

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
