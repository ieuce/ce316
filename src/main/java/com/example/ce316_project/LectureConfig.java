package com.example.ce316_project;

public class LectureConfig {
    private int lecture_id;
    private String lecture_Name;
    private String lecturer_Name;


    public LectureConfig(int lecture_id, String lecture_Name, String lecturer_Name) {
        this.lecture_id = lecture_id;
        this.lecture_Name = lecture_Name;
        this.lecturer_Name = lecturer_Name;

    }


    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public String getLecture_Name() {
        return lecture_Name;
    }

    public void setLecture_Name(String lecture_Name) {
        this.lecture_Name = lecture_Name;
    }

    public String getLecturer_Name() {
        return lecturer_Name;
    }

    public void setLecturer_Name(String lecturer_Name) {
        this.lecturer_Name = lecturer_Name;
    }
}
