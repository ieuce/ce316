package com.example.ce316_project;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PLConfig{
    private int id;
    private String name;
    private String versionString;
    private boolean need_compiler;
    private String compileInsString;
    private String runInsString;
    private String versionCheckCommand;
    private Pattern versionExtractPattern;

    public PLConfig(int id, String name, String versionString, boolean need_compiler, String compileInsString, String runInsString, String versionCheckCommand, Pattern versionExtractPattern) throws Exception{
        this.id = id;
        this.name = name.trim();
        this.versionString = versionString.trim();
        this.need_compiler = need_compiler;
        this.compileInsString = compileInsString;
        this.runInsString = runInsString.trim();
        this.versionCheckCommand = versionCheckCommand.trim();
        this.versionExtractPattern = versionExtractPattern;

        if(this.need_compiler && this.compileInsString == null){
            throw new Exception("Compiler instruction string can not be null!");
        }

        this.versionCheck();
    }
    public PLConfig() {

    }

    private String extractVersion(String output) throws Exception{
        Matcher matcher = this.versionExtractPattern.matcher(output);
        if(matcher.find()){
            return matcher.group(1).trim();
        } else {
            throw new Exception("Version not found");
        }
    }

    private void versionCheck() throws Exception{
        String output = this.runCommand(this.versionCheckCommand);
        output = this.extractVersion(output);
        System.out.println("Command output: " + output);
        if(this.versionString.equals(output)){
            System.out.println("Version check passed for " + this.name);
        } else {
            throw new Exception("Version check failed for " + this.name);
        }
    }

    public ExecuteStatus executeProgram(File file, String args){
        boolean success;
        String output = null;
        try{
            if(this.need_compiler){
                String modifiedCompileString = this.compileInsString.replace("<PARENT_DIRECTORY>", file.getParentFile().getAbsolutePath()).replace("<FILENAME>", file.getName().split("\\.")[0]);
                output = this.runCommand(modifiedCompileString);
                System.out.println("Compile output: " + output);
            }
            String modifiedRunString = this.runInsString.replace("<PARENT_DIRECTORY>", file.getParentFile().getAbsolutePath()).replace("<FILENAME>", file.getName().split("\\.")[0]);
            modifiedRunString = modifiedRunString.replace("<ARGS>", args);
            output = this.runCommand(modifiedRunString);
            System.out.println("Run output: " + output);
            success = true;
        }
        catch (Exception e) {
            success = false;
            output = e.getMessage();
        }

        return new ExecuteStatus(this.id, this.name, output, success);
    }

    private String runCommand(String command) throws Exception {
        System.out.println("Running command: " + command);
        ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/C", command);
        Process process;
        try {
            process = processBuilder.start();
            InputStream inputStream = process.getInputStream();
            Scanner scanner = new Scanner(inputStream).useDelimiter("\\A");
            String output = scanner.hasNext() ? scanner.next() : "";
            scanner.close();
    
            InputStream errorStream = process.getErrorStream();
            scanner = new Scanner(errorStream).useDelimiter("\\A");
            String errorOutput = scanner.hasNext() ? scanner.next() : "";
            scanner.close();
    
            int exitCode;
            try {
                exitCode = process.waitFor();
                if (exitCode == 0) {
                    return output;
                } else {
                    throw new Exception("Command (" + command + ") exited with non-zero exit code: " + exitCode);
                }
            } catch (InterruptedException e) {
                throw new Exception("Command (" + command + ") interrupted: " + e.getMessage());
            }
        } catch (IOException e) {
            throw new Exception("Error running command (" + command + "): " + e.getMessage());
        }
    }

    public int getId(){
        return this.id;
    }
    
    public String getName(){
        return this.name;
    }

    public void inputData(int id, String name, String versionString, boolean need_compiler,
                          String compileInsString, String runInsString, String versionCheckCommand,
                          Pattern versionExtractPattern) throws Exception {
        this.id = id;
        this.name = name.trim();
        this.versionString = versionString.trim();
        this.need_compiler = need_compiler;
        this.compileInsString = compileInsString;
        this.runInsString = runInsString.trim();
        this.versionCheckCommand = versionCheckCommand.trim();
        this.versionExtractPattern = versionExtractPattern;

        if (this.need_compiler && this.compileInsString == null) {
            throw new Exception("Compiler instruction string cannot be null!");
        }

        this.versionCheck();
    }

    public void outputData() {
        System.out.println("ID: " + this.id);
        System.out.println("Name: " + this.name);
        System.out.println("Version String: " + this.versionString);
        System.out.println("Need Compiler: " + this.need_compiler);
        System.out.println("Compile Instruction String: " + this.compileInsString);
        System.out.println("Run Instruction String: " + this.runInsString);
        System.out.println("Version Check Command: " + this.versionCheckCommand);
        System.out.println("Version Extract Pattern: " + this.versionExtractPattern.pattern());
    }


    public double executeAndEvaluate(File file, ArrayList<String> inputs, ArrayList<String> expectedOutputs) {
        int totalQuestions = inputs.size();
        int correctAnswers = 0;

        for (int i = 0; i < totalQuestions; i++) {
            String input = inputs.get(i);
            String expectedOutput = expectedOutputs.get(i);

            ExecuteStatus output = executeProgram(file, input);
            String actualOutput = output.getOutput();

            System.out.println("Input: " + input);
            System.out.println("Expected Output: " + expectedOutput);
            System.out.println("Actual Output: " + actualOutput);

            boolean success = actualOutput.trim().equals(expectedOutput.trim());
            System.out.println("Success: " + success);

            if (success) {
                correctAnswers++;
            }
        }

        double score = (double) correctAnswers / totalQuestions * 100;
        System.out.println("Overall Score: " + score);

        return score;
    }






    public static void main(String[] args) {
        // Default variables.
        PLConfig config = null;

        ExecuteStatus output = null;

        // JAVA
        try {
            config.inputData(0, "Java19", "19.0.2", true,
                    "javac <PARENT_DIRECTORY>/<FILENAME>.java",
                    "java -classpath <PARENT_DIRECTORY> <FILENAME> <ARGS>",
                    "java --version",
                    Pattern.compile("openjdk (\\d+\\.\\d+\\.\\d+\\+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }

        if (config != null) {
            output = config.executeProgram(new File("sample_files/example.java"), "1 2 3");
            System.out.println("Success: " + output.getSuccess());
            System.out.println("Output: " + output.getOutput());
        }


        // PYTHON
        try {
            config = new PLConfig(1, "Python38", "3.11.3", false, null, "python <PARENT_DIRECTORY>/<FILENAME>.py <ARGS>", "python --version", Pattern.compile("Python (\\d+\\.\\d+\\.\\d+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }

        if (config != null) {
            output = config.executeProgram(new File("sample_files/example.py"), "1 2 3");
            System.out.println("Success: " + output.getSuccess());
            System.out.println("Output: " + output.getOutput());
        }


        try {
            config.inputData(0, "Java19", "19.0.2", true,
                    "javac <PARENT_DIRECTORY>/<FILENAME>.java",
                    "java -classpath <PARENT_DIRECTORY> <FILENAME> <ARGS>",
                    "java --version",
                    Pattern.compile("openjdk (\\d+\\.\\d+\\.\\d+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }

        if (config != null) {
            output = config.executeProgram(new File("sample_files/example.java"), "1 2 3");
            System.out.println("Success: " + output.getSuccess());
            System.out.println("Output: " + output.getOutput());
        }

        //config.outputData();


        if (config != null) {
            File file = new File("sample_files/example.java");

            ArrayList<String> inputs = new ArrayList<>();
            inputs.add("1 2 3");
            inputs.add("5 6 7");
            inputs.add("7 8 9");


            ArrayList<String> expectedOutputs = new ArrayList<>();
            expectedOutputs.add("6");
            expectedOutputs.add("18");
            expectedOutputs.add("100");


            ArrayList<String> outputs = new ArrayList<>();

            int correctAnswers = 0;

            for (int i = 0; i < inputs.size(); i++) {
                ExecuteStatus status = config.executeProgram(file, inputs.get(i));
                String actualOutput = status.getOutput();
                outputs.add(actualOutput);

                String expectedOutput = expectedOutputs.get(i);
                boolean success = actualOutput.trim().equals(expectedOutput.trim());
                System.out.println("Input: " + inputs.get(i));
                System.out.println("Expected Output: " + expectedOutput);
                System.out.println("Actual Output: " + actualOutput);
                System.out.println("Success: " + success);

                if (success) {
                    correctAnswers++;
                }
            }

            double score = (double) correctAnswers / inputs.size() * 100;
            System.out.println("Overall Score: " + score);
        }

        DBConnector db = new DBConnector();
        ProjectConfig CE316 = new ProjectConfig(31,"Çakma IDE","Proje kodlarını çalıştıran bir uyg",316,31,"JAVA");
        ProjectConfig CE317 = new ProjectConfig(433,"CV Database","CV depolayan uyg",302,32,"JAVA");
        Grade ouz = new Grade(3,32,201,100);
        Evalution sa = new Evalution(123,321,"as","selamünaleykim");
        //db.addGrade(ouz);
        db.addEvaluation(sa);






    }



    public String getVersionString() {
        return versionString;
    }

    public boolean isNeed_compiler() {
        return need_compiler;
    }

    public String getCompileInsString() {
        return compileInsString;
    }

    public String getRunInsString() {
        return runInsString;
    }

    public String getVersionCheckCommand() {
        return versionCheckCommand;
    }

    public Pattern getVersionExtractPattern() {
        return versionExtractPattern;
    }
}