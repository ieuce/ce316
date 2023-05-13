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

    private String extractVersion(String output) throws Exception{
        Matcher matcher = this.versionExtractPattern.matcher(output);
        if(matcher.find()){
            return matcher.group(1).trim();
        } else {
            throw new Exception("Version not found");
        }
    }

    private void versionCheck() throws Exception{
        String output = this.runCommand(this.versionCheckCommand, true);
        output = this.extractVersion(output);
        System.out.println("Command output: " + output);
        if(this.versionString.equals(output)){
            System.out.println("Version check passed for " + this.name);
        } else {
            throw new Exception("Version check failed for " + this.name);
        }
    }

    public ExecuteStatus executeProgram(File file, String args, boolean debug){
        boolean success;
        String output = null;
        try{
            if(this.need_compiler){
                String modifiedCompileString = this.compileInsString.replace("<PARENT_DIRECTORY>", file.getParentFile().getAbsolutePath()).replace("<FILENAME>", file.getName().split("\\.")[0]);
                output = this.runCommand(modifiedCompileString, debug);
                if(debug){
                    System.out.println("Compile output: " + output);
                }
            }
            String modifiedRunString = this.runInsString.replace("<PARENT_DIRECTORY>", file.getParentFile().getAbsolutePath()).replace("<FILENAME>", file.getName().split("\\.")[0]);
            modifiedRunString = modifiedRunString.replace("<ARGS>", args);
            output = this.runCommand(modifiedRunString, debug);
            if(debug){
                System.out.println("Run output: " + output);
            }
            success = true;
        }
        catch (Exception e) {
            success = false;
            output = e.getMessage();
        }

        return new ExecuteStatus(this.id, this.name, output, success);
    }

    private String runCommand(String command, boolean debug) throws Exception {
        if(debug){
            System.out.println("Running command: " + command);
        }
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

    public double executeAndEvaluate(File file, ArrayList<String> inputs, ArrayList<String> expectedOutputs, boolean debug) {
        int totalQuestions = inputs.size();
        int correctAnswers = 0;

        for (int i = 0; i < totalQuestions; i++) {
            String input = inputs.get(i);
            String expectedOutput = expectedOutputs.get(i);

            ExecuteStatus output = executeProgram(file, input, debug);
            String actualOutput = output.getOutput();
            boolean success = actualOutput.trim().equals(expectedOutput.trim());
            
            if(debug){
                System.out.println("Input: " + input);
                System.out.println("Expected Output: " + expectedOutput);
                System.out.println("Actual Output: " + actualOutput);
                System.out.println("Success: " + success);
            }

            if (success) {
                correctAnswers++;
            }
        }

        double score = (double) correctAnswers / totalQuestions * 100;

        if(debug){
            System.out.println("Correct Answers: " + correctAnswers);
            System.out.println("Total Questions: " + totalQuestions);
            System.out.println("Overall Score: " + score);
        }

        return score;
    }

    public static void main(String[] args) {
        // Default variables.
        PLConfig config = null;

        ExecuteStatus output = null;

        // PYTHON
        try {
            config = new PLConfig(1, "Python38", "3.8.5", false, null, "python <PARENT_DIRECTORY>/<FILENAME>.py <ARGS>", "python --version", Pattern.compile("Python (\\d+\\.\\d+\\.\\d+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }

        if (config != null) {
            output = config.executeProgram(new File("sample_files/example.py"), "1 2 3", true);
            System.out.println("Success: " + output.getSuccess());
            System.out.println("Output: " + output.getOutput());
        }

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
                ExecuteStatus status = config.executeProgram(file, inputs.get(i), true);
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

        ProjectConfig CE316 = new ProjectConfig(31,"Çakma IDE","Proje kodlarını çalıştıran bir uyg",316,31,"JAVA");
        ProjectConfig CE317 = new ProjectConfig(433,"CV Database","CV depolayan uyg",302,32,"JAVA");
        DBConnector db = new DBConnector();
        db.updateProject(CE317);





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