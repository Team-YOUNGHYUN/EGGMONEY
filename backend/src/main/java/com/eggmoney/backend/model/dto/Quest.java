package com.eggmoney.backend.model.dto;

public class Quest {
    private int id;
    private String dueDate;
    private int type;
    private int goal;
    private int modifyCnt;
    private int userSeq;

    public Quest(int id, String dueDate, int type, int goal, int modifyCnt, int userSeq) {
        this.id = id;
        this.dueDate = dueDate;
        this.type = type;
        this.goal = goal;
        this.modifyCnt = modifyCnt;
        this.userSeq = userSeq;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getGoal() {
        return goal;
    }

    public void setGoal(int goal) {
        this.goal = goal;
    }

    public int getModifyCnt() {
        return modifyCnt;
    }

    public void setModifyCnt(int modifyCnt) {
        this.modifyCnt = modifyCnt;
    }

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    @Override
    public String toString() {
        return "Quest{" +
                "id=" + id +
                ", dueDate='" + dueDate + '\'' +
                ", type=" + type +
                ", goal=" + goal +
                ", modifyCnt=" + modifyCnt +
                ", userSeq=" + userSeq +
                '}';
    }
}
