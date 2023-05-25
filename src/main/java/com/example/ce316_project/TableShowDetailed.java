package com.example.ce316_project;

import javafx.scene.image.ImageView;

public class TableShowDetailed {

    private int id;
    private int project_id;
    private String RunOutput;
    private String student_id;
    private ImageView image;

    public TableShowDetailed(int id, int project_id, String runOutput, String student_id, ImageView image ){
        this.id=id;
        this.project_id =project_id;
        this.RunOutput=runOutput;
        this.student_id =student_id;
        this.image=image;
    }

    public int getId() {
        return id;
    }

    public int getProject_Id() {
        return project_id;
    }

    public String getRunOutput() {
        return RunOutput;
    }

    public String getStudent_Id() {
        return student_id;
    }

    public ImageView getImage(){
        return image;}



}
