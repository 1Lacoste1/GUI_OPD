package com.example.testgui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.*;

import animation.Shake;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class InformationTableController extends RegistrationClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField brand_auto;

    @FXML
    private DatePicker date_issue;

    @FXML
    private DatePicker date_recording;

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

        next.setOnAction(event -> {
            String record = date_recording.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String brand = brand_auto.getText();
            String model_auto = model.getText();
            String date_iss = date_issue.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            String wheel = radius_wheel.getValue();

            if(isNullOrEmmpty(record) || isNullOrEmmpty(brand) || isNullOrEmmpty(model_auto) || isNullOrEmmpty(wheel)
                || isNullOrEmmpty(date_iss)) {
                Shake userRecord = new Shake(date_recording);
                Shake userBrand = new Shake(brand_auto);
                Shake userModel = new Shake(model);
                Shake userDateIssue = new Shake(date_issue);
                Shake userWheel = new Shake(radius_wheel);

                userRecord.playAnim();
                userBrand.playAnim();
                userModel.playAnim();
                userDateIssue.playAnim();
                userWheel.playAnim();
            } else {
                additionalInfo();
                openNewScene("SuccessfulRecording.fxml");
            }
        });
    }

    private boolean isNullOrEmmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public void openNewScene(String correctXml) {
        next.getScene().getWindow().hide();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource(correctXml));

        try {
            loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Parent root = loader.getRoot();
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    private void additionalInfo() {
        DatebaseHandler dbHandler = new DatebaseHandler();

        String record = date_recording.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String brand = brand_auto.getText();
        String model_auto = model.getText();
        String date_iss = date_issue.getValue().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String describe_problem = desc_problem.getText();
        String wheel = radius_wheel.getValue();

        User user = new User(record, brand, model_auto, date_iss, describe_problem, wheel);

        try {
            dbHandler.signUpUser2(user);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}

