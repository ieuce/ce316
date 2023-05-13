package com.example.ce316_project;

public class GradesTable {

    private int id;
    private int project_id;
    private int student_id;
    private int grade;

    public GradesTable(int id, int project_id, int student_id, int grade) {
        this.id = id;
        this.project_id = project_id;
        this.student_id = student_id;
        this.grade = grade;
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

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }



}
