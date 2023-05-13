package com.example.ce316_project;

import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileWriter;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


public class ProjectConfig {
    private int id;
    private String title;
    private String description;
    private int lecture_id;
    private int programming_language_id;
    private String main_file_format;
    private ArrayList<String> attributes;

    public ProjectConfig(int id, String title, String description, int lecture_id, int programming_language_id, String main_file_format, ArrayList<String> attributes) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.lecture_id = lecture_id;
        this.programming_language_id = programming_language_id;
        this.main_file_format = main_file_format;
        this.attributes = attributes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getLecture_id() {
        return lecture_id;
    }

    public void setLecture_id(int lecture_id) {
        this.lecture_id = lecture_id;
    }

    public int getProgramming_language_id() {
        return programming_language_id;
    }

    public void setProgramming_language_id(int programming_language_id) {
        this.programming_language_id = programming_language_id;
    }

    public String getMain_file_format() {
        return main_file_format;
    }

    public void setMain_file_format(String main_file_format) {
        this.main_file_format = main_file_format;
    }

    public ArrayList<String> getAttributes() {
        return attributes;
    }

    public void setAttributes(ArrayList<String> attributes) {
        this.attributes = attributes;
    }

    public void inputData(String title, String description, int lectureId, int programmingLanguageId, String mainFileFormat, ArrayList<String> attributes) {
        this.setTitle(title);
        this.setDescription(description);
        this.setLecture_id(lectureId);
        this.setProgramming_language_id(programmingLanguageId);
        this.setMain_file_format(mainFileFormat);
        this.setAttributes(attributes);
    }

    public void outputData() {
        System.out.println("Title: " + this.getTitle());
        System.out.println("Description: " + this.getDescription());
        System.out.println("Lecture ID: " + this.getLecture_id());
        System.out.println("Programming Language ID: " + this.getProgramming_language_id());
        System.out.println("Main File Format: " + this.getMain_file_format());
        System.out.println("Attributes: " + this.getAttributes());
    }

    /*
    public static int calculateOutputUsingExample(ArrayList<String> attributes) {
        try {
            // Geçici bir Java dosyası oluştur
            StringBuilder javaCode = new StringBuilder();
            javaCode.append("public class example {\n");
            javaCode.append("    public static void main(String[] args) {\n");
            javaCode.append("        int total = 0;\n");
            javaCode.append("        for(int i=0; i<args.length; i++){\n");
            javaCode.append("            total += Integer.parseInt(args[i]);\n");
            javaCode.append("        }\n");
            javaCode.append("        System.out.println(total);\n");
            javaCode.append("    }\n");
            javaCode.append("}");

            File tempFile = File.createTempFile("example", ".java");
            FileWriter writer = new FileWriter(tempFile);
            writer.write(javaCode.toString());
            writer.close();

            // Geçici olacağ olan java dosyasını derleyen kısım
            Process compileProcess = Runtime.getRuntime().exec("javac " + tempFile.getAbsolutePath());
            compileProcess.waitFor();

            // Derleme çıktısını okuyan metod ss
            InputStream compileOutput = compileProcess.getInputStream();
            Scanner compileScanner = new Scanner(compileOutput).useDelimiter("\\A");
            String compileResult = compileScanner.hasNext() ? compileScanner.next() : "";
            compileScanner.close();

            if (!compileResult.isEmpty()) {
                throw new Exception("Compilation error:\n" + compileResult);
            }

            // Derleme başarılıolursa , programı çalıştıracak
            String[] argsArray = attributes.toArray(new String[0]);
            Process runProcess = Runtime.getRuntime().exec("java -classpath " + tempFile.getParent() + " " + tempFile.getName().split("\\.")[0], argsArray);

            // Program çıktısını okuyacak olan kısım
            InputStream runOutput = runProcess.getInputStream();
            Scanner runScanner = new Scanner(runOutput).useDelimiter("\\A");
            String runResult = runScanner.hasNext() ? runScanner.next() : "";
            runScanner.close();

            return Integer.parseInt(runResult.trim());
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            return -1; // Hata  görürzem otomatik -1 döndür hatta bunu gördükten sonra direkt 0 puan da verebiliriz.
        }
    }

     */


    public static void main(String[] args) {
        ProjectConfig project = new ProjectConfig(1, "", "", 0, 0, "", new ArrayList<>());
        project.inputData("Title", "Description", 3, 1, ".java", new ArrayList<>());
        project.outputData();

        List<String> attributes = Arrays.asList("1", "2", "3");
        ArrayList<String> attributeList = new ArrayList<>(attributes); // ArrayListe dönüştürme kısmı


    }



}
