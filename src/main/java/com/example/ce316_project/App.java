package com.example.ce316_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import org.apache.lucene.queryparser.classic.ParseException;

public class App extends Application {
    @Override
    public void start(Stage stage) throws IOException, ParseException, ClassNotFoundException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("IAEMainScreen.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        String path = "images/paintedLogo.png";
        Image image = new Image(getClass().getResource(path).toExternalForm());
        stage.getIcons().add(image);
        stage.setTitle("Integrated Assignment Editor");
        stage.setMinHeight(800);
        stage.setMinWidth(1300);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        int projectID = 1;
        String mainProgramFileName = "example.py";
        ArrayList<String> inputs = new ArrayList<>();
        inputs.add("0");
        inputs.add("1 2 3");
        inputs.add("5 6 7");
        inputs.add("7 8 9");
        ArrayList<String> expectedOutputs = new ArrayList<>();
        expectedOutputs.add("0");
        expectedOutputs.add("6");
        expectedOutputs.add("18");
        expectedOutputs.add("24");

        DBConnector db = DBConnector.getInstance();
        PLConfig config = db.getPLConfigObject(1);
        String sourcePath = "sample_files/projects-2.zip";
        String destinationPath = "src/main/resources/student_performances/project-"+String.valueOf(projectID);
        extractZipFile(new File(sourcePath), new File(destinationPath));

        File directory = new File(destinationPath+"/projects");
        File[] folders = directory.listFiles(File::isDirectory);
        
        if (folders != null) {
            for (File folder : folders) {
                String folderName = folder.getName();
                double score = config.executeAndEvaluate(new File(folder.getAbsolutePath()+"/"+mainProgramFileName), inputs, expectedOutputs, false);
                System.out.println("Score for "+folderName+" is "+score);
            }
        }

        try {
            Path folder = Path.of(destinationPath);
            Files.walkFileTree(folder, new SimpleFileVisitor<>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    Files.delete(file);
                    return FileVisitResult.CONTINUE;
                }
    
                @Override
                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                    Files.delete(dir);
                    return FileVisitResult.CONTINUE;
                }
            });
            
            System.out.println("Folder removed successfully.");
        } catch (IOException e) {
            System.out.println("Error removing folder: " + e.getMessage());
        }
        
        launch();
    }

    public static void extractZipFile(File zipFile, File outputDirectory) {
        try {
            ZipFile zip = new ZipFile(zipFile);
            Enumeration<? extends ZipEntry> entries = zip.entries();
            
            byte[] buffer = new byte[1024];
            while (entries.hasMoreElements()) {
                ZipEntry entry = entries.nextElement();
                File entryFile = new File(outputDirectory, entry.getName());
                
                if (entry.isDirectory()) {
                    entryFile.mkdirs();
                } else {
                    entryFile.getParentFile().mkdirs();
                    InputStream inputStream = zip.getInputStream(entry);
                    FileOutputStream outputStream = new FileOutputStream(entryFile);
                    int length;
                    while ((length = inputStream.read(buffer)) > 0) {
                        outputStream.write(buffer, 0, length);
                    }
                    outputStream.close();
                    inputStream.close();
                }
            }
            
            zip.close();
            System.out.println("Extraction completed successfully.");
        } catch (IOException e) {
            System.out.println("Error extracting zip file: " + e.getMessage());
        }
    }
    
}