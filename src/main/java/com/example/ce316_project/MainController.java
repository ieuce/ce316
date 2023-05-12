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
import org.w3c.dom.Text;


public class MainController {

        @FXML
        private Button AddAttribute;

        @FXML
        private HBox AddLectureBox;

        @FXML
        private Button AddLectureButton;

        @FXML
        private GridPane AddLectureGrid;

        @FXML
        private HBox AddPLBox;

        @FXML
        private Button AddPLButton;

        @FXML
        private GridPane AddPLGrid;

        @FXML
        private HBox AddProjectBox;

        @FXML
        private Button AddProjectButton;

        @FXML
        private GridPane AddProjectGrid;

        @FXML
        private Button GoToAddLectureButton;

        @FXML
        private Button GoToAddPLButton;

        @FXML
        private Button GoToAddProjectButton;

        @FXML
        private Button LectureButton;

        @FXML
        private TableColumn LectureGoColumn;

        @FXML
        private GridPane LectureGrid;

        @FXML
        private TableColumn LectureNameColumn;

        @FXML
        private TableView LectureTableView;

        @FXML
        private TableColumn LectureTrashColumn;

        @FXML
        private HBox LecturesHBox;

        @FXML
        private TableColumn PLGoColumn;

        @FXML
        private GridPane PLGrid;

        @FXML
        private TableColumn PLNameColumn;

        @FXML
        private TableView<?> PLTableView;

        @FXML
        private TableColumn PLTrashColumn;

        @FXML
        private HBox PL_HBox;

        @FXML
        private Button ProgrammingLanguageButton;

        @FXML
        private TableColumn ProjectGoColumn;

        @FXML
        private GridPane ProjectGrid;

        @FXML
        private TableColumn ProjectNameColumn;

        @FXML
        private TableView ProjectTableView;

        @FXML
        private TableColumn ProjectTrashColumn;

        @FXML
        private HBox ProjectsHBox;

        @FXML
        private HBox allHbox;

        @FXML
        private VBox drawerLong;

        @FXML
        private VBox drawerShort;

        @FXML
        private StackPane drawerStackPane;

        @FXML
        private ImageView ellipse1;

        @FXML
        private ImageView ellipse2;

        @FXML
        private HBox firstEllipses;

        @FXML
        private VBox generatedResumeBox;

        @FXML
        private ScrollPane generatedResumeScrollPane;

        @FXML
        private ScrollPane generatedResumeScrollPane1;

        @FXML
        private ScrollPane generatedResumeScrollPane2;

        @FXML
        private ScrollPane generatedResumeScrollPane21;

        @FXML
        private ScrollPane generatedResumeScrollPane22;

        @FXML
        private ScrollPane generatedResumeScrollPane3;

        @FXML
        private VBox generatedResumeVBox;

        @FXML
        private VBox generatedResumeVBox1;

        @FXML
        private VBox generatedResumeVBox2;

        @FXML
        private Button leftBarButton;

        @FXML
        private Button leftBarButton1;

        @FXML
        private VBox originalResumeVBox;

        @FXML
        private VBox originalResumeVBox1;

        @FXML
        private VBox originalResumeVBox2;

        @FXML
        private HBox secondEllipses;

        @FXML
        private VBox templateAttributeView;

        @FXML
        private VBox templateAttributeView1;

        @FXML
        private VBox templateAttributeView11;

        @FXML
        private VBox templateAttributeView2;

        @FXML
        private VBox templateNameVBox;

        @FXML
        private VBox templateNameVBox1;

        @FXML
        private VBox templateNameVBox2;

        @FXML
        private VBox templatePane;

        @FXML
        private VBox templatePane1;

        @FXML
        private VBox templatePane2;

        @FXML
        private HBox thirdEllipses;

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

                /*originalResumeVBox.widthProperty().addListener((obs, oldVal, newVal) -> {
                        scrollVBox.minWidth(originalResumeVBox.getWidth());
                });*/

                allHbox.heightProperty().addListener((obs, oldVal, newVal) -> {
                        generatedResumeScrollPane.setPrefWidth(generatedResumeVBox.getWidth());
                        generatedResumeScrollPane.setPrefHeight(allHbox.getHeight() - 200);
                });

                generatedResumeScrollPane.widthProperty().addListener((observable, oldValue, newValue) -> {
                        LectureGrid.setPrefWidth(generatedResumeScrollPane.getWidth());
                });
              /*  LectureTableView.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newValue) ->{
                        try {
                                selectFromLectureTable();
                        } catch (SQLException e) {
                                throw new RuntimeException(e);
                        } catch (IOException e) {
                                throw new RuntimeException(e);
                        }
                });*/

