package com.example.testgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationClientController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private CheckBox TO_service;

    @FXML
    private CheckBox brake_system_service;

    @FXML
    private DatePicker date_recording;

    @FXML
    private TextField name;

    @FXML
    private Button next;

    @FXML
    private TextField number_phone;

    @FXML
    private CheckBox suspension_service;

    @FXML
    private CheckBox wheels_service;

    @FXML
    void initialize() {
        next.setOnAction(event -> {
            next.getScene().getWindow().hide();

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Additional_Information.fxml"));

            try {
                loader.load();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            Parent root = loader.getRoot();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.showAndWait();
        });

    }

}
