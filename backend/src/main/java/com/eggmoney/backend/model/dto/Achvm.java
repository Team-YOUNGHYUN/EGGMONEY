package com.eggmoney.backend.model.dto;

public class Achvm {
    private int id;
    private String title;
    private String content;
    private String imgSrc;
    private int reward;
    private int hidden;

    public Achvm(int id, String title, String content, String imgSrc, int reward, int hidden) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.imgSrc = imgSrc;
        this.reward = reward;
        this.hidden = hidden;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgSrc() {
        return imgSrc;
    }

    public void setImgSrc(String imgSrc) {
        this.imgSrc = imgSrc;
    }

    public int getReward() {
        return reward;
    }

    public void setReward(int reward) {
        this.reward = reward;
    }

    public int getHidden() {
        return hidden;
    }

    public void setHidden(int hidden) {
        this.hidden = hidden;
    }

    @Override
    public String toString() {
        return "Achvm{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", imgSrc='" + imgSrc + '\'' +
                ", reward=" + reward +
                ", hidden=" + hidden +
                '}';
    }
}
