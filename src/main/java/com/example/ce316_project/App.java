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
        extractZipFile(new File("sample_files/PROJECTS.zip"), new File("src/main/resources/sample_files/projects"));
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