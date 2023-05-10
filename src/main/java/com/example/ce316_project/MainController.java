package com.example.ce316_project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;

import org.controlsfx.control.CheckListView;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


public class MainController {
        @FXML
        private Label searchField;
        @FXML
        private TextField filterSearchField;
        @FXML
        private Button addResumeButton;
        @FXML
        private Button addTemplateButton;
        @FXML
        private Button leftBarButton;
        @FXML
        private Button sortOptionButton;
        @FXML
        private ComboBox<String> tags;
        @FXML
        private ComboBox<String> templates;
        @FXML
        private HBox LecturesHBox,  ProjectsHBox , AddLectureBox, AddProjectBox ;
        @FXML
        private ImageView pdfUploadView;
        @FXML
        private VBox drawerShort, drawerLong;
        @FXML
        private StackPane drawerStackPane;
        @FXML
        private VBox generatedResumeBox;
        @FXML
        private ImageView ellipse1, ellipse2;
        @FXML
        private HBox firstEllipses;
        @FXML
        private HBox secondEllipses;
        @FXML
        private HBox thirdEllipses;
        @FXML
        private VBox templateAttributeView;
        @FXML
        private TextField templateName1;
        @FXML
        private Button newTemplateButton;
        @FXML
        private GridPane ProjectGrid;
        @FXML
        private VBox templateNameVBox;
        @FXML
        private GridPane LectureGrid;
        @FXML
        private VBox originalResumeVBox;
        @FXML
        private TextField resumeTitle;
        @FXML
        private ChoiceBox<String> tagDropDown;
        @FXML
        private TextField tagTextField;
        @FXML
        private ChoiceBox<String> myTagsDropDown;
        @FXML
        private HBox modalHBox;
        @FXML
        private HBox allHbox;
        @FXML
        private ScrollPane generatedResumeScrollPane;
        @FXML
        private VBox generatedResumeVBox;
        @FXML
        private HBox checkListViewHBox;
        @FXML
        private TextField tagFilterTextField;
        @FXML
        private CheckListView<String> checkListView;
        @FXML
        private VBox scrollVBox;
        @FXML
        private ScrollPane imageScrollPane;
        @FXML
        private Button share;
        @FXML
        private TableView LectureTableView, LanguageTableView,ProjectTableView;
        @FXML
        private TableColumn LectureNameColumn , LectureTrashColumn , LectureGoColumn , LanguageNameColumn, LanguageTrashColumn , ProjectNameColumn,ProjectTrashColumn,ProjectGoColumn;

        public void initialize() throws SQLException, IOException {
                firstEllipses.widthProperty().addListener((obs, oldVal, newVal) -> {
                        if (firstEllipses.getWidth() < 1400)
                                shortDrawer();
                        else
                                longDrawer();
                });

                generatedResumeBox.heightProperty().addListener((obs, oldVal, newVal) -> {
                        ellipse2.setFitHeight(generatedResumeBox.getHeight());
                        ellipse2.setFitWidth(generatedResumeBox.getWidth() / 2);
                });

                generatedResumeBox.widthProperty().addListener((obs, oldVal, newVal) -> {
                        ellipse2.setFitHeight(generatedResumeBox.getHeight());
                        ellipse2.setFitWidth(generatedResumeBox.getWidth() / 2);
                });

                originalResumeVBox.widthProperty().addListener((obs, oldVal, newVal) -> {
                        scrollVBox.minWidth(originalResumeVBox.getWidth());
                });

                allHbox.heightProperty().addListener((obs, oldVal, newVal) -> {
                        generatedResumeScrollPane.setPrefWidth(generatedResumeVBox.getWidth());
                        generatedResumeScrollPane.setPrefHeight(allHbox.getHeight() - 200);
                });

                generatedResumeScrollPane.widthProperty().addListener((observable, oldValue, newValue) -> {
                        LectureGrid.setPrefWidth(generatedResumeScrollPane.getWidth());
                });
                Label LectureNameLabel = new Label("Lecture Name : ");
                Label LecturerNameLabel = new Label("Lecturer's Name: ");
                Label selectedLectureName=new Label();
                Label selectedLecturerName = new Label();

                LectureGrid.add(LectureNameLabel, 0, 0);
                LectureGrid.add(selectedLecturerName, 1, 0);
                LectureGrid.add(LecturerNameLabel,0,1);
                LectureGrid.add(selectedLectureName,1,1);

                LectureGrid.setHgrow(selectedLectureName, Priority.ALWAYS);
                LectureGrid.setVgrow(selectedLectureName, Priority.ALWAYS);
                LectureGrid.setHgrow(selectedLecturerName, Priority.ALWAYS);
                LectureGrid.setVgrow(selectedLecturerName, Priority.ALWAYS);






        }




