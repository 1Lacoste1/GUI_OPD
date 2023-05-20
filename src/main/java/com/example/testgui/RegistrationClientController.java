package com.example.testgui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class RegistrationClientController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    protected CheckBox TO_service;

    @FXML
    protected CheckBox brake_system_service;

    @FXML
    protected TextField name;

    @FXML
    private Button next;

    @FXML
    protected TextField number_phone;

    @FXML
    protected CheckBox suspension_service;

    @FXML
    protected CheckBox wheels_service;

    @FXML
    void initialize() {
        next.setOnAction(event -> {
            String name_client = name.getText();
            String num_mob = number_phone.getText();
            if(isNullOrEmmpty(name_client) || isNullOrEmmpty(num_mob)) {
                Shake userName = new Shake(name);
                Shake userNumMob = new Shake(number_phone);
                userName.playAnim();
                userNumMob.playAnim();
            } else {
                registrationClient();
                openNewScene("Additional_Information.fxml");
            }
        });
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

    private boolean isNullOrEmmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public void registrationClient() {
        DatebaseHandler dbHandler = new DatebaseHandler();

        String nameClient = name.getText();
        String phone_num = number_phone.getText();
        String type_service = "";
        String brake_sys_service = "Ремонт тормозной системы. ";
        String TO = "ТО. ";
        String wheel_serv = "Шиномонтаж. ";
        String suspen_serv = "Ремонт подвески. ";

        if (brake_system_service.isSelected()) {
            type_service += brake_sys_service;
        }

        if (wheels_service.isSelected()) {
            type_service += wheel_serv;
        }

        if (TO_service.isSelected()) {
            type_service += TO;
        }

        if (suspension_service.isSelected()) {
            type_service += suspen_serv;
        }

        User user2 = new User(phone_num, nameClient, type_service);

        try {
            dbHandler.signUpUser1(user2);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
