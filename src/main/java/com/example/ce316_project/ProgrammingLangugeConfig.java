package com.example.ce316_project;

public class ProgrammingLangugeConfig {

     private int programmingLanguage_id;
     private String programmingLanguage_Name;
     private String programmingLanguage_Version;
     private int programmingLanguage_Compiler;
     private int programmingLanguage_interpreter;
     private String programmingLanguage_compile_instruction;
     private String programmingLanguage_run_instruction;
     private String programmingLanguage_pre_chech;

    public ProgrammingLangugeConfig(int programmingLanguage_id, String programmingLanguage_Name, String programmingLanguage_Version, int programmingLanguage_Compiler, int programmingLanguage_interpreter, String programmingLanguage_compile_instruction, String programmingLanguage_run_instruction, String programmingLanguage_pre_chech) {
        this.programmingLanguage_id = programmingLanguage_id;
        this.programmingLanguage_Name = programmingLanguage_Name;
        this.programmingLanguage_Version = programmingLanguage_Version;
        this.programmingLanguage_Compiler = programmingLanguage_Compiler;
        this.programmingLanguage_interpreter = programmingLanguage_interpreter;
        this.programmingLanguage_compile_instruction = programmingLanguage_compile_instruction;
        this.programmingLanguage_run_instruction = programmingLanguage_run_instruction;
        this.programmingLanguage_pre_chech = programmingLanguage_pre_chech;
    }

    public int getProgrammingLanguage_id() {
        return programmingLanguage_id;
    }

    public void setProgrammingLanguage_id(int programmingLanguage_id) {
        this.programmingLanguage_id = programmingLanguage_id;
    }

    public String getProgrammingLanguage_Name() {
        return programmingLanguage_Name;
    }

    public void setProgrammingLanguage_Name(String programmingLanguage_Name) {
        this.programmingLanguage_Name = programmingLanguage_Name;
    }

    public String getProgrammingLanguage_Version() {
        return programmingLanguage_Version;
    }

    public void setProgrammingLanguage_Version(String programmingLanguage_Version) {
        this.programmingLanguage_Version = programmingLanguage_Version;
    }

    public int getProgrammingLanguage_Compiler() {
        return programmingLanguage_Compiler;
    }

    public void setProgrammingLanguage_Compiler(int programmingLanguage_Compiler) {
        this.programmingLanguage_Compiler = programmingLanguage_Compiler;
    }

    public int getProgrammingLanguage_interpreter() {
        return programmingLanguage_interpreter;
    }

    public void setProgrammingLanguage_interpreter(int programmingLanguage_interpreter) {
        this.programmingLanguage_interpreter = programmingLanguage_interpreter;
    }

    public String getProgrammingLanguage_compile_instruction() {
        return programmingLanguage_compile_instruction;
    }

    public void setProgrammingLanguage_compile_instruction(String programmingLanguage_compile_instruction) {
        this.programmingLanguage_compile_instruction = programmingLanguage_compile_instruction;
    }

    public String getProgrammingLanguage_run_instruction() {
        return programmingLanguage_run_instruction;
    }

    public void setProgrammingLanguage_run_instruction(String programmingLanguage_run_instruction) {
        this.programmingLanguage_run_instruction = programmingLanguage_run_instruction;
    }

    public String getProgrammingLanguage_pre_chech() {
        return programmingLanguage_pre_chech;
    }

    public void setProgrammingLanguage_pre_chech(String programmingLanguage_pre_chech) {
        this.programmingLanguage_pre_chech = programmingLanguage_pre_chech;
    }
}
