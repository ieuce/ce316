package com.example.ce316_project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;

import javafx.collections.FXCollections;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.layout.*;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;


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
        
        @FXML
        private TableView StudentTableView;
        @FXML
        private TableColumn StudentIDColumn;
        @FXML
        private TableColumn StudentNameColumn;
        @FXML
        private TableColumn StudentGradeColumn;
        @FXML
        private TableColumn StudentGoColumn;


        int lec_id = -1;
        int pl_id = -1;
        int project_id = -1;
        int student_id = -1;

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

                
                for(LectureConfig lecture_config: DBConnector.getInstance().getAllLectureConfigObjects()){
                        LectureList.add(new TableShow(lecture_config.getLecture_id(), lecture_config.getLecture_Name(), new ImageView(image),new ImageView(image2)));// new ImageView(image),new ImageView(image2)));
                }

                LectureTableView.setItems(LectureList);
        }


        @FXML
        public void openAddLectureScreen() throws SQLException {
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

                ObservableList<TableShow> dataList = LectureTableView.getItems();


                Label LectureIDtext = new Label();
                int lecture_id;
// Son elemanın nameColumnundan names değerini al
                if (dataList.size() > 0) { // veriler varsa
                        int lastIndex = dataList.size() - 1;
                        TableColumn<TableShow, String> nameColumn = (TableColumn<TableShow, String>) LectureTableView.getColumns().get(1); // nameColumn sütunu
                        String   lastNamesValue = nameColumn.getCellData(lastIndex); // son elemanın names değeri
                        LectureConfig  lecture = DBConnector.getInstance().getLecture(lastNamesValue);
                        System.out.println(lecture.getLecture_id());
                        lecture_id=(lecture.getLecture_id())+1;

                        LectureIDtext.setText("");
                        LectureIDtext.setText(Integer.toString((lecture.getLecture_id())+1));

                }
                else{
                        lecture_id=LectureIDTEMP;
                        LectureIDtext.setText(SatırsayısıtoString);}


                //LectureIDtext.setText(SatırsayısıtoString);

                AddLectureGrid.add(LectureIDtext, 1, 0);

                TextField LectureNameText = new TextField();
                AddLectureGrid.add(LectureNameText, 1, 1);

                TextField LecturersNameText = new TextField();
                AddLectureGrid.add(LecturersNameText, 1, 2);



                AddLectureButton.setOnAction(event -> {
                        String TempName = LectureNameText.getText();
                        String TempLName=LecturersNameText.getText();
                        LectureConfig Lecture = new LectureConfig(lecture_id,TempName,TempLName);
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
                        LectureConfig Lecture = DBConnector.getInstance().getLecture(LectureName);
                        DBConnector.getInstance().deleteLectureObject(Lecture.getLecture_id());
                        openLectureScreen();
                } else if (selectedCells.get(0).getTableColumn().equals(LectureGoColumn)) {
                        LectureConfig Lecture = DBConnector.getInstance().getLecture(LectureName);
                        openProjectScreen(Lecture.getLecture_id());
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
                lec_id = id;

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
                        ArrayList<ProjectConfig> projectConfigs = DBConnector.getInstance().getAllPConfigObjects();
                        for (ProjectConfig projectConfig : projectConfigs) {
                                if(projectConfig.getLecture_id()==id) {

                                        ProjectList.add(new TableShow(projectConfig.getId(), projectConfig.getTitle(), new ImageView(image), new ImageView(image2)));
                                }
                        }
                }catch (Exception e ){
                        System.out.println("PROJEYİ ALAMADI DATABASE HATA VERDİ");
                }

                ProjectTableView.setItems(ProjectList);
        }


       @FXML
        public void openAddProjectScreen() {
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
                l2.setText(SatırsayısıtoString);




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


               AddProjectGrid.add( l1,0,0 );
               AddProjectGrid.add(l2,1,0);
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
                        
                        ArrayList<Evaluation> evaluations = new ArrayList<>();
                        Evaluation evaluation1 = new Evaluation(1, ProjectIDTEMP, "0", "0");
                        Evaluation evaluation2 = new Evaluation(2, ProjectIDTEMP, "1 2 3", "6");
                        Evaluation evaluation3 = new Evaluation(3, ProjectIDTEMP, "5 6 7", "18");
                        Evaluation evaluation4 = new Evaluation(4, ProjectIDTEMP, "7 8 9", "24");
                        evaluations.add(evaluation1);
                        evaluations.add(evaluation2);
                        evaluations.add(evaluation3);
                        evaluations.add(evaluation4);

                        ProjectConfig Project = new ProjectConfig(ProjectIDTEMP,Temp_PT,TempP_D,TempL_ID,TempPL_ID,TempM_F_F,evaluations);
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
                        ProjectConfig Project = DBConnector.getInstance().getProject(ProjectName);
                        DBConnector.getInstance().deleteProjectObject(Project.getId());
                        System.out.println(ProjectName);
                        openProjectScreen(lec_id);
                } else if (selectedCells.get(0).getTableColumn().equals(ProjectGoColumn)) {
                        ObservableList<TableShow> ts_list = ProjectTableView.getSelectionModel().getSelectedItems();
                        TableShow ts = ts_list.get(0);
                        project_id = ts.getId();
                        openStudentScreen(project_id);

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
                ProgrammingLanguageList.add(new TableShow(plconfig.getId(), plconfig.getName(),
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
        public void openStudentScreen(int id) {
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

                String path="images/GO.png";
                Image image = new Image(getClass().getResource(path).toExternalForm());

                StudentIDColumn.setCellValueFactory(new PropertyValueFactory<GradeTableShow, String>("id"));
                StudentNameColumn.setCellValueFactory(new PropertyValueFactory<GradeTableShow, String>("name"));
                StudentGradeColumn.setCellValueFactory(new PropertyValueFactory<GradeTableShow, String>("grade"));
                StudentGoColumn.setCellValueFactory(new PropertyValueFactory<GradeTableShow, String>("image"));

                ObservableList<GradeTableShow> student_grade_list = FXCollections
                        .observableArrayList();

                ArrayList<Grade> grades = DBConnector.getInstance().getGradesObject(id);
                for (Grade grade : grades) {
                        Student_Table student = DBConnector.getInstance().getStudentObject(grade.getStudent_id());
                        student_grade_list.add(new GradeTableShow(student.getId(), student.getName() ,grade.getGrade(), new ImageView(image)));
                }

                StudentTableView.setItems(student_grade_list);
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

        @FXML
        public void uploadAndRunZIP(){
                ProjectConfig project_config = DBConnector.getInstance().getPConfigObject(project_id);
                int pl_config_id = project_config.getProgramming_language_id();
                PLConfig pl_config = DBConnector.getInstance().getPLConfigObject(pl_config_id);
                DBConnector.getInstance().deleteGradeObject(project_config.getId());

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Projects' ZIP File (projects.zip)");
                File file = fileChooser.showOpenDialog(null);
                if (file != null) {
                        System.out.println(file.getAbsolutePath());
                        String destinationPath = "src/main/resources/student_performances/project-"+String.valueOf(project_config.getId());
                        extractZipFile(file, new File(destinationPath));

                        File directory = new File(destinationPath+"/projects");
                        File[] folders = directory.listFiles(File::isDirectory);
                        if (folders != null) {
                                for (File folder : folders) {
                                        String folderName = folder.getName();
                                        double score = pl_config.executeAndEvaluate(new File(folder.getAbsolutePath()+"/"+project_config.getMain_file_format()), project_config.getEvaluations(), false);
                                        if(Double.isNaN(score)){
                                                score=0;
                                        }
                                        System.out.println("Score for "+folderName+" is "+score);
                                        String[] student_info = folderName.split("_");
                                        String student_name = splitCamelCase(student_info[1]);
                                        Student_Table student = new Student_Table(student_info[0], student_name);
                                        DBConnector.getInstance().addStudent_Table(student);
                                        
                                        Grade grade = new Grade(-1, project_config.getId(), student.getId(), (int) score);
                                        DBConnector.getInstance().addGrade(grade);
                                }
                        }

                        deleteFolderRecursive(destinationPath);
                        openStudentScreen(project_config.getId());
                }
        }

        private String splitCamelCase(String input) {
                Pattern pattern = Pattern.compile("(?<=[a-z])(?=[A-Z])");
                Matcher matcher = pattern.matcher(input);
                String result = matcher.replaceAll(" ");
                return result;
        }

        private void deleteFolderRecursive(String destinationPath){
                try {
                        Path folder = Path.of(destinationPath);
                        Files.walkFileTree(folder, new SimpleFileVisitor<>() {
                                @Override
                                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                                        Files.delete(file);
                                        return FileVisitResult.CONTINUE;
                                }
                
                                @Override
                                public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                                        Files.delete(dir);
                                        return FileVisitResult.CONTINUE;
                                }
                        });
                        
                        System.out.println("Folder removed successfully.");
                } catch (IOException e) {
                        System.out.println("Error removing folder: " + e.getMessage());
                }
        }

        private void extractZipFile(File zipFile, File outputDirectory) {
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
