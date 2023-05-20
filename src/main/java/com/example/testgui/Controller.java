package com.example.testgui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import animation.Shake;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button sign_in;

    @FXML
    private PasswordField password;

    @FXML
    void initialize() {
            sign_in.setOnAction(event -> {
                if(password.getText().equals("1234")) {
                    openNewScene("Menu.fxml");
                } else {
                    Shake userPassword = new Shake(password);
                    userPassword.playAnim();
                }
            });
        }

        public void openNewScene(String correctXml) {
            sign_in.getScene().getWindow().hide();
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

    }

