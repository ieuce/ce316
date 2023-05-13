package com.example.ce316_project;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.regex.Pattern;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        private Button SmallLectureButton;

        @FXML
        private Button SmallPLButton;


        @FXML
        private HBox AddLectureBox;

        @FXML
        private HBox StudentsHbox;

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
        private Button StudentOpenZip;
        @FXML
        private Button StudentRun;

        @FXML
        private Button GoToAddProjectButton;

        @FXML
        private Button LectureButton;

        @FXML
        private TableColumn LectureGoColumn;

        @FXML
        private GridPane LectureGrid;
        @FXML
        private GridPane StudentGrid;

        @FXML
        private TableColumn LectureNameColumn;

        @FXML
        private TableView LectureTableView;
        @FXML
        private TableView StudentTableView;

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
        private TableView PLTableView;

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
                StudentsHbox.setVisible(false);

                PL_HBox.setVisible(false);
                AddProjectBox.setVisible(false);
                AddLectureBox.setVisible(false);
                AddPLBox.setVisible(false);

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
                for (int i = 1; i <= DBConnector.getInstance().getAllLectureConfigObjects().size(); i++) {
                        LectureList.add(new TableShow(DBConnector.getInstance().getLectureConfigObject(i).getLecture_Name(),new ImageView(image),new ImageView(image2)));// new ImageView(image),new ImageView(image2)));
                }


                //LectureList.add(new TableShow("ce316",new ImageView(image),new ImageView(image2)));
                //LectureList.add(new TableShow("ce326",new ImageView(image),new ImageView(image2)));
                //LectureList.add(new TableShow("ce316",new ImageView(image),new ImageView(image2)));
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
                        LectureConfig Lecture = DBConnector.getInstance().getLecture(LectureName);
                        int id=Lecture.getLecture_id();
                        openProjectScreen(id);



                } else {


                        LectureConfig Lecture = DBConnector.getInstance().getLecture(LectureName);
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



       int lec_id ;
       @FXML
        public void openProjectScreen(int id) {
                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(true);
                PL_HBox.setVisible(false);
                AddProjectBox.setVisible(false);
                AddPLBox.setVisible(false);
                AddLectureBox.setVisible(false);
                ProjectsHBox.setEffect(null);
                StudentsHbox.setVisible(false);

                firstEllipses.setVisible(true);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(false);
                lec_id=id;

                String path = "images/trash.png";
                String path2="images/GO.png";


                Image image = new Image(getClass().getResource(path).toExternalForm());
                Image image2 = new Image(getClass().getResource(path2).toExternalForm());

                ObservableList<TableShow> ProjectList = FXCollections
                        .observableArrayList();
                ProjectNameColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, String>("name"));
                ProjectTrashColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, ImageView>("image"));
                ProjectGoColumn.setCellValueFactory(new PropertyValueFactory<LectureConfig, ImageView>("image2"));

        try {
                for (int i = 1; i <= DBConnector.getInstance().getAllPConfigObjects().size(); i++) {
                        if(DBConnector.getInstance().getPConfigObject(i).getLecture_id()==id) {

                                ProjectList.add(new TableShow(DBConnector.getInstance().getPConfigObject(i).getTitle(), new ImageView(image), new ImageView(image2)));
                        }
                }
        }catch (Exception e ){
                System.out.println("PROJEYİ ALAMADI DATABASE HATA VERDİ");
        }

                ProjectTableView.setItems(ProjectList);
        }


       @FXML
        public void openAddProjectScreen() {

                System.out.println("Butona basıldı");

                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(true);
                PL_HBox.setVisible(false);
                AddProjectBox.setVisible(true);
                AddLectureBox.setVisible(false);
                AddPLBox.setVisible(false);
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

                Label l2 = new Label(SatırsayısıtoString);


                AddProjectGrid.add( l1,0,0 );
               AddProjectGrid.add(l2,1,0);

                Label ProjectTitleLabel = new Label("Project Title : ");
                Label ProjectDescriptionLabel = new Label("Project Description : ");
                Label ProjectLectureIDLabel = new Label("Project Lecture ID : ");
                Label ProjectPL_IDLabel = new Label("Programming Language ID: ");
                Label Project_Main_File_Name_FormatLabel = new Label("Main File Name Format : ");


                TextField selectedPL_ID=new TextField();
                TextField selectedProjectTitle = new TextField();
                TextField selectedProjectDescription=new TextField();
                TextField selectedProjectL_ID = new TextField(Integer.toString(lec_id));
                TextField selectedMain_File_Format=new TextField();



                AddProjectGrid.add(ProjectTitleLabel,0,1);
                AddProjectGrid.add(ProjectDescriptionLabel,0,2);
                AddProjectGrid.add(ProjectLectureIDLabel,0,3);
                AddProjectGrid.add(ProjectPL_IDLabel,0,4);
                AddProjectGrid.add(Project_Main_File_Name_FormatLabel,0,5);

               AddProjectGrid.add(selectedProjectTitle,1,1);
               AddProjectGrid.add(selectedProjectDescription,1,2);
               AddProjectGrid.add(selectedProjectL_ID,1,3);
               AddProjectGrid.add(selectedPL_ID,1,4);
               AddProjectGrid.add(selectedMain_File_Format,1,5);

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

                        ProjectConfig Project = new ProjectConfig(ProjectIDTEMP,Temp_PT,TempP_D,TempL_ID,TempPL_ID,TempM_F_F);
                        DBConnector.getInstance().addProject(Project);


                        openProjectScreen(lec_id);

                });

        }





        @FXML
        public void selectFromProjectTable() throws SQLException, IOException {

                if (ProjectTableView.getSelectionModel().getSelectedCells() == null ||
                        ProjectTableView.getSelectionModel().getSelectedIndex() == -1) {
                        return;
                }

                int index = ProjectTableView.getSelectionModel().getSelectedIndex();

                String ProjectName = (String) ProjectNameColumn.getCellData(index);
                ObservableList<TablePosition> selectedCells = ProjectTableView.getSelectionModel().getSelectedCells();



                if (selectedCells.get(0).getTableColumn().equals(ProjectTrashColumn)) {
                        //DBConnection.getInstance().deleteTemplate(templateName);
                        System.out.println(ProjectName);
                        // fillTableViews();
                } else if (selectedCells.get(0).getTableColumn().equals(ProjectGoColumn)) {
                        openStudentScreen();

                } else {


                        ProjectConfig Project = DBConnector.getInstance().getPConfigObject(index);



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

                        ProjectGrid.add(ProjectIDLabel,0,0);
                        ProjectGrid.add(ProjectTitleLabel,0,1);
                        ProjectGrid.add(ProjectDescriptionLabel,0,2);
                        ProjectGrid.add(ProjectLectureIDLabel,0,3);
                        ProjectGrid.add(ProjectPL_IDLabel,0,4);
                        ProjectGrid.add(Project_Main_File_Name_FormatLabel,0,5);

                        ProjectGrid.add(selectedProjectID,1,0);
                        ProjectGrid.add(selectedProjectTitle,1,1);
                        ProjectGrid.add(selectedProjectDescription,1,2);
                        ProjectGrid.add(selectedProjectL_ID,1,3);
                        ProjectGrid.add(selectedPL_ID,1,4);
                        ProjectGrid.add(selectedMain_File_Format,1,5);


                }
        }


