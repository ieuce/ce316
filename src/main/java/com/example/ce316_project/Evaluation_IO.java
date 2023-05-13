package com.example.ce316_project;

public class Evaluation_IO {

    private int id;

    private int project_id;

    private String input;

    private String output;

    public Evaluation_IO(int id, int project_id, String input, String output) {
        this.id = id;
        this.project_id = project_id;
        this.input = input;
        this.output = output;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getProject_id() {
        return project_id;
    }

    public void setProject_id(int project_id) {
        this.project_id = project_id;
    }

    public String getInput() {
        return input;
    }

    public void setInput(String input) {
        this.input = input;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }


}
