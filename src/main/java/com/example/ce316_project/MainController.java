package com.example.ce316_project;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.net.URISyntaxException;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import javax.imageio.ImageIO;

import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.transform.Scale;

import java.awt.Desktop;
import org.apache.lucene.queryparser.classic.ParseException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;
import org.apache.pdfbox.text.PDFTextStripper;
import org.controlsfx.control.CheckListView;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.print.PageLayout;
import javafx.print.PageOrientation;
import javafx.print.Paper;
import javafx.print.Printer;
import javafx.print.PrinterJob;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.skin.TableHeaderRow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.stage.FileChooser;
import javafx.scene.effect.*;
import javafx.stage.Stage;

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
        private HBox resumeHBox, searchHBox, templateHBox;
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
        private GridPane templateList;
        @FXML
        private VBox templateNameVBox;
        @FXML
        private GridPane generateResume;
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
                        generateResume.setPrefWidth(generatedResumeScrollPane.getWidth());
                });
        }

        @FXML
        public void openSearchScreen() {
                resumeHBox.setVisible(false);
                searchHBox.setVisible(true);
                templateHBox.setVisible(false);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(true);
                thirdEllipses.setVisible(false);
        }

        @FXML
        public void openResumeScreen() {
                resumeHBox.setVisible(true);
                searchHBox.setVisible(false);
                templateHBox.setVisible(false);

                firstEllipses.setVisible(true);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(false);
        }

        @FXML
        public void openTemplateScreen() {
                resumeHBox.setVisible(false);
                searchHBox.setVisible(false);
                templateHBox.setVisible(true);

                firstEllipses.setVisible(false);
                secondEllipses.setVisible(false);
                thirdEllipses.setVisible(true);

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
