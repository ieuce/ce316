package com.example.ce316_project;

public class Evolution {
    private int id;
    private int project_id;

    private String pinput;
    private String poutput;

    public Evolution(int id, int project_id, String pinput, String poutput) {
        this.id = id;
        this.project_id = project_id;
        this.pinput = pinput;
        this.poutput = poutput;
    }

    public int getId() {
        return id;
    }

    public int getProject_id() {
        return project_id;
    }

    public String getPinput() {
        return pinput;
    }

    public String getPoutput() {
        return poutput;
    }
}
