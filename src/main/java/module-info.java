module com.example.ce316_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires java.desktop;
    requires org.controlsfx.controls;
    requires javafx.media;

    opens com.example.ce316_project to javafx.fxml;

    exports com.example.ce316_project;
}