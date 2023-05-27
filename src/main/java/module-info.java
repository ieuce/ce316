module com.example.ce316_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires java.desktop;
    requires org.controlsfx.controls;
    requires javafx.media;
    requires com.google.gson;

    opens com.example.ce316_project to javafx.fxml,com.google.gson;

    exports com.example.ce316_project;
}