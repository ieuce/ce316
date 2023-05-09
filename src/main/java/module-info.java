module com.example.ce316_project {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    requires org.apache.pdfbox;
    requires java.desktop;
    requires org.controlsfx.controls;
    requires org.apache.lucene.queryparser;
    requires org.apache.lucene.core;

    opens com.example.ce316_project to javafx.fxml;

    exports com.example.ce316_project;
}