                openLectureScreen();




        }


        @FXML
        public void openLectureScreen() {
                LecturesHBox.setVisible(true);
                ProjectsHBox.setVisible(false);
                LecturesHBox.setEffect(null);
                AddProjectBox.setVisible(false);
                AddLectureBox.setVisible(false);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(true);
                thirdEllipses.setVisible(false);

                String path = "images/trash.png";
                String path2="images/GO.png";

                Image image = new Image(getClass().getResource(path).toExternalForm());
                Image image2 = new Image(getClass().getResource(path2).toExternalForm());

                ObservableList<TableShow> LectureList = FXCollections
                        .observableArrayList();

                LectureNameColumn.setCellValueFactory(new PropertyValueFactory<TableShow, String>("name"));


                LectureTrashColumn.setCellValueFactory(new PropertyValueFactory<TableShow, ImageView>("image"));

                LectureGoColumn.setCellValueFactory(new PropertyValueFactory<TableShow, ImageView>("image2"));

                // TODO : Database daha yazılmadı ben şimdiden koydum
               /* for (int i = 0; i < DBConnector.getInstance().getLectures().size(); i++) {
                        LectureList.add(new LectureConfig(DBConnector.getInstance().getLectures().get(i),
                                new ImageView(image),new ImageView(image2)));
                }*/

                LectureList.add(new TableShow("ce316",new ImageView(image),new ImageView(image2)));
                LectureList.add(new TableShow("ce326",new ImageView(image),new ImageView(image2)));
                LectureList.add(new TableShow("ce316",new ImageView(image),new ImageView(image2)));
                LectureTableView.setItems(LectureList);

        }


        @FXML
        public void openAddLectureScreen() {
                LecturesHBox.setVisible(true);
                LecturesHBox.setEffect(null);
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


                int LectureIDTEMP = (LectureTableView.getItems().size())+1;
                String SatırsayısıtoString=Integer.toString(LectureIDTEMP);


                Label LectureID = new Label("Lecture ID :");
                AddLectureGrid.add(LectureID, 0, 0);

                Label lectureNameLabel = new Label("Lecture Name:");
                AddLectureGrid.add(lectureNameLabel, 0, 1);

                Label lecturerNameLabel = new Label("Lecturer's Name:");
                AddLectureGrid.add(lecturerNameLabel, 0, 2);



                Label LectureIDtext = new Label(SatırsayısıtoString);
                AddLectureGrid.add(LectureIDtext, 1, 0);

                TextField LectureNameText = new TextField();
                AddLectureGrid.add(LectureNameText, 1, 1);

                TextField LecturersNameText = new TextField();
                AddLectureGrid.add(LecturersNameText, 1, 2);



                AddLectureButton.setOnAction(event -> {
                        String TempName = LectureNameText.getText();
                        String TempLName=LecturersNameText.getText();
                        LectureConfig Lecture = new LectureConfig(LectureIDTEMP,TempName,TempLName);
                        DBConnector.getInstance().addLecture(Lecture);

                        LecturesHBox.setEffect(null);
                        AddLectureBox.setVisible(false);
                        LecturesHBox.setVisible(true);
                        openLectureScreen();

                });

        }


        public void selectFromLectureTable() throws SQLException, IOException {
                if (LectureTableView.getSelectionModel().getSelectedCells() == null ||
                        LectureTableView.getSelectionModel().getSelectedIndex() == -1) {
                        return;
                }

                int index = LectureTableView.getSelectionModel().getSelectedIndex();

                String LectureName = (String) LectureNameColumn.getCellData(index);


                ObservableList<TablePosition> selectedCells = LectureTableView.getSelectionModel().getSelectedCells();



                if (selectedCells.get(0).getTableColumn().equals(LectureTrashColumn)) {
                        //DBConnection.getInstance().deleteTemplate(LectureName);
                        System.out.println(LectureName);
                        openLectureScreen();
                } else if (selectedCells.get(0).getTableColumn().equals(LectureGoColumn)) {
                       // openProjectScreen();

                } else {


                        //LectureConfig Lecture = DBConnector.getInstance().getLecture(LectureName);
                        LectureConfig Lecture = new LectureConfig(0,"CE316","İlkerHoca");
                        ObservableList<Node> children = LectureGrid.getChildren();
                        children.clear();
                        String TempID=Integer.toString(Lecture.getLecture_id());
                        String TempLectureName=Lecture.getLecture_Name();
                        String TempLecturerName=Lecture.getLecturer_Name();

                        Label LectureID = new Label("Lecture ID :");
                        LectureGrid.add(LectureID, 0, 0);

                        Label lectureNameLabel = new Label("Lecture Name:");
                        LectureGrid.add(lectureNameLabel, 0, 1);

                        Label lecturerNameLabel = new Label("Lecturer's Name:");
                        LectureGrid.add(lecturerNameLabel, 0, 2);



                        Label LectureIDtext = new Label(TempID);
                        LectureGrid.add(LectureIDtext, 1, 0);

                        Label LectureNameText = new Label(TempLectureName);
                        LectureGrid.add(LectureNameText, 1, 1);

                        Label LecturersNameText = new Label(TempLecturerName);
                        LectureGrid.add(LecturersNameText, 1, 2);



                }
        }




     /*   @FXML
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


                for (int i = 0; i < DBConnector.getInstance().getProject().size(); i++) {
                        ProjectList.add(new ProjectConfig(DBConnector.getInstance().getProject().get(i),
                                new ImageView(image),new ImageView(image2)));
                }

                ProjectTableView.setItems(ProjectList);
        }
*/






  /*      @FXML
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

                int ProjectIDTEMP = (ProjectTableView.getItems().size())+1;
                String SatırsayısıtoString=Integer.toString(ProjectIDTEMP);


                Label l1 = new Label("Project ID :");
                l1.setStyle("-fx-font-size: 20;");
                Label l2 = new Label(SatırsayısıtoString);
                l2.setStyle("-fx-font-size: 20;");

                AddProjectGrid.addRow(0, l1, l2);

                Label ProjectTitleLabel = new Label("Project Title : ");
                Label ProjectDescriptionLabel = new Label("Project Description : ");
                Label ProjectLectureIDLabel = new Label("Project Lecture ID : ");
                Label ProjectPL_IDLabel = new Label("Programming Language ID: ");
                Label Project_Main_File_Name_FormatLabel = new Label("Main File Name Format : ");
                TextField selectedPL_ID=new TextField();
                TextField selectedProjectTitle = new TextField();
                TextField selectedProjectDescription=new TextField();
                TextField selectedProjectL_ID = new TextField();
                TextField selectedMain_File_Format=new TextField();



                AddProjectGrid.addRow(1,ProjectTitleLabel,selectedPL_ID );
                AddProjectGrid.addRow(2,ProjectDescriptionLabel,selectedProjectTitle);
                AddProjectGrid.addRow(3,ProjectLectureIDLabel,selectedProjectDescription);
                AddProjectGrid.addRow(4,ProjectPL_IDLabel,selectedProjectL_ID);
                AddProjectGrid.addRow(5,Project_Main_File_Name_FormatLabel,selectedMain_File_Format);

                AddAttribute.setOnAction(event -> {
                        Label label = new Label("Arguments: ");
                        TextField textField = new TextField();
                        AddProjectGrid.addRow(AddProjectGrid.getRowCount() + 1, label, textField);
                });

                AddProjectButton.setOnAction(event -> {

                        int TempPL_ID=Integer.parseInt(selectedPL_ID.getText());
                        String Temp_PT =selectedProjectTitle.getText();
                        String TempP_D=selectedProjectDescription.getText();
                        int TempL_ID =Integer.parseInt(selectedProjectL_ID.getText());
                        String TempM_F_F=selectedMain_File_Format.getText();
                        String path = "images/trash.png";
                        ImageView image = new ImageView(getClass().getResource(path).toExternalForm());

                        ProjectConfig Project = new ProjectConfig(ProjectIDTEMP,Temp_PT,TempP_D,TempL_ID,TempPL_ID,TempM_F_F,image);
                        DBConnector.getInstance().addProject(Project);

                        LecturesHBox.setEffect(null);
                        AddLectureBox.setVisible(false);
                        LecturesHBox.setVisible(true);

                });







        }


*/
/*
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
                } else {


                        ProjectConfig Project = DBConnector.getInstance().getProject(ProjectName);



                        ObservableList<Node> children = ProjectGrid.getChildren();
                        children.clear();

                        String TempID=Integer.toString(Project.getId());
                        String TempProjectTitle=Project.getTitle();
                        String TempDescription=Project.getDescription();
                        String TempProjectLectureID=Integer.toString(Project.getLecture_id());
                        String TempPL_ID=Integer.toString(Project.getProgramming_language_id());
                        String TempMainFileFormat=Project.getMain_file_format();
                        
                        Label ProjectIDLabel=new Label("ProjectID: ");
                        Label ProjectTitleLabel = new Label("Project Title : ");
                        Label ProjectDescriptionLabel = new Label("Project Description : ");
                        Label ProjectLectureIDLabel = new Label("Project Lecture ID : ");
                        Label ProjectPL_IDLabel = new Label("Programming Language ID: ");
                        Label Project_Main_File_Name_FormatLabel = new Label("Main File Name Format : ");

                        Label selectedProjectID=new Label(TempID);
                        Label selectedPL_ID=new Label(TempPL_ID);
                        Label selectedProjectTitle = new Label(TempProjectTitle);
                        Label selectedProjectDescription=new Label(TempDescription);
                        Label selectedProjectL_ID = new Label(TempProjectLectureID);
                        Label selectedMain_File_Format=new Label(TempMainFileFormat);

                        ProjectGrid.addRow(0,ProjectIDLabel,selectedProjectID);
                        ProjectGrid.addRow(1,ProjectTitleLabel,selectedProjectTitle);
                        ProjectGrid.addRow(2,ProjectDescriptionLabel,selectedProjectDescription);
                        ProjectGrid.addRow(3,ProjectLectureIDLabel,selectedProjectL_ID);
                        ProjectGrid.addRow(4,ProjectPL_IDLabel,selectedPL_ID);
                        ProjectGrid.addRow(5,Project_Main_File_Name_FormatLabel,selectedMain_File_Format);


                }
        }

*/



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
