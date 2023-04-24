package com.example.testgui;

import java.net.URL;
import java.util.*;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class InformationTableController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField brand_auto;

    @FXML
    private DatePicker date_issue;

    @FXML
    private TextField desc_problem;

    @FXML
    private TextField model;

    @FXML
    private Button next;

    @FXML
    private ComboBox<String> radius_wheel;

    @FXML
    void initialize() {
        ObservableList<String> list = FXCollections.observableArrayList("R-13", "R-14", "R-15", "R-16", "R-17", "R-18", "R-19", "R-20", "R-21");
        radius_wheel.setItems(list);



    }

}

