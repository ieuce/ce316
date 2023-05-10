package com.example.ce316_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

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
        DBConnector db = DBConnector.getInstance();
        /*LectureConfig ce316 = new LectureConfig(316,"CE316","İlker Korkmaz");
        db.addLecture(ce316);*/

        PLConfig config = null;
        // JAVA
        try {
            config = new PLConfig(0, "Java18", "18.0.2.1", true, "javac <PARENT_DIRECTORY>/<FILENAME>.java", "java -classpath <PARENT_DIRECTORY> <FILENAME> <ARGS>", "java --version", Pattern.compile("java (\\d+\\.\\d+\\.\\d+\\.\\d+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }
        db.addPL(config);

        // PYTHON
        try {
            config = new PLConfig(1, "Python38", "3.8.5", false, null, "python <PARENT_DIRECTORY>/<FILENAME>.py <ARGS>", "python --version", Pattern.compile("Python (\\d+\\.\\d+\\.\\d+)"));
            System.out.println("Config created: " + config.getName());
        } catch (Exception e) {
            System.out.println("Failed to create config: " + e.getMessage());
        }
        db.addPL(config);


        launch();
    }
}