package com.eggmoney.backend.model.dto;

public class Exercise {
    private int id;
    private String name;
    private String Part;

    public Exercise(int id, String name, String part) {
        this.id = id;
        this.name = name;
        Part = part;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPart() {
        return Part;
    }

    public void setPart(String part) {
        Part = part;
    }

    @Override
    public String toString() {
        return "Exercise{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", Part='" + Part + '\'' +
                '}';
    }
}
