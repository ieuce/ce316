package com.example.ce316_project;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertUtil {

    public static void showUnsupportedSelectionAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("WARNING!");
        alert.setHeaderText("Unsupported selection");
        alert.setContentText("You should have selected a programming language.");

        alert.showAndWait();
    }

    public static void showUnsupportedSelectionLectureAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("WARNING!");
        alert.setHeaderText("Unsupported selection");
        alert.setContentText("You should have selected a Lecture");

        alert.showAndWait();
    }
}
