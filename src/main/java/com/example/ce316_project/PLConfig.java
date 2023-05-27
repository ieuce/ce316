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
    private transient Pattern versionExtractPattern;
    private String versionExtractPatternString;

    public PLConfig(int id, String name, String versionString, boolean need_compiler, String compileInsString, String runInsString, String versionCheckCommand, String versionExtractPattern) throws Exception{
        this.id = id;
        this.name = name.trim();
        this.versionString = versionString.trim();
        this.need_compiler = need_compiler;
        this.compileInsString = compileInsString;
        this.runInsString = runInsString.trim();
        this.versionCheckCommand = versionCheckCommand.trim();
        this.versionExtractPatternString = versionExtractPattern.trim();
        this.versionExtractPattern = Pattern.compile(versionExtractPattern);

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

    public ArrayList<DetailedEvaluation> executeAndEvaluate(File file, ArrayList<Evaluation> evaluations, boolean debug, String student_id) {
        /**
         * detailed evaluation isteniyor
         *  private int evaluation_id;
         *     private String student_id;
         *     private int success_code;
         *     private String output;
         *
         * evaluation veriliyor ve
         *  private int id;
         *     private int project_id;
         *
         *     private String pinput;
         *     private String poutput;
         *
         *score puanı da hesaplanıyor

         **/

        ArrayList<DetailedEvaluation>detailedEvaluations = new ArrayList<>();


        int totalQuestions = evaluations.size();

        int id=-1;
        int evaid;
        String pinput;
        String poutput;
        String studentid;
        int successcode;
        String outputtaken;

        for (int i = 0; i < totalQuestions; i++) {
            Evaluation evaluation = evaluations.get(i);
            String input = evaluation.getPinput();
            String expectedOutput = evaluation.getPoutput();

            ExecuteStatus output = executeProgram(file, input, debug);
            String actualOutput = output.getOutput();
            boolean success = actualOutput.trim().equals(expectedOutput.trim());
            evaid=evaluation.getId();
            studentid=student_id;
            outputtaken=output.getOutput();


            if(debug){
                System.out.println("Input: " + input);
                System.out.println("Expected Output: " + expectedOutput);
                System.out.println("Actual Output: " + actualOutput);
                System.out.println("Success: " + success);
            }
            if(output.getSuccess()){
                if (success){
                    successcode=0;
                }
                else {
                    successcode=1;
                }
            }
            else {
                successcode=2;
            }
            detailedEvaluations.add(new DetailedEvaluation(evaid,studentid,successcode,outputtaken));

        }

        return detailedEvaluations;
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

    public String getVersionExtractPattern() {
        return versionExtractPatternString;
    }
}