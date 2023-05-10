package com.example.ce316_project;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

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
        LectureConfig ce316 = new LectureConfig(316,"CE316","İlker Korkmaz");
        db.addLecture(ce316);

        launch();
    }
}