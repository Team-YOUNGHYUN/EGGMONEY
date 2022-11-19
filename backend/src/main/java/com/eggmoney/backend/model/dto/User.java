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
    private int point;
    private int rprsnAchvmId;

    public User(int userSeq, String email, String password, String name, String nickname, int pwFindQuestionId, String pwFindAnswer, String gender, int height, double weight, double bodyFat, double muscleMass, int point, int rprsnAchvmId) {
        this.userSeq = userSeq;
        this.email = email;
        this.password = password;
        this.name = name;
        this.nickname = nickname;
        this.pwFindQuestionId = pwFindQuestionId;
        this.pwFindAnswer = pwFindAnswer;
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.bodyFat = bodyFat;
        this.muscleMass = muscleMass;
        this.point = point;
        this.rprsnAchvmId = rprsnAchvmId;
    }

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

    public void setPwFindQuestionId(int pwFindQuestionId) {
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

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getRprsnAchvmId() {
        return rprsnAchvmId;
    }

    public void setRprsnAchvmId(int rprsnAchvmId) {
        this.rprsnAchvmId = rprsnAchvmId;
    }

    @Override
    public String toString() {
        return "User{" +
                "userSeq=" + userSeq +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", pwFindQuestionId=" + pwFindQuestionId +
                ", pwFindAnswer='" + pwFindAnswer + '\'' +
                ", gender='" + gender + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", bodyFat=" + bodyFat +
                ", muscleMass=" + muscleMass +
                ", point=" + point +
                ", rprsnAchvmId=" + rprsnAchvmId +
                '}';
    }
}
