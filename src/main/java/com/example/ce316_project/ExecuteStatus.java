package com.example.ce316_project;

class ExecuteStatus{
    private int id;
    private String name;
    private String output;
    private boolean success;
    
    ExecuteStatus(int id, String name, String output, boolean success){
        this.id = id;
        this.name = name;
        this.output = output;
        this.success = success;
    }

    public int getId(){
        return this.id;
    }

    public String getName(){
        return this.name;
    }

    public String getOutput(){
        return this.output;
    }

    public boolean getSuccess(){
        return this.success;
    }
}