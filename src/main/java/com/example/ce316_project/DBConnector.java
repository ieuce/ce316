package com.example.ce316_project;

import java.io.File;
import java.sql.*;
import java.util.ArrayList;

public class DBConnector {
    private static DBConnector instance = null;

    private final String fileName;
    private Connection connection;

    private PreparedStatement insertLecture, insertProgrammingLanguage, insertProject, insertGrade, insertEvaluation, insertStudentTable, insertDetailedEvaluation, getDetailedEvaluation2p,
            getPLConfig, getAllPLConfigIds,getAllLectureIds,getAllProjectIds, getMaxProjectID, getEvalIdFromProjectId,
            getLectureConfig, getProjectConfig, getEvaluations, getAllGrades, getStudent, insertProjectwithID,
            getLecture,getPL, deleteLecture, deleteLanguge, deleteProject, deleteGrade, deleteEvaluation,deleteDetailedEvaluation,getAllDetailedEvaluationids, getProjectIDfromLectureID, getProjectIDfromPL;


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
                        "PLANGUAGE_COMPILEINSSTRING TEXT," +
                        "PLANGUAGE_RUNINSSTRING TEXT," +
                        "PLANGUAGE_VERSIONCHECKCOMMAND TEXT," +
                        "PLANGUAGE_VERSIONEXTRACTPATTERN TEXT)");

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Project (" +
                        "PROJECT_ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "PROJECT_TITLE TEXT," +
                        "PROJECT_DESCRIPTION TEXT," +
                        "PROJECT_LECTURE_ID INTEGER," +
                        "PROJECT_PROGRAMMING_LANGUAGE_ID INTEGER," +
                        "PROJECT_MAIN_FILE_FORMAT TEXT)");

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Grade_Table (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "PROJECT_ID INTEGER," +
                        "STUDENT_ID TEXT," +
                        "GRADE INTEGER)");

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Evaluation_Table (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                        "PROJECT_ID INTEGER," +
                        "P_INPUT TEXT," +
                        "P_OUTPUT TEXT)");

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Student_Table (" +
                        "STUDENT_ID TEXT PRIMARY KEY," +
                        "STUDENT_NAME TEXT)");

                stmt.executeUpdate("CREATE TABLE IF NOT EXISTS Detailed_Evaluation_Table (" +
                        "ID INTEGER PRIMARY KEY AUTOINCREMENT, " +
                        "EVALUATION_ID INTEGER, " +
                        "RUN_STATUS INTEGER, " +
                        "RUN_OUTPUT TEXT, " +
                        "STUDENT_ID TEXT)");



                System.out.println("Tables have Created!!");
            }

            insertLecture = connection.prepareStatement("INSERT INTO Lecture (LECTURE_ID, LECTURE_NAME, LECTURER) VALUES (?,?,?)");
            insertProgrammingLanguage = connection.prepareStatement("INSERT INTO ProgrammingLanguage (PLANGUAGE_ID, PLANGUAGE_NAME, PLANGUAGE_VERSIONSTRING, PLANGUAGE_NEEDCOMPILER, PLANGUAGE_COMPILEINSSTRING, PLANGUAGE_RUNINSSTRING, PLANGUAGE_VERSIONCHECKCOMMAND, PLANGUAGE_VERSIONEXTRACTPATTERN) VALUES (?,?,?,?,?,?,?,?)");
            insertProject = connection.prepareStatement("INSERT INTO Project (PROJECT_TITLE, PROJECT_DESCRIPTION,PROJECT_LECTURE_ID,PROJECT_PROGRAMMING_LANGUAGE_ID,PROJECT_MAIN_FILE_FORMAT) VALUES (?,?,?,?,?)");
            insertProjectwithID = connection.prepareStatement("INSERT INTO Project (PROJECT_ID, PROJECT_TITLE, PROJECT_DESCRIPTION,PROJECT_LECTURE_ID,PROJECT_PROGRAMMING_LANGUAGE_ID,PROJECT_MAIN_FILE_FORMAT) VALUES (?,?,?,?,?,?)");
            insertEvaluation = connection.prepareStatement("INSERT INTO Evaluation_Table (PROJECT_ID, P_INPUT, P_OUTPUT) VALUES (?,?,?)");
            insertGrade = connection.prepareStatement("INSERT INTO Grade_Table(PROJECT_ID, STUDENT_ID, GRADE) VALUES (?,?,?)");
            insertStudentTable = connection.prepareStatement("INSERT INTO Student_Table (STUDENT_ID,STUDENT_NAME) VALUES  (?,?)");
            insertDetailedEvaluation = connection.prepareStatement("INSERT INTO Detailed_Evaluation_Table(EVALUATION_ID, RUN_STATUS, RUN_OUTPUT, STUDENT_ID) VALUES (?,?,?,?)");

            getPLConfig = connection.prepareStatement("SELECT * FROM ProgrammingLanguage WHERE PLANGUAGE_ID = ?");
            getAllPLConfigIds = connection.prepareStatement("SELECT PLANGUAGE_ID FROM ProgrammingLanguage");
            getAllLectureIds = connection.prepareStatement("SELECT LECTURE_ID FROM Lecture");
            getAllProjectIds = connection.prepareStatement("SELECT PROJECT_ID FROM Project");
            getProjectConfig = connection.prepareStatement("SELECT * FROM Project WHERE PROJECT_ID = ?");
            getLectureConfig = connection.prepareStatement("SELECT * FROM Lecture WHERE LECTURE_ID = ?");
            getLecture = connection.prepareStatement("SELECT * FROM LECTURE WHERE LECTURE_NAME = ?");
            getPL = connection.prepareStatement("SELECT * FROM ProgrammingLanguage WHERE PLANGUAGE_NAME = ?");
            getEvaluations = connection.prepareStatement("SELECT * FROM Evaluation_Table WHERE PROJECT_ID = ?");
            getAllGrades = connection.prepareStatement("SELECT * FROM Grade_Table WHERE PROJECT_ID = ?");
            getStudent = connection.prepareStatement("SELECT * FROM Student_Table WHERE STUDENT_ID = ?");


            deleteLecture = connection.prepareStatement("DELETE FROM Lecture WHERE LECTURE_ID = ?");
            deleteLanguge = connection.prepareStatement("DELETE FROM ProgrammingLanguage WHERE PLANGUAGE_ID = ?");
            deleteProject = connection.prepareStatement("DELETE FROM Project WHERE PROJECT_ID = ?");
            deleteGrade = connection.prepareStatement("DELETE FROM Grade_Table WHERE PROJECT_ID = ?");
            deleteEvaluation = connection.prepareStatement("DELETE FROM Evaluation_Table WHERE PROJECT_ID = ?");
            deleteDetailedEvaluation = connection.prepareStatement("DELETE FROM  Detailed_Evaluation_Table where EVALUATION_ID=?"); ////// NEYE GÖRE SİLİNMESİ GEREK BAKILMASI GEREKİYOR

            getDetailedEvaluation2p = connection.prepareStatement("SELECT * FROM Detailed_Evaluation_Table WHERE EVALUATION_ID =? AND STUDENT_ID =?");

            getAllDetailedEvaluationids = connection.prepareStatement("SELECT EVALUATION_ID, STUDENT_ID FROM Detailed_Evaluation_Table");

            getProjectIDfromLectureID = connection.prepareStatement("SELECT PROJECT_ID FROM Project Where PROJECT_LECTURE_ID = ?");
            getProjectIDfromPL = connection.prepareStatement("SELECT PROJECT_ID FROM Project WHERE PROJECT_PROGRAMMING_LANGUAGE_ID = ?");
            getMaxProjectID = connection.prepareStatement("SELECT MAX(PROJECT_ID) FROM Project");

            getEvalIdFromProjectId = connection.prepareStatement("SELECT ID FROM Evaluation_Table WHERE PROJECT_ID = ?");

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

    public void addDetailedEvaluation(DetailedEvaluation devaluation) {
        try {
            int evaluation_id = devaluation.getEvaluation_id();
            int run_status = devaluation.getSuccess_code();
            String output = devaluation.getOutput();
            String sid = devaluation.getStudent_id();

            insertDetailedEvaluation.setInt(1, evaluation_id);
            insertDetailedEvaluation.setInt(2, run_status);
            insertDetailedEvaluation.setString(3, output);
            insertDetailedEvaluation.setString(4, sid);
            insertDetailedEvaluation.execute();

        } catch (Exception e) {
            System.err.println(e);
        }
    }/////

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

    public void addStudent_Table(Student_Table st){
        try {
            String id = st.getId();
            String name = st.getName();

            insertStudentTable.setString(1,id);
            insertStudentTable.setString(2,name);
            insertStudentTable.execute();

        }catch (Exception e){
            System.out.println(e);
        }
    }

    public void addGrade(Grade grade){
        try {
            int prjojectid = grade.getProject_id();
            String studentid = grade.getStudent_id();
            int gradeint = grade.getGrade();

            insertGrade.setInt(1,prjojectid);
            insertGrade.setString(2,studentid);
            insertGrade.setInt(3,gradeint);
            insertGrade.execute();
        }catch (Exception e){
            System.out.println(e);
        }

    }

    public void addEvaluation(Evaluation evo){
        try {
            int prjojectid = evo.getProject_id();
            String pinput = evo.getPinput();
            String pout = evo.getPoutput();

            insertEvaluation.setInt(1,prjojectid);
            insertEvaluation.setString(2,pinput);
            insertEvaluation.setString(3,pout);
            insertEvaluation.execute();
        }catch (Exception e){
            System.out.println(e);
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
            String versionExtractPattern = language.getVersionExtractPattern();
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

    public void addProjectwithId(ProjectConfig project){
        try {
            int id = project.getId();
            String title=project.getTitle();
            String description=project.getDescription();
            int lecture_id = project.getLecture_id();
            int programming_language_id=project.getProgramming_language_id();
            String mainFileFormat=project.getMain_file_format();

            insertProjectwithID.setInt(1,id);
            insertProjectwithID.setString(2, title);
            insertProjectwithID.setString(3, description);
            insertProjectwithID.setInt(4,lecture_id);
            insertProjectwithID.setInt(5,programming_language_id);
            insertProjectwithID.setString(6,mainFileFormat);
            insertProjectwithID.execute();

            ArrayList<Evaluation> evaluations = project.getEvaluations();
            for(Evaluation evaluation : evaluations){
                addEvaluation(evaluation);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    public void addProject(ProjectConfig project) {
        try {
            String title=project.getTitle();
            String description=project.getDescription();
            int lecture_id = project.getLecture_id();
            int programming_language_id=project.getProgramming_language_id();
            String mainFileFormat=project.getMain_file_format();

            insertProject.setString(1, title);
            insertProject.setString(2, description);
            insertProject.setInt(3,lecture_id);
            insertProject.setInt(4,programming_language_id);
            insertProject.setString(5,mainFileFormat);
            insertProject.execute();

            ArrayList<Evaluation> evaluations = project.getEvaluations();
            for(Evaluation evaluation : evaluations){
                addEvaluation(evaluation);
            }

        } catch (Exception e) {
            System.err.println(e);
        }
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

            PLConfig config = new PLConfig(id, name, versionString, need_compiler, compileInsString, runInsString, versionCheckCommand, versionExtractPattern);

            return config;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
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


    public LectureConfig getLectureConfigObject(int id) {
        try {
            getLectureConfig.setInt(1, id);
            getLectureConfig.execute();
            ResultSet rs = getLectureConfig.executeQuery();
            rs.next();

            String Lecturename = rs.getString(2);
            String Lecturername = rs.getString(3);


            LectureConfig config = new LectureConfig(id, Lecturename, Lecturername);

            return config;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }
    //Kontrol edilmesi lazım getLecturenin
    public LectureConfig getLecture(String Name) throws SQLException {
        try {
            getLecture.setString(1, Name);
            getLecture.execute();
            ResultSet rs = getLecture.executeQuery();
            rs.next();

            int LectureID = rs.getInt(1);
            String Lecturername = rs.getString(3);


            LectureConfig config = new LectureConfig(LectureID, Name, Lecturername);

            return config;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public DetailedEvaluation getDEvaluation(int Evid, String Sid) throws SQLException {
        try {
            getDetailedEvaluation2p.setInt(1, Evid);
            getDetailedEvaluation2p.setString(2, Sid);
            ResultSet rs = getDetailedEvaluation2p.executeQuery();
            rs.next();

            int id = rs.getInt(1);
            int runstatus = rs.getInt(3);
            String output = rs.getString(4);

            DetailedEvaluation devaluation = new DetailedEvaluation(Evid,Sid,runstatus,output);
            return devaluation;

        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }

    public ArrayList<Grade> getGradesObject(int projectId) {
        ArrayList<Grade> grades = new ArrayList<>();
        try {
            getAllGrades.setInt(1, projectId);
            getAllGrades.execute();
            ResultSet rs = getAllGrades.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String studentId = rs.getString(3);
                int grade = rs.getInt(4);
                Grade gradeObject = new Grade(id, projectId, studentId, grade);
                grades.add(gradeObject);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return grades;
    }

    public ArrayList<DetailedEvaluation> getAllDevaluation() {
        ArrayList<DetailedEvaluation> dEvaluationList = new ArrayList<>();
        try {
            try {
                ResultSet rs = getAllDetailedEvaluationids.executeQuery();
                while (rs.next()) {
                    int Evid = rs.getInt("EVALUATION_ID");
                    String Sid = rs.getString("STUDENT_ID");
                    DetailedEvaluation evaluation = getDEvaluation(Evid, Sid);
                    dEvaluationList.add(evaluation);
                }
            } catch (SQLException e) {
                System.out.println(e);
            }
            return dEvaluationList;

        } catch (Exception e) {
            System.out.println(e);
        }

        return dEvaluationList;
    }

    public ArrayList<LectureConfig> getAllLectureConfigObjects() {
        ArrayList<LectureConfig> configList = new ArrayList<>();
        try {
            ResultSet rs = getAllLectureIds.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            try {
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        int id = rs.getInt(i++);
                        LectureConfig config = getLectureConfigObject(id);
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
    public PLConfig getPL(String Name) throws SQLException {
        try { getPL.setString(1, Name);
            getPL.execute();
            ResultSet rs = getPL.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            String version = rs.getString(3);
            int need_compilerint= rs.getInt(4);
            boolean need_compiler;
            if (need_compilerint == 1) {
                need_compiler = true;
            } else {
                need_compiler = false;
            }
            String compileIns = rs.getString(5);
            String RunIns =rs.getString(6);
            String VersionCheck=rs.getString(7);
            String versionPattern=rs.getString(8);
            String pattern = versionPattern;

            PLConfig config = new PLConfig(id, Name, version,need_compiler,compileIns,RunIns,VersionCheck,pattern);
            return config;


        } catch (Exception e) {
            System.out.println(e);

            return null;
        }


    }




    public ProjectConfig getPConfigObject(int id) {
        try {
            getProjectConfig.setInt(1, id);
            getProjectConfig.execute();
            ResultSet rs = getProjectConfig.executeQuery();
            rs.next();

            String title = rs.getString(2);
            String description = rs.getString(3);
            int lectureId = rs.getInt(4);
            int PlId = rs.getInt(5);
            String mainFileFormat = rs.getString(6);

            ArrayList<Evaluation> evaluations = getEvaluationsObject(id);
            ProjectConfig config = new ProjectConfig(id, title, description, lectureId, PlId, mainFileFormat, evaluations);
            return config;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<Evaluation> getEvaluationsObject(int projectId) {
        ArrayList<Evaluation> evaluations = new ArrayList<>();
        try {
            getEvaluations.setInt(1, projectId);
            getEvaluations.execute();
            ResultSet rs = getEvaluations.executeQuery();
            while (rs.next()) {
                int id = rs.getInt(1);
                String input = rs.getString(3);
                String output = rs.getString(4);
                Evaluation evaluation = new Evaluation(id, projectId, input, output);
                evaluations.add(evaluation);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return evaluations;
    }



    public Student_Table getStudentObject(String student_id){
        try {
            getStudent.setString(1, student_id);
            getStudent.execute();
            ResultSet rs = getStudent.executeQuery();
            rs.next();

            String name = rs.getString(2);
            Student_Table student = new Student_Table(student_id, name);
            return student;

        } catch (Exception e) {
            System.out.println(e);
        }

        return null;
    }

    public ArrayList<ProjectConfig> getAllPConfigObjects() {
        ArrayList<ProjectConfig> configList = new ArrayList<>();
        try {
            ResultSet rs = getAllProjectIds.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();

            try {
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        int id = rs.getInt(i++);
                        ProjectConfig config = getPConfigObject(id);
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
            getProjectIDfromLectureID.setInt(1,id);
            deleteLecture.execute();
            getProjectIDfromLectureID.execute();
            ResultSet rs = getProjectIDfromLectureID.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt(1);
                deleteProjectObject(pid);
            }

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deletePLanguageObject(int id){
        try {
            deleteLanguge.setInt(1, id);
            getProjectIDfromPL.setInt(1,id);
            deleteLanguge.execute();
            getProjectIDfromPL.execute();;
            ResultSet rs = getProjectIDfromPL.executeQuery();
            while (rs.next()) {
                int pid = rs.getInt(1);
                deleteProjectObject(pid);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteProjectObject(int id){
        try {
            deleteProject.setInt(1, id);
            deleteEvaluation.setInt(1,id);
            deleteGrade.setInt(1,id);
            deleteProject.execute();
            deleteEvaluation.execute();
            deleteGrade.execute();

        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void deleteGradeObject(int project_id){
        try {
            deleteGrade.setInt(1, project_id);
            deleteGrade.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public void updateLecture(LectureConfig newLecture){
        int id = newLecture.getLecture_id();
        deleteLectureObject(id);
        addLecture(newLecture);
}

    public void updatePL(PLConfig newPL){
        int id = newPL.getId();
        deletePLanguageObject(id);
        addPL(newPL);
    }
    public void updateProject(ProjectConfig newProject){
        int id = newProject.getId();
        deleteProjectObject(id);
        addProject(newProject);
    }

    public int getMaxProjectIDDB(){
        try {
            ResultSet rs = getMaxProjectID.executeQuery();
            rs.next();
            int id = rs.getInt(1);
            return id;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return 0;
    }

    public ArrayList<Integer> getEvalIdsFromProjectId(int project_id){
        try{
            getEvalIdFromProjectId.setInt(1,project_id);
            getEvalIdFromProjectId.execute();
            ResultSet rs = getEvalIdFromProjectId.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            ArrayList<Integer> evalIds = new ArrayList<>();
            try {
                while (rs.next()) {
                    int i = 1;
                    while (i <= columnCount) {
                        int id = rs.getInt(i++);
                        evalIds.add(id);
                    }
                }
            } catch (SQLException e) {
                System.out.println(e);
            }

            return evalIds;
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public void deleteDetailedEvaluationObject(int id){
        try {
            deleteDetailedEvaluation.setInt(1, id);
            deleteDetailedEvaluation.execute();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}