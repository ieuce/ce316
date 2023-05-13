package com.example.ce316_project;

import javafx.scene.image.ImageView;

public class TableShow {

    private int id;
    private String name;
    private ImageView image;
    private ImageView image2;

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

    public ImageView getImage2() {
        return image2;
    }

    public void setImage2(ImageView image2) {
        this.image2 = image2;
    }

    public TableShow(int id, String name, ImageView image, ImageView image2) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.image2 = image2;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return this.id;
    }

}
