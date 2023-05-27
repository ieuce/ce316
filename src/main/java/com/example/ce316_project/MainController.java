package com.example.ce316_project;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
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
import javafx.stage.Stage;



import javafx.scene.media.*;


class Config {
        private String type;
        private String config;

        public Config(String type, String config) {
                this.type = type;
                this.config = config;
        }

        public String getType() {
                return type;
        }

        public String getConfig() {
                return config;
        }
}
    
public class MainController {


        @FXML
        private MediaView mediaView;

        @FXML
        private HBox mediaHbox;


        @FXML
        private Button AddAttribute;
        @FXML
        private Button SmallLectureButton;
        @FXML
        private Button SmallPLButton;
        @FXML
        private HBox AddLectureBox;
        @FXML
        private HBox EditLectureHBox;
        @FXML
        private GridPane EditLectureGrid;
        @FXML
        private GridPane ArgumentsProjectGrid;

        @FXML
        private HBox EditProjectHBox;

        @FXML
        private HBox DetailedEvaluationHbox;

        @FXML
        private TableView DetailedEvaluationTable;

        @FXML
        private TableColumn inputColumn;


        @FXML
        private TableColumn poutputColumn;


        @FXML
        private TableColumn EvaluationRunStatus;


        @FXML
        private TableColumn EvaluationRunOutput;

        @FXML
        private HBox EditProgLangHBox;

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
        private Button EditProgLangButton;


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
        private Button EditLectureConfirm;

        @FXML
        private Button EditLectureButton;

        @FXML
        private Button CloseEditLecture;

        @FXML
        private Button CloseEditProgLang;
        @FXML
        private Button EditProgLangConfirm;

        @FXML
        private Label StudentIDLabel;

        @FXML
        private TableColumn LectureGoColumn;

        @FXML
        private GridPane LectureGrid;
        @FXML
        private GridPane StudentGrid;
        @FXML
        private GridPane EditLectureoldvalue;
        @FXML
        private GridPane EditLecturenewvalue;

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
        private GridPane EditProgLangnewvalue;


        @FXML
        private GridPane EditProgLangoldvalue;


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

        private Media media;
        private MediaPlayer mediaPlayer;

        public void initialize() throws SQLException, IOException {
                if(!new File("info.db").exists()){
                        try {
                                mediaHbox.setVisible(true);
                                allHbox.setVisible(false);

                                String file_path = "images/team3.mp4";
                                media = new Media(getClass().getResource(file_path).toExternalForm());
                                mediaPlayer=new MediaPlayer(media);

                                MediaPlayer.Status status = mediaPlayer.getStatus();
                                if (status == MediaPlayer.Status.UNKNOWN) {
                                System.out.println("Media Player trying to play");

                                }

                                mediaView.setMediaPlayer(mediaPlayer);
                                mediaPlayer.play();

                                mediaPlayer.setOnEndOfMedia(() -> {
                                        System.out.println("finished successfully");
                                        
                                        mediaHbox.setVisible(false);
                                        allHbox.setVisible(true);

                                        openLectureScreen();
                                });

                        }
                        catch (Exception e){
                                System.out.println("naneyi yedi");
                                e.printStackTrace();
                        }       
                } else {
                        openLectureScreen();
                }

                firstEllipses.widthProperty().addListener((obs, oldVal, newVal) -> {
                        if (firstEllipses.getWidth() < 1400)
                                shortDrawer();
                        else
                                longDrawer();
                });

                LectureTableView.getSelectionModel().selectedItemProperty().addListener((observable,oldvalue,newValue) ->{
                        try {
                                selectFromLectureTable();
                        } catch (SQLException e) {
                                throw new RuntimeException(e);
                        } catch (IOException e) {
                                throw new RuntimeException(e);
                        }
                });
        }


