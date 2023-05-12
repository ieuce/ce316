package com.example.ce316_project;

import javafx.scene.image.ImageView;

import java.util.ArrayList;

public class ProjectConfig {

    private int id;
    private String title;
    private String description;
    private int lecture_id;
    private int programming_language_id;
    private String main_file_format;
    private ImageView image;

    public ProjectConfig(int id, String title, String description, int lecture_id, int programming_language_id, String main_file_format, ImageView image) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lecture_id = lecture_id;
        this.programming_language_id = programming_language_id;
        this.main_file_format = main_file_format;
        this.image = image;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public int getProgramming_language_id() {
        return programming_language_id;
    }

    public void setProgramming_language_id(int programming_language_id) {
        this.programming_language_id = programming_language_id;
    }

    public String getMain_file_format() {
        return main_file_format;
    }

    public void setMain_file_format(String main_file_format) {
        this.main_file_format = main_file_format;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }
}