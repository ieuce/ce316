package com.example.ce316_project;

import java.io.File;
import java.sql.*;

public class DBConnector {
    private static DBConnector instance = null;

    private final String fileName;
    private Connection connection;

    private PreparedStatement insertLecture, insertProgrammingLanguage, insertProject,
            getLectur, getProgrammingLanguge, getProject,
            deleteLectur, deleteLanguge, deleteProject;


    DBConnector() {
        this.fileName = "info.db";
        File file = new File(fileName);
        boolean firstRun = !file.exists();

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:" + fileName);

            if (firstRun) {
                Statement stmt = connection.createStatement();

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Lecture (" +
                        "LECTURE_ID INTEGER PRIMARY KEY," +
                        "LECTURE_NAME TEXT," +
                        "LECTURER TEXT)");

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS ProgrammingLanguage (" +
                        "PLANGUAGE_ID INTEGER PRIMARY KEY," +
                        "PLANGUAGE_NAME TEXT," +
                        "PLANGUAGE_VERSIONSTRING TEXT," +
                        "PLANGUAGE_NEEDCOMPILER INTEGER," +
                        "PLANGUAGE_COMPILEINSSTRING INTEGER," +
                        "PLANGUAGE_RUNINSSTRING TEXT," +
                        "PLANGUAGE_VERSIONCHECKCOMMAND TEXT," +
                        "PLANGUAGE_VERSIONEXTRACTPATTERN TEXT)");

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Project (" +
                        "PROJECT_ID INTEGER PRIMARY KEY," +
                        "PROJECT_TITLE TEXT," +
                        "PROJECT_DESCRIPTION TEXT," +
                        "PROJECT_LECTURE_ID INTEGER," +
                        "PROJECT_PROGRAMMING_LANGUAGE_ID INTEGER," +
                        "PROJECT_MAIN_FILE_FORMAT TEXT)");

                System.out.println("Tables have Created!!");

                insertLecture = connection
                        .prepareStatement("INSERT INTO Lecture (LECTURE_ID, LECTURE_NAME, LECTURER) VALUES (?,?,?)");
                insertProgrammingLanguage = connection
                        .prepareStatement("INSERT INTO ProgrammingLanguage (PLANGUAGE_ID, PLANGUAGE_NAME, PLANGUAGE_VERSIONSTRING, PLANGUAGE_NEEDCOMPILER, PLANGUAGE_COMPILEINSSTRING, PLANGUAGE_RUNINSSTRING, PLANGUAGE_VERSIONCHECKCOMMAND, PLANGUAGE_VERSIONEXTRACTPATTERN) VALUES (?,?,?,?,?,?,?,?)");
                insertProject = connection
                        .prepareStatement("INSERT INTO Project (PROJECT_ID, PROJECT_TITLE, PROJECT_DESCRIPTION,PROJECT_LECTURE_ID,PROJECT_PROGRAMMING_LANGUAGE_ID,PROJECT_MAIN_FILE_FORMAT) VALUES (?,?,?,?,?,?)");


            }

        } catch (ClassNotFoundException | SQLException e) {
            System.err.println(e);
        }
    }

    public static DBConnector getInstance() {

        if (instance == null) {
            instance = new DBConnector();
        }

        return instance;
    }

    public void addLecture(LectureConfig lecture) {
        try {
            int lecture_id = lecture.getLecture_id();
            String lecture_name = lecture.getLecture_Name();
            String lecturer_name = lecture.getLecturer_Name();

            insertLecture.setInt(1, lecture_id);
            insertLecture.setString(2, lecture_name);
            insertLecture.setString(3, lecturer_name);
            insertLecture.execute();

        } catch (Exception e) {
            System.err.println(e);
        }
    }
    public void addPL(PLConfig language) {
        try {
            int id = language.getId();
            String name = language.getName();
            String versionString = language.getVersionString();
            boolean need_compiler = language.isNeed_compiler();
            String compileInsString = language.getCompileInsString();
            String runInsString = language.getRunInsString();
            String versionCheckCommand = language.getVersionCheckCommand();
            String versionExtractPattern = language.getVersionExtractPattern().pattern();
            int need_compilerint;
            if (need_compiler == true) {
                need_compilerint = 1;
            } else {
                need_compilerint = 0;
            }
            insertProgrammingLanguage.setInt(1, id);
            insertProgrammingLanguage.setString(2, name);
            insertProgrammingLanguage.setString(3, versionString);
            insertProgrammingLanguage.setInt(4, need_compilerint);
            insertProgrammingLanguage.setString(5, compileInsString);
            insertProgrammingLanguage.setString(6, runInsString);
            insertProgrammingLanguage.setString(7, versionCheckCommand);
            insertProgrammingLanguage.setString(8, versionExtractPattern);
            insertLecture.execute();

        } catch (Exception e) {
            System.out.println(e);

        }
    }
}