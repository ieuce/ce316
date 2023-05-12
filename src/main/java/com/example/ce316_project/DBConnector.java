package com.example.ce316_project;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class DBConnector {
    private static DBConnector instance = null;

    private final String fileName;
    private Connection connection;

    private PreparedStatement insertLecture, insertProgrammingLanguage, insertProject,
            getPLConfig, getAllPLConfigIds,
            getLectureConfig, getProjectConfig, getAllLectureConfigs, getAllProjectConfigs,
            deleteLecture, deleteLanguge, deleteProject;


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
            }

            insertLecture = connection
                    .prepareStatement("INSERT INTO Lecture (LECTURE_ID, LECTURE_NAME, LECTURER) VALUES (?,?,?)");
            insertProgrammingLanguage = connection
                    .prepareStatement("INSERT INTO ProgrammingLanguage (PLANGUAGE_ID, PLANGUAGE_NAME, PLANGUAGE_VERSIONSTRING, PLANGUAGE_NEEDCOMPILER, PLANGUAGE_COMPILEINSSTRING, PLANGUAGE_RUNINSSTRING, PLANGUAGE_VERSIONCHECKCOMMAND, PLANGUAGE_VERSIONEXTRACTPATTERN) VALUES (?,?,?,?,?,?,?,?)");
            insertProject = connection
                    .prepareStatement("INSERT INTO Project (PROJECT_ID, PROJECT_TITLE, PROJECT_DESCRIPTION,PROJECT_LECTURE_ID,PROJECT_PROGRAMMING_LANGUAGE_ID,PROJECT_MAIN_FILE_FORMAT) VALUES (?,?,?,?,?,?)");

            getPLConfig = connection
                    .prepareStatement("SELECT * FROM ProgrammingLanguage WHERE PLANGUAGE_ID = ?");

            getProjectConfig = connection.prepareStatement("SELECT * FROM Project WHERE PROJECT_ID = ?");

            getLectureConfig = connection.prepareStatement("SELECT * FROM Lecture WHERE LECTURE_ID = ?");

            getAllPLConfigIds = connection
                    .prepareStatement("SELECT PLANGUAGE_ID FROM ProgrammingLanguage");

            getAllLectureConfigs = connection.prepareStatement("SELECT LECTURE_ID FROM Lecture");

            getAllProjectConfigs = connection.prepareStatement("SELECT PROJECT_ID FROM Project");

            deleteLecture = connection.prepareStatement("DELETE FROM Lecture WHERE LECTURE_ID = ?");
            deleteLanguge = connection.prepareStatement("DELETE FROM ProgrammingLanguage WHERE PLANGUAGE_ID = ?");
            deleteProject = connection.prepareStatement("DELETE FROM Project WHERE PROJECT_ID = ?");



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

    public void addProject(ProjectConfig project){
        try {
            int project_id = project.getId();
            String title = project.getTitle();
            String description = project.getDescription();
            int lecture_id = project.getId();
            int programming_language_id  = project.getProgramming_language_id();
            String project_main_file_format = project.getMain_file_format();

            insertProject.setInt(1, project_id);
            insertProject.setString(2, title);
            insertProject.setString(3, description);
            insertProject.setInt(4, lecture_id);
            insertProject.setInt(5, programming_language_id);
            insertProject.setString(6, project_main_file_format);
            insertProject.execute();

        }catch (Exception e){
            System.out.println(e);

        }
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
            insertProgrammingLanguage.execute();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    public ProjectConfig getProjectConfigObject(int id) {
        try {
            getProjectConfig.setInt(1, id);
            getPLConfig.execute();
            ResultSet rs = getProjectConfig.executeQuery();
            rs.next();

            String title = rs.getString(2);
            String description = rs.getString(3);
            int lecture_id = rs.getInt(4);

            int programming_language_id = rs.getInt(5);
            String project_main_file_format = rs.getString(6);


            ProjectConfig pConfig = new ProjectConfig(id, title, description, lecture_id, programming_language_id, project_main_file_format);

            return pConfig;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public LectureConfig getLectureConfigObject(int id){
        try {
            getLectureConfig.setInt(1, id);
            getPLConfig.execute();
            ResultSet rs = getLectureConfig.executeQuery();
            rs.next();

            String lecture_name = rs.getString(2);
            String lecturer = rs.getString(3);

            LectureConfig lConfig = new LectureConfig(id, lecture_name,lecturer);

            return lConfig;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;

    }

    public PLConfig getPLConfigObject(int id) {
        try {
            getPLConfig.setInt(1, id);
            getPLConfig.execute();
            ResultSet rs = getPLConfig.executeQuery();
            rs.next();

            String name = rs.getString(2);
            String versionString = rs.getString(3);
            int need_compilerint = rs.getInt(4);
            ;
            String compileInsString = rs.getString(5);
            String runInsString = rs.getString(6);
            String versionCheckCommand = rs.getString(7);
            String versionExtractPattern = rs.getString(8);

            boolean need_compiler;
            if (need_compilerint == 1) {
                need_compiler = true;
            } else {
                need_compiler = false;
            }

            PLConfig config = new PLConfig(id, name, versionString, need_compiler, compileInsString, runInsString, versionCheckCommand, Pattern.compile(versionExtractPattern));

            return config;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<LectureConfig> getAllLectureConfigObjects() {
        ArrayList<LectureConfig> lectureList = new ArrayList<>();
        try {
            ResultSet rs = getAllLectureConfigs.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            try {
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        int id = rs.getInt(i++);
                        LectureConfig config = getLectureConfigObject(id);
                        lectureList.add(config);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            return lectureList;

        } catch (Exception e) {
            System.out.println(e);
        }

        return lectureList;
    }

    public ArrayList<ProjectConfig> getAllProjectConfigObjects(){
        ArrayList<ProjectConfig> configList = new ArrayList<>();
        try {
            ResultSet rs = getAllProjectConfigs.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            try {
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        int id = rs.getInt(i++);
                        ProjectConfig config = getProjectConfigObject(id);
                        configList.add(config);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            return configList;

        } catch (Exception e) {
            System.out.println(e);
        }

        return configList;
    }



    public ArrayList<PLConfig> getAllPLConfigObjects() {
        ArrayList<PLConfig> configList = new ArrayList<>();
        try {
            ResultSet rs = getAllPLConfigIds.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            try {
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        int id = rs.getInt(i++);
                        PLConfig config = getPLConfigObject(id);
                        configList.add(config);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            return configList;

        } catch (Exception e) {
            System.out.println(e);
        }

        return configList;
    }

    public void deleteLectureObject(int id) {
        try {
            deleteLecture.setInt(1, id);
            deleteLecture.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deletePLanguageObject(int id){
        try {
            deleteLanguge.setInt(1, id);
            deleteLanguge.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProjectObject(int id){
        try {
            deleteProject.setInt(1, id);
            deleteProject.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateLecture(LectureConfig newLecture) {
        String oldResumid = newResume.getName();
        deleteResume(oldResumeName);
        addResume(newResume);
    }






}