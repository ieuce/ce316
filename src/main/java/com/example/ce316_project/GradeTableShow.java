package com.example.ce316_project;

import javafx.scene.image.ImageView;

public class GradeTableShow {

    private String id;
    private String name;
    private int grade;
    private ImageView image;

    public GradeTableShow(String id, String name, int grade, ImageView image) {
        this.id = id;
        this.name = name;
        this.grade = grade;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return this.id;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public int getGrade() {
        return this.grade;
    }

}
