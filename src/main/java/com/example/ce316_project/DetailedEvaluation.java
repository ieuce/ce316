package com.example.ce316_project;

public class DetailedEvaluation {


    private int evaluation_id;

    private String student_id;

    private int success_code;

    private String output;


    public DetailedEvaluation(int evaluation_id, String student_id, int success_code, String output) {
        this.evaluation_id = evaluation_id;
        this.student_id = student_id;
        this.success_code = success_code;
        this.output = output;
    }

    public int getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(int evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public String getStudent_id() {
        return student_id;
    }

    public void setStudent_id(String student_id) {
        this.student_id = student_id;
    }

    public int getSuccess_code() {
        return success_code;
    }

    public void setSuccess_code(int success_code) {
        this.success_code = success_code;
    }

    public String getOutput() {
        return output;
    }

    public void setOutput(String output) {
        this.output = output;
    }


}
