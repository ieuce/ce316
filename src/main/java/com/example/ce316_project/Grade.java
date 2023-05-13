package com.example.ce316_project;

public class Grade {
    private int id;
    private int project_id;
    private int student_id;
    private int grade;

    public Grade(int id, int project_id, int student_id, int grade) {
        this.id = id;
        this.project_id = project_id;
        this.student_id = student_id;
        this.grade = grade;
    }

    public int getId() {
        return id;
    }

    public int getProject_id() {
        return project_id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getGrade() {
        return grade;
    }
}
