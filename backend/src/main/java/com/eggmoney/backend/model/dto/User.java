package com.eggmoney.backend.model.dto;

public class User {
    private int userSeq;
    private String email;
    private String password;
    private String name;
    private String nickname;
    private int pwFindQuestionId;
    private String pwFindAnswer;
    private String gender;
    private int height;
    private double weight;
    private double bodyFat;
    private double muscleMass;
    private int money;
    private String questDueDate;
    private String questType;
    private String questModifyCnt;

    public int getUserSeq() {
        return userSeq;
    }

    public void setUserSeq(int userSeq) {
        this.userSeq = userSeq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPwFindQuestionId() {
        return pwFindQuestionId;
    }

    public void setPwFindQuestionId(String pwFindQuestion) {
        this.pwFindQuestionId = pwFindQuestionId;
    }

    public String getPwFindAnswer() {
        return pwFindAnswer;
    }

    public void setPwFindAnswer(String pwFindAnswer) {
        this.pwFindAnswer = pwFindAnswer;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getBodyFat() {
        return bodyFat;
    }

    public void setBodyFat(double bodyFat) {
        this.bodyFat = bodyFat;
    }

    public double getMuscleMass() {
        return muscleMass;
    }

    public void setMuscleMass(double muscleMass) {
        this.muscleMass = muscleMass;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getQuestDueDate() {
        return questDueDate;
    }

    public void setQuestDueDate(String questDueDate) {
        this.questDueDate = questDueDate;
    }

    public String getQuestType() {
        return questType;
    }

    public void setQuestType(String questType) {
        this.questType = questType;
    }

    public String getQuestModifyCnt() {
        return questModifyCnt;
    }

    public void setQuestModifyCnt(String questModifyCnt) {
        this.questModifyCnt = questModifyCnt;
    }
}