        @FXML
        public void openLectureScreen() {
                LecturesHBox.setVisible(true);
                ProjectsHBox.setVisible(false);
                LecturesHBox.setEffect(null);
                StudentsHbox.setVisible(false);
                EditProgLangHBox.setVisible(false);
                EditLectureHBox.setVisible(false);

                PL_HBox.setVisible(false);
                AddProjectBox.setVisible(false);
                AddLectureBox.setVisible(false);
                AddPLBox.setVisible(false);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(true);
                thirdEllipses.setVisible(false);
                mediaHbox.setVisible(false);
                DetailedEvaluationHbox.setVisible(false);


                String path = "images/trash.png";
                String path2="images/Go.png";
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
                DetailedEvaluationHbox.setVisible(false);


                int LectureIDTEMP = (LectureTableView.getItems().size())+1;
                String SatırsayısıtoString=Integer.toString(LectureIDTEMP);


                Label LectureID = new Label("Lecture ID :");
                AddLectureGrid.add(LectureID, 0, 0);

                Label lectureNameLabel = new Label("Lecture Name:");
                AddLectureGrid.add(lectureNameLabel, 0, 1);

                Label lecturerNameLabel = new Label("Lecturer's Name:");
                AddLectureGrid.add(lecturerNameLabel, 0, 2);

                ObservableList<TableShow> dataList = LectureTableView.getItems();


                TextField LectureIDtext = new TextField();
                LectureIDtext.setEditable(false);

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
                        ObservableList<TableShow> ts_list = LectureTableView.getSelectionModel().getSelectedItems();
                        TableShow ts = ts_list.get(0);
                        lec_id = ts.getId();
                        LectureConfig Lecture = DBConnector.getInstance().getLectureConfigObject(lec_id);
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
        public void openEditLecture() throws  UnsupportedSelectionException{
                ObservableList<TableShow> ts_list = LectureTableView.getSelectionModel().getSelectedItems();


                try{
                        TableShow ts = ts_list.get(0);}
                catch (Exception e) {
                        AlertUtil.showUnsupportedSelectionLectureAlert();
                        openLectureScreen();
                        throw new UnsupportedSelectionException("Unsupported Selection");




                }

                TableShow ts = ts_list.get(0);
                lec_id = ts.getId();

                LecturesHBox.setVisible(true);
                ProjectsHBox.setVisible(false);
                EditLectureHBox.setVisible(true);
                PL_HBox.setVisible(false);
                AddProjectBox.setVisible(false);
                AddPLBox.setVisible(false);
                AddLectureBox.setVisible(false);
                ProjectsHBox.setEffect(null);
                StudentsHbox.setVisible(false);

                BoxBlur blur = new BoxBlur();
                blur.setWidth(10);
                blur.setHeight(10);
                blur.setIterations(3);
                LecturesHBox.setEffect(blur);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(false);








                LectureConfig Lecture = DBConnector.getInstance().getLectureConfigObject(lec_id);
                String TempID=Integer.toString(Lecture.getLecture_id());
                String TempLectureName=Lecture.getLecture_Name();
                String TempLecturerName=Lecture.getLecturer_Name();

                Label LectureID = new Label("Lecture ID :");
                EditLectureoldvalue.add(LectureID, 0, 0);

                Label lectureNameLabel = new Label("Lecture Name:");
                EditLectureoldvalue.add(lectureNameLabel, 0, 1);

                Label lecturerNameLabel = new Label("Lecturer's Name:");
                EditLectureoldvalue.add(lecturerNameLabel, 0, 2);




                Label LectureIDtext = new Label(TempID);
                EditLectureoldvalue.add(LectureIDtext, 1, 0);

                Label LectureNameText = new Label(TempLectureName);
                EditLectureoldvalue.add(LectureNameText, 1, 1);

                Label LecturersNameText = new Label(TempLecturerName);
                EditLectureoldvalue.add(LecturersNameText, 1, 2);



                Label NewLectureID = new Label("Lecture ID :");
                EditLecturenewvalue.add(NewLectureID, 0, 0);

                Label NewlectureNameLabel = new Label("Lecture Name:");
                EditLecturenewvalue.add(NewlectureNameLabel, 0, 1);

                Label NewlecturerNameLabel = new Label("Lecturer's Name:");
                EditLecturenewvalue.add(NewlecturerNameLabel, 0, 2);




                TextField NewLectureIDtext = new TextField(TempID);
                NewLectureIDtext.setEditable(false);
                EditLecturenewvalue.add(NewLectureIDtext, 1, 0);

                TextField NewLectureNameText = new TextField();
                EditLecturenewvalue.add(NewLectureNameText, 1, 1);

                TextField NewLecturersNameText = new TextField();
                EditLecturenewvalue.add(NewLecturersNameText, 1, 2);


                EditLectureConfirm.setOnAction(event -> {
                        LectureConfig LectureNew = new LectureConfig(lec_id,NewLectureNameText.getText(),NewLecturersNameText.getText());
                        DBConnector.getInstance().updateLecture(LectureNew);

                        EditLectureHBox.setVisible(false);
                        LecturesHBox.setVisible(true);
                        LecturesHBox.setEffect(null);
                        ProjectsHBox.setVisible(false);
                        PL_HBox.setVisible(false);
                        AddProjectBox.setVisible(false);
                        AddPLBox.setVisible(false);
                        AddLectureBox.setVisible(false);
                        ProjectsHBox.setEffect(null);
                        StudentsHbox.setVisible(false);
                        firstEllipses.setVisible(false);
                        secondEllipses.setVisible(true);
                        thirdEllipses.setVisible(false);
                        openLectureScreen();
                });

                CloseEditLecture.setOnAction(event -> {
                        EditLectureHBox.setVisible(false);
                        LecturesHBox.setVisible(true);
                        LecturesHBox.setEffect(null);
                        ProjectsHBox.setVisible(false);
                        PL_HBox.setVisible(false);
                        AddProjectBox.setVisible(false);
                        AddPLBox.setVisible(false);
                        AddLectureBox.setVisible(false);
                        ProjectsHBox.setEffect(null);
                        StudentsHbox.setVisible(false);
                        firstEllipses.setVisible(false);
                        secondEllipses.setVisible(true);
                        thirdEllipses.setVisible(false);
                        openLectureScreen();
                });



        }
        int row=0;

        @FXML
        public void returnToProject(){
                openProjectScreen(lec_id);
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
               DetailedEvaluationHbox.setVisible(false);
                lec_id = id;

                String path = "images/trash.png";
                String path2="images/Go.png";


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
        public void openAddProjectScreen() throws SQLException {
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

                int maxProjectID = DBConnector.getInstance().getMaxProjectIDDB();
                int validProjectID = maxProjectID + 1;
                
                Label l1 = new Label("Project ID :");
                TextField l2 = new TextField();
                l2.setEditable(false);
                l2.setText(Integer.toString(validProjectID));
                       
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

                AddProjectGrid.add(l1,0,0);
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

                ArrayList<TextField> inputs = new ArrayList<>();
                ArrayList<TextField> outputs = new ArrayList<>();

                AddAttribute.setOnAction(event -> {
                        Label label = new Label("Arguments: ");
                        Label label2=new Label("Expected Output");
                        TextField input_text_field = new TextField();
                        TextField output_text_field= new TextField();
                        inputs.add(input_text_field);
                        outputs.add(output_text_field);
                        ArgumentsProjectGrid.addRow(ArgumentsProjectGrid.getRowCount() + 1, label, input_text_field,label2,output_text_field);
                });

                AddProjectButton.setOnAction(event -> {
                        int TempPL_ID=Integer.parseInt(selectedPL_ID.getText());
                        String Temp_PT =selectedProjectTitle.getText();
                        String TempP_D=selectedProjectDescription.getText();
                        int TempL_ID =Integer.parseInt(selectedProjectL_ID.getText());
                        String TempM_F_F=selectedMain_File_Format.getText();
                        ArrayList<Evaluation> evaluations = new ArrayList<>();
                        for(int i=0; i<inputs.size(); i++) {
                                String input_arg = inputs.get(i).getText().trim();
                                String output_arg = outputs.get(i).getText().trim();
                                if(!input_arg.equals("") || !output_arg.equals("")){
                                        Evaluation evaluation = new Evaluation(-1,validProjectID, input_arg, output_arg);
                                        evaluations.add(evaluation);
                                }
                        }
                        ProjectConfig Project = new ProjectConfig(validProjectID, Temp_PT, TempP_D, TempL_ID, TempPL_ID, TempM_F_F, evaluations);
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
                TableShow ts = (TableShow) ProjectTableView.getSelectionModel().getSelectedItems().get(0);
                ProjectConfig Project = DBConnector.getInstance().getPConfigObject(ts.getId());

                if (selectedCells.get(0).getTableColumn().equals(ProjectTrashColumn)) {
                        DBConnector.getInstance().deleteProjectObject(Project.getId());
                        openProjectScreen(lec_id);
                } else if (selectedCells.get(0).getTableColumn().equals(ProjectGoColumn)) {
                        openStudentScreen(Project.getId());
                } else {
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
        DetailedEvaluationHbox.setVisible(false);

        String path = "images/trash.png";
        String path2="images/Go.png";

        Image image = new Image(getClass().getResource(path).toExternalForm());
        Image image2 = new Image(getClass().getResource(path2).toExternalForm());

        ObservableList<TableShow> ProgrammingLanguageList = FXCollections
                .observableArrayList();

        PLNameColumn.setCellValueFactory(new PropertyValueFactory<TableShow, String>("name"));


        PLTrashColumn.setCellValueFactory(new PropertyValueFactory<TableShow, ImageView>("image"));



        // TODO : Database daha yazılmadı ben şimdiden koydum
        ArrayList<PLConfig> plconfigs = DBConnector.getInstance().getAllPLConfigObjects();
        for (PLConfig plconfig : plconfigs) {
                ProgrammingLanguageList.add(new TableShow(plconfig.getId(), plconfig.getName(),
                        new ImageView(image),new ImageView(image2)));
        }


        PLTableView.setItems(ProgrammingLanguageList);

}
        @FXML
        public void openAddProgLangScreen() throws SQLException {

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
                ObservableList<TableShow> dataList = PLTableView.getItems();


                Label l1 = new Label("Programming Language ID :");

                TextField l2 = new TextField();
                l2.setEditable(false);

                int PL_id;
// Son elemanın nameColumnundan names değerini al
                if (dataList.size() > 0) { // veriler varsa
                        int lastIndex = dataList.size() - 1;
                        TableColumn<TableShow, String> nameColumn = (TableColumn<TableShow, String>) PLTableView.getColumns().get(1); // nameColumn sütunu
                        String   lastNamesValue = nameColumn.getCellData(lastIndex); // son elemanın names değeri
                        PLConfig  programminglanguage = DBConnector.getInstance().getPL(lastNamesValue);
                        System.out.println(programminglanguage.getId());
                        PL_id=(programminglanguage.getId())+1;

                        l2.setText("");
                        l2.setText(Integer.toString((programminglanguage.getId())+1));

                }
                else{
                        PL_id=ProgLangIDTEMP;
                        l2.setText(SatırsayısıtoString);}

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
                        String pattern = TempPL_VersionExtractPattern;

                      try {
                               PLConfig ProgrammingLanguageConf = new PLConfig(PL_id,TempPL_Name,TempPL_Version,TempPL_NeedCompiler,TempPL_Compilerİns,TempPL_Runİns,TempPL_VersionCheck,pattern);
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

        @FXML
        public void openImportScreen() {
                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(false);
                PL_HBox.setVisible(false);
                PL_HBox.setEffect(null);
                AddProjectBox.setVisible(false);
                DetailedEvaluationHbox.setVisible(false);

                AddLectureBox.setVisible(false);
                AddPLBox.setVisible(false);
                firstEllipses.setVisible(false);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(true);
                StudentsHbox.setVisible(false);
                DetailedEvaluationHbox.setVisible(false);

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Configuration File");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
                File file = fileChooser.showSaveDialog(null);
                if (file != null) {
                        String filePath = file.getAbsolutePath();

                        try (FileReader reader = new FileReader(filePath)) {
                                Gson gson = new Gson();
                                Type listType = new TypeToken<List<Config>>() {}.getType();
                                List<Config> objectList = gson.fromJson(reader, listType);
                    
                                for (Config obj : objectList) {
                                        switch(obj.getType()){
                                                case "lecture":
                                                        DBConnector.getInstance().addLecture(gson.fromJson(obj.getConfig(), LectureConfig.class));
                                                        break;
                                                case "project":
                                                        DBConnector.getInstance().addProjectwithId(gson.fromJson(obj.getConfig(), ProjectConfig.class));
                                                        break;
                                                case "pl":
                                                        DBConnector.getInstance().addPL(gson.fromJson(obj.getConfig(), PLConfig.class));
                                                        break;
                                        }
                                }

                                System.out.println("Data imported successfully!");
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }

                openLectureScreen();
        }


        @FXML
        public void openExportScreen() {
                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(false);
                PL_HBox.setVisible(false);
                PL_HBox.setEffect(null);
                AddProjectBox.setVisible(false);
                DetailedEvaluationHbox.setVisible(false);

                AddLectureBox.setVisible(false);
                AddPLBox.setVisible(false);
                firstEllipses.setVisible(false);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(true);
                StudentsHbox.setVisible(false);
                
                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                JsonArray jsonArray = new JsonArray();

                ArrayList<LectureConfig> lectures = DBConnector.getInstance().getAllLectureConfigObjects();
                for(LectureConfig lecture : lectures) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("type", "lecture");
                        jsonObject.addProperty("config", gson.toJson(lecture));
                        jsonArray.add(jsonObject);
                }

                ArrayList<ProjectConfig> projects = DBConnector.getInstance().getAllPConfigObjects();
                for(ProjectConfig project : projects) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("type", "project");
                        jsonObject.addProperty("config", gson.toJson(project));
                        jsonArray.add(jsonObject);
                }
                
                ArrayList<PLConfig> programmingLanguages = DBConnector.getInstance().getAllPLConfigObjects();
                for(PLConfig plConfig : programmingLanguages) {
                        JsonObject jsonObject = new JsonObject();
                        jsonObject.addProperty("type", "pl");
                        jsonObject.addProperty("config", gson.toJson(plConfig));
                        jsonArray.add(jsonObject);
                }

                String json = gson.toJson(jsonArray);

                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Save Configuration File");
                fileChooser.setInitialFileName("data.json");
                fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("JSON", "*.json"));
                File file = fileChooser.showSaveDialog(null);
                if (file != null) {
                        String filePath = file.getAbsolutePath();
                        try (FileWriter writer = new FileWriter(filePath)) {
                                writer.write(json);
                                System.out.println("JSON data has been written to the file.");
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                }

                openLectureScreen();
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
                        ObservableList<TableShow> ts_list = PLTableView.getSelectionModel().getSelectedItems();
                        TableShow ts = ts_list.get(0);
                       int temp_id = ts.getId();
                       DBConnector.getInstance().deletePLanguageObject(temp_id);
                        openPLScreen();
                        //openLectureScreen();
                } else if (selectedCells.get(0).getTableColumn().equals(PLGoColumn)) {

                        // openProjectScreen();

                } else {

                        ObservableList<TableShow> ts_list = PLTableView.getSelectionModel().getSelectedItems();
                        TableShow ts = ts_list.get(0);
                        pl_id = ts.getId();

                        PLConfig ProgrammingLanguage = DBConnector.getInstance().getPLConfigObject(pl_id);
                        ObservableList<Node> children = PLGrid.getChildren();
                        children.clear();
                        String TempID=Integer.toString(ProgrammingLanguage.getId());
                        String TempName=ProgrammingLanguage.getName();
                        String version=ProgrammingLanguage.getVersionString();
                        String needcompiler=Boolean.toString(ProgrammingLanguage.isNeed_compiler());
                        String compileIns = ProgrammingLanguage.getCompileInsString();
                        String RunIns=ProgrammingLanguage.getRunInsString();
                        String versionCheck=ProgrammingLanguage.getVersionCheckCommand();
                        String pattern = ProgrammingLanguage.getVersionExtractPattern();

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
        public void openEditProgLang() throws UnsupportedSelectionException {
                ObservableList<TableShow> ts_list = PLTableView.getSelectionModel().getSelectedItems();
                try{
                TableShow ts = ts_list.get(0);}
                catch (Exception e) {
                        AlertUtil.showUnsupportedSelectionAlert();
                        openPLScreen();
                        throw new UnsupportedSelectionException("Unsupported Selection");




                }


                TableShow ts = ts_list.get(0);
                pl_id = ts.getId();

                LecturesHBox.setVisible(false);
                ProjectsHBox.setVisible(false);
                EditLectureHBox.setVisible(false);
                EditProgLangHBox.setVisible(true);
                PL_HBox.setVisible(true);
                AddProjectBox.setVisible(false);
                AddPLBox.setVisible(false);
                AddLectureBox.setVisible(false);
                ProjectsHBox.setEffect(null);
                StudentsHbox.setVisible(false);

                BoxBlur blur = new BoxBlur();
                blur.setWidth(10);
                blur.setHeight(10);
                blur.setIterations(3);
                PL_HBox.setEffect(blur);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(false);



                PLConfig ProgrammingLanguage = DBConnector.getInstance().getPLConfigObject(pl_id);

                String TempID=Integer.toString(ProgrammingLanguage.getId());
                String TempName=ProgrammingLanguage.getName();
                String version=ProgrammingLanguage.getVersionString();
                String needcompiler=Boolean.toString(ProgrammingLanguage.isNeed_compiler());
                String compileIns = ProgrammingLanguage.getCompileInsString();
                String RunIns=ProgrammingLanguage.getRunInsString();
                String versionCheck=ProgrammingLanguage.getVersionCheckCommand();
                String pattern = ProgrammingLanguage.getVersionExtractPattern();

                Label ProgLangID = new Label("Programming Language ID :");
                EditProgLangoldvalue.add(ProgLangID, 0, 0);

                Label ProgLangName= new Label("Programming Langugage Name  : ");
                EditProgLangoldvalue.add(ProgLangName, 0, 1);

                Label ProgLangVersion = new Label("Programming Language Version  : ");
                EditProgLangoldvalue.add(ProgLangVersion, 0, 2);

                Label ProgLangNeedCompiler = new Label("Need Compiler  : ");
                EditProgLangoldvalue.add(ProgLangNeedCompiler, 0, 3);


                Label ProgLangCompileInstructions = new Label(" Compile İnstructions : ");
                EditProgLangoldvalue.add(ProgLangCompileInstructions, 0, 4);


                Label ProgLangRunInstructions = new Label("Run İnstructions  : ");
                EditProgLangoldvalue.add(ProgLangRunInstructions, 0, 5);


                Label ProgLangVersionCheckCommand = new Label("Version Check command  : ");
                EditProgLangoldvalue.add(ProgLangVersionCheckCommand, 0, 6);

                Label ProgLangVersionExtractPattern = new Label("Version Extract Pattern  : ");
                EditProgLangoldvalue.add(ProgLangVersionExtractPattern, 0, 7);





                TextField ProgLangIDText = new TextField(TempID);
                ProgLangIDText.setEditable(false);
                EditProgLangoldvalue.add(ProgLangIDText, 1, 0);

                TextField ProgLangNameText = new TextField(TempName);
                ProgLangNameText.setEditable(false);
                EditProgLangoldvalue.add(ProgLangNameText, 1, 1);

                TextField ProgLangVersionText = new TextField(version);
                ProgLangVersionText.setEditable(false);
                EditProgLangoldvalue.add(ProgLangVersionText, 1, 2);

                TextField ProgLangNeedCompilerText = new TextField(needcompiler);
                ProgLangNeedCompilerText.setEditable(false);
                EditProgLangoldvalue.add(ProgLangNeedCompilerText, 1, 3);

                TextField ProgLangCompileInstructionsText = new TextField(compileIns);
                ProgLangCompileInstructionsText.setEditable(false);
                EditProgLangoldvalue.add(ProgLangCompileInstructionsText, 1, 4);

                TextField ProgLangRunInstructionsText = new TextField(RunIns);
                ProgLangRunInstructionsText.setEditable(false);
                EditProgLangoldvalue.add(ProgLangRunInstructionsText, 1, 5);

                TextField ProgLangVersionCheckCommandText = new TextField(versionCheck);
                ProgLangVersionCheckCommandText.setEditable(false);
                EditProgLangoldvalue.add(ProgLangVersionCheckCommandText, 1, 6);

                TextField ProgLangVersionExtractPatternText = new TextField(pattern);
                ProgLangVersionExtractPatternText.setEditable(false);
                EditProgLangoldvalue.add(ProgLangVersionExtractPatternText, 1, 7);




             /*
                Label l1 = new Label("Programming Language ID :");

                Label l2 = new Label(TempID);

                EditProgLangoldvalue.add(0, l1, l2);
                EditProgLangoldvalue.add(0, l1, l2);

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



                EditProgLangoldvalue.add(ProgLangName,selectedPL_Name );
                EditProgLangoldvalue.add(ProgLangVersion,selectedPL_Version);
                EditProgLangoldvalue.add(ProgLangNeedCompiler,selectedPL_Compiler);
                EditProgLangoldvalue.add(ProgLangCompileİns,selectedPL_Compileİns);
                EditProgLangoldvalue.add(ProgLangRunİns,selectedPL_Runİns);
                EditProgLangoldvalue.add(ProgLangVersionCheck,selectedPL_VersionCheck);
                EditProgLangoldvalue.add(ProgLangVersionExtractPattern,selectedPL_VersionExtractPattern);
                EditProgLangoldvalue.add(ProgLangVersion,selectedPL_Version);
                EditProgLangoldvalue.add(ProgLangNeedCompiler,selectedPL_Compiler);
                EditProgLangoldvalue.add(ProgLangCompileİns,selectedPL_Compileİns);
                EditProgLangoldvalue.add(ProgLangRunİns,selectedPL_Runİns);
                EditProgLangoldvalue.add(ProgLangVersionCheck,selectedPL_VersionCheck);
                EditProgLangoldvalue.add(ProgLangVersionExtractPattern,selectedPL_VersionExtractPattern);


              */


                Label NewProgLangID = new Label("Programming Language ID :");
                EditProgLangnewvalue.add(NewProgLangID, 0, 0);

                Label NewProgLangName= new Label("Programming Langugage Name  : ");
                EditProgLangnewvalue.add(NewProgLangName, 0, 1);

                Label NewProgLangVersion = new Label("Programming Language Version  : ");
                EditProgLangnewvalue.add(NewProgLangVersion, 0, 2);

                Label NewProgLangNeedCompiler = new Label("Need Compiler  : ");
                EditProgLangnewvalue.add(NewProgLangNeedCompiler, 0, 3);


                Label NewProgLangCompileInstructions = new Label(" Compile İnstructions : ");
                EditProgLangnewvalue.add(NewProgLangCompileInstructions, 0, 4);


                Label NewProgLangRunInstructions = new Label("Run İnstructions  : ");
                EditProgLangnewvalue.add(NewProgLangRunInstructions, 0, 5);


                Label NewProgLangVersionCheckCommand = new Label("Version Check command  : ");
                EditProgLangnewvalue.add(NewProgLangVersionCheckCommand, 0, 6);

                Label NewProgLangVersionExtractPattern = new Label("Version Extract Pattern  : ");
                EditProgLangnewvalue.add(NewProgLangVersionExtractPattern, 0, 7);



                TextField NewProgLangIDText = new TextField(TempID);
                NewProgLangIDText.setEditable(false);
                EditProgLangnewvalue.add(NewProgLangIDText, 1, 0);

                TextField NewProgLangNameText = new TextField();
                EditProgLangnewvalue.add(NewProgLangNameText, 1, 1);

                TextField NewProgLangVersionText = new TextField();
                EditProgLangnewvalue.add(NewProgLangVersionText, 1, 2);

                TextField NewProgLangNeedCompilerText = new TextField();
                EditProgLangnewvalue.add(NewProgLangNeedCompilerText, 1, 3);

                TextField NewProgLangCompileInstructionsText = new TextField();
                EditProgLangnewvalue.add(NewProgLangCompileInstructionsText, 1, 4);

                TextField NewProgLangRunInstructionsText = new TextField();
                EditProgLangnewvalue.add(NewProgLangRunInstructionsText, 1, 5);

                TextField NewProgLangVersionCheckCommandText = new TextField();
                EditProgLangnewvalue.add(NewProgLangVersionCheckCommandText, 1, 6);

                TextField NewProgLangVersionExtractPatternText = new TextField(pattern);
                EditProgLangnewvalue.add(NewProgLangVersionExtractPatternText, 1, 7);


                EditProgLangConfirm.setOnAction(event -> {
                        PLConfig PLNew = null;
                        try {
                                PLNew = new PLConfig(pl_id,NewProgLangNameText.getText(),NewProgLangVersionText.getText(),Boolean.parseBoolean(NewProgLangNeedCompilerText.getText()),NewProgLangCompileInstructionsText.getText(),NewProgLangRunInstructionsText.getText(),NewProgLangVersionCheckCommandText.getText(),NewProgLangVersionExtractPatternText.getText());
                        } catch (Exception e) {
                                throw new RuntimeException(e);
                        }
                        DBConnector.getInstance().updatePL(PLNew);

                        EditLectureHBox.setVisible(false);
                        EditProgLangHBox.setVisible(false);
                        LecturesHBox.setVisible(false);
                        LecturesHBox.setEffect(null);
                        ProjectsHBox.setVisible(false);
                        PL_HBox.setVisible(true);
                        AddProjectBox.setVisible(false);
                        AddPLBox.setVisible(false);
                        AddLectureBox.setVisible(false);
                        ProjectsHBox.setEffect(null);
                        StudentsHbox.setVisible(false);
                        firstEllipses.setVisible(false);
                        secondEllipses.setVisible(true);
                        thirdEllipses.setVisible(false);
                        openPLScreen();
                });

                CloseEditProgLang.setOnAction(event -> {
                        EditLectureHBox.setVisible(false);
                        EditProgLangHBox.setVisible(false);
                        LecturesHBox.setVisible(false);
                        LecturesHBox.setEffect(null);
                        ProjectsHBox.setVisible(false);
                        PL_HBox.setVisible(true);
                        AddProjectBox.setVisible(false);
                        AddPLBox.setVisible(false);
                        AddLectureBox.setVisible(false);
                        ProjectsHBox.setEffect(null);
                        StudentsHbox.setVisible(false);
                        firstEllipses.setVisible(false);
                        secondEllipses.setVisible(true);
                        thirdEllipses.setVisible(false);
                        openPLScreen();
                });


        }
        @FXML
        public void openStudentScreen(int id) {
                project_id = id;

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
          
                String path="images/Go.png";
                Image image = new Image(getClass().getResource(path).toExternalForm());

                StudentIDColumn.setCellValueFactory(new PropertyValueFactory<GradeTableShow, String>("id"));
                StudentNameColumn.setCellValueFactory(new PropertyValueFactory<GradeTableShow, String>("name"));
                StudentGradeColumn.setCellValueFactory(new PropertyValueFactory<GradeTableShow, String>("grade"));
                StudentGoColumn.setCellValueFactory(new PropertyValueFactory<GradeTableShow, ImageView>("image"));

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
        public void selectFromStudentTable(){
                if (StudentTableView.getSelectionModel().getSelectedCells() == null ||
                        StudentTableView.getSelectionModel().getSelectedIndex() == -1) {
                        return;
                }

                int index = StudentTableView.getSelectionModel().getSelectedIndex();

                String StudentID = (String) StudentIDColumn.getCellData(index);


                ObservableList<TablePosition> selectedCells = StudentTableView.getSelectionModel().getSelectedCells();




                  if (selectedCells.get(0).getTableColumn().equals(StudentGoColumn)) {

                          Student_Table student = DBConnector.getInstance().getStudentObject(StudentID);
                          openDetailedEvaluation(student.getId());

                }

        }

        @FXML
        public void openDetailedEvaluation(String student_id){
                int detailedprojectid=project_id;
                LecturesHBox.setVisible(false);
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
                DetailedEvaluationHbox.setVisible(true);
                String path="images/success.png";
                Image image = new Image(getClass().getResource(path).toExternalForm());

                String path2="images/cross.png";
                Image image2 = new Image(getClass().getResource(path2).toExternalForm());

                String path3="images/error.png";
                Image image3 = new Image(getClass().getResource(path3).toExternalForm());

                Image image4=null;


               ArrayList<Evaluation> a = DBConnector.getInstance().getEvaluationsObject(detailedprojectid);
               Evaluation FoundEvaluation = null;
               ArrayList<DetailedEvaluation> allDevaluations =DBConnector.getInstance().getAllDevaluation();

                EvaluationRunStatus.setCellValueFactory(new PropertyValueFactory<DetailedEvaluationTableShow, ImageView>("image"));
                inputColumn.setCellValueFactory(new PropertyValueFactory<DetailedEvaluationTableShow, String>("pinput"));
                poutputColumn.setCellValueFactory(new PropertyValueFactory<DetailedEvaluationTableShow, String>("poutput"));

                EvaluationRunOutput.setCellValueFactory(new PropertyValueFactory<DetailedEvaluationTableShow, String>("output"));

                StudentIDLabel.setText("Student ID: "+student_id);
                ObservableList<DetailedEvaluationTableShow> DetailedEvaluation_list = FXCollections.observableArrayList();
                for(DetailedEvaluation detailed: allDevaluations){
                        if(detailed.getStudent_id().equals(student_id)){
                                for(Evaluation eva : a){
                                 if(detailed.getEvaluation_id()==eva.getId()){
                                         FoundEvaluation = eva;
                                 }
                                }
                                switch (detailed.getSuccess_code()){
                                        case 0:image4=image;
                                        break;
                                        case 1:image4=image2;
                                        break;
                                        case 2:image4=image3;
                                        break;
                                }

                                DetailedEvaluation_list.add(new DetailedEvaluationTableShow(
                                        detailed.getStudent_id()
                                        ,FoundEvaluation.getPinput()
                                        ,FoundEvaluation.getPoutput()
                                        , new ImageView(image4)
                                        ,detailed.getOutput()
                                        ));
                        }
                }

                DetailedEvaluationTable.setItems(DetailedEvaluation_list);
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

        @FXML
        public void uploadAndRunZIP(){
                ProjectConfig project_config = DBConnector.getInstance().getPConfigObject(project_id);
                int pl_config_id = project_config.getProgramming_language_id();
                PLConfig pl_config = DBConnector.getInstance().getPLConfigObject(pl_config_id);
                ArrayList<Integer> evaluation_ids = DBConnector.getInstance().getEvalIdsFromProjectId(project_config.getId());
                if(evaluation_ids!=null){
                        for(Integer evaluation_id : evaluation_ids){
                                DBConnector.getInstance().deleteDetailedEvaluationObject(evaluation_id);
                        }
                }
                DBConnector.getInstance().deleteGradeObject(project_config.getId());

                DirectoryChooser directoryChooser = new DirectoryChooser();
                directoryChooser.setTitle("Open Projects' Folder");
                File directory = directoryChooser.showDialog(null);
                if (directory != null) {
                        File[] zipFiles = directory.listFiles((dir, name) -> name.endsWith(".zip"));
                        if(zipFiles != null){
                                for(File zipFile : zipFiles){
                                        String filename = zipFile.getName().replace(".zip", "");
                                        String destinationPath = "src/main/resources/submissions/project-"+String.valueOf(project_config.getId())+"/"+filename;
                                        File folder = new File(destinationPath);

                                        extractZipFile(zipFile, folder);

                                        String folderName = folder.getName();
                                        ArrayList<DetailedEvaluation>detailedEvaluations = new ArrayList<>();

                                        String[] student_info = folderName.split("_");
                                        String student_name = splitCamelCase(student_info[1]);
                                        Student_Table student = new Student_Table(student_info[0], student_name);
                                        DBConnector.getInstance().addStudent_Table(student);
                                        detailedEvaluations = pl_config.executeAndEvaluate(new File(folder.getAbsolutePath()+"/"+filename+"/"+project_config.getMain_file_format()), project_config.getEvaluations(), true,student_info[0]);
                                         for(DetailedEvaluation detailedEva :detailedEvaluations){

                                                 DBConnector.getInstance().addDetailedEvaluation(detailedEva);
                                         }

                                        int successcount=0;
                                        int totalquestions=0;
                                        for (DetailedEvaluation detailedeva:detailedEvaluations){
                                                totalquestions++;
                                                if (detailedeva.getSuccess_code()==0){
                                                        successcount++;

                                                }

                                        }
                                        double score=(double) successcount/totalquestions*100;
                                        if(Double.isNaN(score)){
                                                score=0;
                                        }
                                        System.out.println("Score for "+folderName+" is "+score);


                                        Grade grade = new Grade(-1, project_config.getId(), student.getId(), (int) score);
                                        DBConnector.getInstance().addGrade(grade);

                                        deleteFolderRecursive(destinationPath);
                                }
                        }
                }
                openStudentScreen(project_config.getId());
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

        @FXML
        private void GoHelp() throws IOException {
                Stage stage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("HelpScreen.fxml"));
                Parent root = fxmlLoader.load();
                Scene scene = new Scene(root, 800, 600);
                stage.setTitle("Help");
                stage.setScene(scene);
                stage.setResizable(false);
                stage.showAndWait();
        }
}