@FXML
public void openPLScreen() {
        LecturesHBox.setVisible(false);
        ProjectsHBox.setVisible(false);
        PL_HBox.setVisible(true);
        PL_HBox.setEffect(null);
        AddProjectBox.setVisible(false);
        AddLectureBox.setVisible(false);
        AddPLBox.setVisible(false);
        firstEllipses.setVisible(false);
        secondEllipses.setVisible(false);
        thirdEllipses.setVisible(true);
        StudentsHbox.setVisible(false);

        String path = "images/trash.png";
        String path2="images/GO.png";

        Image image = new Image(getClass().getResource(path).toExternalForm());
        Image image2 = new Image(getClass().getResource(path2).toExternalForm());

        ObservableList<TableShow> ProgrammingLanguageList = FXCollections
                .observableArrayList();

        PLNameColumn.setCellValueFactory(new PropertyValueFactory<TableShow, String>("name"));


        PLTrashColumn.setCellValueFactory(new PropertyValueFactory<TableShow, ImageView>("image"));

        PLGoColumn.setCellValueFactory(new PropertyValueFactory<TableShow, ImageView>("image2"));

        // TODO : Database daha yazılmadı ben şimdiden koydum
        ArrayList<PLConfig> plconfigs = DBConnector.getInstance().getAllPLConfigObjects();
        for (PLConfig plconfig : plconfigs) {
                ProgrammingLanguageList.add(new TableShow(plconfig.getName(),
                        new ImageView(image),new ImageView(image2)));
        }


        PLTableView.setItems(ProgrammingLanguageList);

}
        @FXML
        public void openAddProgLangScreen() {

                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(false);
                PL_HBox.setVisible(true);
                AddProjectBox.setVisible(false);
                AddLectureBox.setVisible(false);
                AddPLBox.setVisible(true);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(false);
                BoxBlur blur = new BoxBlur();
                blur.setWidth(10);
                blur.setHeight(10);
                blur.setIterations(3);
                PL_HBox.setEffect(blur);

                int ProgLangIDTEMP = (PLTableView.getItems().size())+1;
                String SatırsayısıtoString=Integer.toString(ProgLangIDTEMP);


                Label l1 = new Label("Programming Language ID :");

                Label l2 = new Label(SatırsayısıtoString);



                Label ProgLangName = new Label("Programming Langugage Name  : ");
                Label ProgLangVersion = new Label("Programming Language Version  : ");
                Label ProgLangNeedCompiler = new Label("Need Compiler  : ");
                Label ProgLangCompileİns = new Label(" Compile İnstructions : ");
                Label ProgLangRunİns = new Label("Run İnstructions  : ");
                Label ProgLangVersionCheck = new Label("Version Check command  : ");
                Label ProgLangVersionExtractPattern = new Label("Version Extract Pattern  : ");

                TextField selectedPL_Name=new TextField();
                TextField selectedPL_Version = new TextField();
                TextField selectedPL_Compiler=new TextField();
                TextField selectedPL_Compileİns = new TextField();
                TextField selectedPL_Runİns=new TextField();
                TextField selectedPL_VersionCheck=new TextField();
                TextField selectedPL_VersionExtractPattern=new TextField();


                AddPLGrid.add(l1,0,0);
                AddPLGrid.add(ProgLangName,0,1);
                AddPLGrid.add(ProgLangVersion,0,2);
                AddPLGrid.add(ProgLangNeedCompiler,0,3);
                AddPLGrid.add(ProgLangCompileİns,0,4);
                AddPLGrid.add(ProgLangRunİns,0,5);
                AddPLGrid.add(ProgLangVersionCheck,0,6);
                AddPLGrid.add(ProgLangVersionExtractPattern,0,7);

                AddPLGrid.add(l2,1,0);
                AddPLGrid.add(selectedPL_Name ,1,1);
                AddPLGrid.add(selectedPL_Version,1,2);
                AddPLGrid.add(selectedPL_Compiler,1,3);
                AddPLGrid.add(selectedPL_Compileİns,1,4);
                AddPLGrid.add(selectedPL_Runİns,1,5);
                AddPLGrid.add(selectedPL_VersionCheck,1,6);
                AddPLGrid.add(selectedPL_VersionExtractPattern,1,7);

                selectedPL_Name.textProperty().addListener((observable, oldValue, newValue) -> {
                        if (Objects.equals(selectedPL_Name.getText(), "Python")){
                                selectedPL_Compiler.setText("false");
                                selectedPL_Compileİns.setText("null");
                                selectedPL_Runİns.setText("python <PARENT_DIRECTORY>/<FILENAME>.py <ARGS>");
                                selectedPL_VersionCheck.setText("python --version");
                                selectedPL_VersionExtractPattern.setText("Python (\\d+\\.\\d+\\.\\d+)");
                        } else if (Objects.equals(selectedPL_Name.getText(), "Java")) {
                                selectedPL_Compiler.setText("true");
                                selectedPL_Compileİns.setText("javac <PARENT_DIRECTORY>/<FILENAME>.java");
                                selectedPL_Runİns.setText("java -classpath <PARENT_DIRECTORY> <FILENAME> <ARGS>");
                                selectedPL_VersionCheck.setText("java --version");
                                selectedPL_VersionExtractPattern.setText("java (\\d+\\.\\d+\\.\\d+\\.\\d+)");

                        }
                });
                AddPLButton.setOnAction(event -> {


                        String TempPL_Name =selectedPL_Name.getText();
                        String TempPL_Version=selectedPL_Version.getText();
                        Boolean TempPL_NeedCompiler =Boolean.parseBoolean(selectedPL_Compiler.getText());
                        String TempPL_Compilerİns=selectedPL_Compileİns.getText();
                        String TempPL_Runİns=selectedPL_Runİns.getText();
                        String TempPL_VersionCheck=selectedPL_VersionCheck.getText();
                        
                        
                        String TempPL_VersionExtractPattern=selectedPL_VersionExtractPattern.getText();
                        Pattern pattern = Pattern.compile(TempPL_VersionExtractPattern);

                      try {
                               PLConfig ProgrammingLanguageConf = new PLConfig(ProgLangIDTEMP,TempPL_Name,TempPL_Version,TempPL_NeedCompiler,TempPL_Compilerİns,TempPL_Runİns,TempPL_VersionCheck,pattern);
                               DBConnector.getInstance().addPL(ProgrammingLanguageConf);
                     } catch (Exception e) {
                               throw new RuntimeException(e);
                        }

                        PL_HBox.setEffect(null);
                        AddPLBox.setVisible(false);
                        PL_HBox.setVisible(true);
                        ObservableList<Node> children = AddPLGrid.getChildren();
                        children.clear();
                        openPLScreen();

                });
        }

        public void selectFromPLTable() throws SQLException, IOException {
                if (PLTableView.getSelectionModel().getSelectedCells() == null ||
                        PLTableView.getSelectionModel().getSelectedIndex() == -1) {
                        return;
                }

                int index = PLTableView.getSelectionModel().getSelectedIndex();

                String ProgrammingLanguageName = (String) PLNameColumn.getCellData(index);


                ObservableList<TablePosition> selectedCells = PLTableView.getSelectionModel().getSelectedCells();



                if (selectedCells.get(0).getTableColumn().equals(PLTrashColumn)) {
                        //DBConnection.getInstance().deleteTemplate(LectureName);
                        System.out.println(ProgrammingLanguageName);
                        //openLectureScreen();
                } else if (selectedCells.get(0).getTableColumn().equals(PLGoColumn)) {

                        // openProjectScreen();

                } else {


                        PLConfig ProgrammingLanguage = DBConnector.getInstance().getPL(ProgrammingLanguageName);
                        ObservableList<Node> children = PLGrid.getChildren();
                        children.clear();
                        String TempID=Integer.toString(ProgrammingLanguage.getId());
                        String TempName=ProgrammingLanguage.getName();
                        String version=ProgrammingLanguage.getVersionString();
                        String needcompiler=Boolean.toString(ProgrammingLanguage.isNeed_compiler());
                        String compileIns = ProgrammingLanguage.getCompileInsString();
                        String RunIns=ProgrammingLanguage.getRunInsString();
                        String versionCheck=ProgrammingLanguage.getVersionCheckCommand();
                        String pattern = ProgrammingLanguage.getVersionExtractPattern().toString();

                        Label l1 = new Label("Programming Language ID :");

                        Label l2 = new Label(TempID);

                        PLGrid.addRow(0, l1, l2);

                        Label ProgLangName = new Label("Programming Langugage Name  : ");
                        Label ProgLangVersion = new Label("Programming Language Version  : ");
                        Label ProgLangNeedCompiler = new Label("Need Compiler  : ");
                        Label ProgLangCompileİns = new Label(" Compile İnstructions : ");
                        Label ProgLangRunİns = new Label("Run İnstructions  : ");
                        Label ProgLangVersionCheck = new Label("Version Check command  : ");
                        Label ProgLangVersionExtractPattern = new Label("Version Extract Pattern  : ");

                        Label selectedPL_Name=new Label(TempName);
                        Label selectedPL_Version = new Label(version);
                        Label selectedPL_Compiler=new Label(needcompiler);
                        Label selectedPL_Compileİns = new Label(compileIns);
                        Label selectedPL_Runİns=new Label(RunIns);
                        Label selectedPL_VersionCheck=new Label(versionCheck);
                        Label selectedPL_VersionExtractPattern=new Label(pattern);



                        PLGrid.addRow(1,ProgLangName,selectedPL_Name );
                        PLGrid.addRow(2,ProgLangVersion,selectedPL_Version);
                        PLGrid.addRow(3,ProgLangNeedCompiler,selectedPL_Compiler);
                        PLGrid.addRow(4,ProgLangCompileİns,selectedPL_Compileİns);
                        PLGrid.addRow(5,ProgLangRunİns,selectedPL_Runİns);
                        PLGrid.addRow(6,ProgLangVersionCheck,selectedPL_VersionCheck);
                        PLGrid.addRow(7,ProgLangVersionExtractPattern,selectedPL_VersionExtractPattern);



                }
        }
        @FXML
        public void openStudentScreen() {
                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(false);
                LecturesHBox.setEffect(null);
                StudentsHbox.setVisible(true);
                PL_HBox.setVisible(false);
                AddProjectBox.setVisible(false);
                AddLectureBox.setVisible(false);
                AddPLBox.setVisible(false);

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
                for (int i = 1; i <= DBConnector.getInstance().getAllLectureConfigObjects().size(); i++) {
                        LectureList.add(new TableShow(DBConnector.getInstance().getLectureConfigObject(i).getLecture_Name(),new ImageView(image),new ImageView(image2)));// new ImageView(image),new ImageView(image2)));
                }


                //LectureList.add(new TableShow("ce316",new ImageView(image),new ImageView(image2)));
                //LectureList.add(new TableShow("ce326",new ImageView(image),new ImageView(image2)));
                //LectureList.add(new TableShow("ce316",new ImageView(image),new ImageView(image2)));
                LectureTableView.setItems(LectureList);



        }
        @FXML
        public void selectFromStudentTable(){}



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