        @FXML
        public void openProjectScreen() {
                LecturesHBox.setVisible(true);
                ProjectsHBox.setVisible(false);

                firstEllipses.setVisible(true);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(false);

                String path = "images/trash.png";
                String path2="images/GO.png";

                Image image = new Image(getClass().getResource(path).toExternalForm());
                Image image2 = new Image(getClass().getResource(path2).toExternalForm());

                ObservableList<LectureConfig> ProjectList = FXCollections
                        .observableArrayList();
                ProjectNameColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, String>("name"));
                ProjectTrashColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, ImageView>("image"));
                ProjectGoColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, ImageView>("image2"));


               /* for (int i = 0; i < DBConnection.getInstance().getTemplates().size(); i++) {
                        templateList.add(new ProjectConfig(DBConnection.getInstance().getTemplates().get(i),
                                new ImageView(image),new ImageView(image2)));
                }

                ProjectTableView.setItems(ProjectList);*/
        }
        @FXML
        public void openAddLectureScreen() {
                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(false);
                AddProjectBox.setVisible(false);
                AddLectureBox.setVisible(true);
                BoxBlur blur = new BoxBlur();
                blur.setWidth(10);
                blur.setHeight(10);
                blur.setIterations(3);
                LecturesHBox.setEffect(blur);


                firstEllipses.setVisible(false);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(false);

        }
        @FXML
        public void AddSave() {
                AddLectureBox.setVisible(false);
                AddProjectBox.setVisible(false);
                LecturesHBox.setEffect(null);
                ProjectsHBox.setEffect(null);

        }

        @FXML
        public void openAddProjectScreen() {
                LecturesHBox.setVisible(false);

                ProjectsHBox.setVisible(true);
                AddProjectBox.setVisible(true);
                AddLectureBox.setVisible(false);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(false);
                BoxBlur blur = new BoxBlur();
                blur.setWidth(10);
                blur.setHeight(10);
                blur.setIterations(3);
                ProjectsHBox.setEffect(blur);

        }
        @FXML
        public void openLectureScreen() {
                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(false);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(true);
                thirdEllipses.setVisible(false);

                String path = "images/trash.png";
                String path2="images/GO.png";

                Image image = new Image(getClass().getResource(path).toExternalForm());
                Image image2 = new Image(getClass().getResource(path2).toExternalForm());

                ObservableList<LectureConfig> LectureList = FXCollections
                        .observableArrayList();
                LectureNameColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, String>("LectureName"));
                LectureTrashColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, ImageView>("image"));
                LectureGoColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, ImageView>("image2"));

                // TODO : Database daha yazılmadı ben şimdiden koydum
              /*  for (int i = 0; i < DBConnection.getInstance().getLectures().size(); i++) {
                        LectureList.add(new LectureConfig(DBConnection.getInstance().getLectures().get(i),
                                new ImageView(image),new ImageView(image2)));
                }
                LectureTableView.setItems(LectureList);*/
        }

        @FXML
        public void selectFromLectureTable() throws SQLException, IOException {
                if (LectureTableView.getSelectionModel().getSelectedCells() == null ||
                        LectureTableView.getSelectionModel().getSelectedIndex() == -1) {
                        return;
                }

                int index = LectureTableView.getSelectionModel().getSelectedIndex();

                String LectureName = (String) LectureNameColumn.getCellData(index);


                ObservableList<TablePosition> selectedCells = LectureTableView.getSelectionModel().getSelectedCells();



                templateName1.setText(LectureName);
                if (selectedCells.get(0).getTableColumn().equals(LanguageTrashColumn)) {
                        //DBConnection.getInstance().deleteTemplate(LectureName);
                        System.out.println(LectureName);
                       // fillTableViews();
                } else {


                        //LectureConfig Lecture = DBConnection.getInstance().getLectureObject(LectureName);




                       // ObservableList<Node> children = templateList.getChildren();
                       // children.clear();


                }
        }

        @FXML
        public void selectFromProjectTable() throws SQLException, IOException {
                if (ProjectTableView.getSelectionModel().getSelectedCells() == null ||
                        ProjectTableView.getSelectionModel().getSelectedIndex() == -1) {
                        return;
                }

                int index = ProjectTableView.getSelectionModel().getSelectedIndex();

                String ProjectName = (String) ProjectNameColumn.getCellData(index);
                ObservableList<TablePosition> selectedCells = LectureTableView.getSelectionModel().getSelectedCells();



                if (selectedCells.get(0).getTableColumn().equals(ProjectTrashColumn)) {
                        //DBConnection.getInstance().deleteTemplate(templateName);
                        System.out.println(ProjectName);
                        // fillTableViews();
                }/* else {
                        generateResume.getChildren().clear();
                        Label l1 = new Label("Attributes");
                        l1.setStyle("-fx-font-size: 20;");
                        Label l2 = new Label("Values");
                        l2.setStyle("-fx-font-size: 20;");

                        generateResume.addRow(0, l1, l2);


                        ProjectConfig Project = DBConnection.getInstance().getTemplateObject(ProjectName);
                        ArrayList<String> ProjectAttributes = Project.getAttributes();


                        ObservableList<Node> children = templateList.getChildren();
                        children.clear();


                }*/
        }



        @FXML
        private void longDrawer() {
                drawerStackPane.setPrefWidth(275);
                drawerShort.setVisible(false);
                drawerLong.setVisible(true);
        }

        @FXML
        private void shortDrawer() {
                drawerStackPane.setPrefWidth(70);
                drawerShort.setVisible(true);
                drawerLong.setVisible(false);
        }

        @FXML
        private void toggleDrawer() {
                if (drawerShort.isVisible()) {
                        longDrawer();
                } else
                        shortDrawer();
        }
}
