package com.example.ce316_project;

import java.io.File;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Main2 {
    public static void main(String[] args){
        DBConnector db = DBConnector.getInstance();

        /*LectureConfig ce316 = new LectureConfig(316,"CE316","İlker Korkmaz");
        db.addLecture(ce316);*/

        /*PLConfig config = null;
        // JAVA
        try {
            config = new PLConfig(0, "Java18", "18.0.2.1", true, "javac <PARENT_DIRECTORY>/<FILENAME>.java", "java -classpath <PARENT_DIRECTORY> <FILENAME> <ARGS>", "java --version", Pattern.compile("java (\\d+\\.\\d+\\.\\d+\\.\\d+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }
        db.addPL(config);

        // PYTHON
        try {
            config = new PLConfig(1, "Python38", "3.8.5", false, null, "python <PARENT_DIRECTORY>/<FILENAME>.py <ARGS>", "python --version", Pattern.compile("Python (\\d+\\.\\d+\\.\\d+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }
        db.addPL(config);*/

        /*PLConfig config = db.getPLConfigObject(0);
        ExecuteStatus output = null;
        if(config != null){
            output = config.executeProgram(new File("sample_files/example.java"), "1 2 3");
            System.out.println("Success: " + output.getSuccess());
            System.out.println("Output: " + output.getOutput());
        }*/

        /*PLConfig config = db.getPLConfigObject(1);
        ExecuteStatus output = null;
        if(config != null){
            output = config.executeProgram(new File("sample_files/example.py"), "1 2 3");
            System.out.println("Success: " + output.getSuccess());
            System.out.println("Output: " + output.getOutput());
        }*/

        // ArrayList<PLConfig> configs = db.getAllPLConfigObjects();

        PLConfig config = null;

        try {
            config = new PLConfig(0, "Python310", "3.10.11", false, null, "python <PARENT_DIRECTORY>/<FILENAME>.py <ARGS>", "python --version", Pattern.compile("Python (\\d+\\.\\d+\\.\\d+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }
        db.addPL(config);

        config = db.getPLConfigObject(0);
        ExecuteStatus output = null;
        /*if(config != null){
            output = config.executeProgram(new File("sample_files/example.py"), "1 2 3");
            System.out.println("Success: " + output.getSuccess());
            System.out.println("Output: " + output.getOutput());
        }*/

        ArrayList<PLConfig> configs = db.getAllPLConfigObjects();
    }
}
