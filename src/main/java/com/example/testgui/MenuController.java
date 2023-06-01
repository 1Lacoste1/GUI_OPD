package com.example.testgui;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class MenuController implements Initializable {
    private static ObservableList<User> userData = FXCollections.observableArrayList();

    @FXML
    private Button remove_all;

    @FXML
    private Button remove_client;

    @FXML
    private TableView<User> table;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<User, String> first_name_column;

    @FXML
    private ImageView iate;

    @FXML
    private ImageView lukoil;

    @FXML
    private TableColumn<User, String> number_phone_column;

    @FXML
    private Button registration_client;

    @FXML
    private TableColumn<User, String> type_service_column;

    @FXML
    public void initialize() {}

    @FXML
    void removeAll(ActionEvent event) {
        for(int i = 0; i < userData.size(); i++) {
            userData.remove(i);
        }
    }

    @FXML
    void removeClient(ActionEvent event) {
        ObservableList<User> allClients, selectedClient;

        allClients = table.getItems();
        selectedClient = table.getSelectionModel().getSelectedItems();

        for(User user : selectedClient) {
            allClients.remove(user);
        }
    }

    private void initData() {
        var clients = UserDAO.getInstance().findAll();
        for (User user : clients) {
            userData.add(new User(
                    user.getNumber_phone(),
                    user.getName(),
                    user.getType_service()
            ));
        }
    }

    public void openNewScene(String correctXml) {
        registration_client.getScene().getWindow().hide();
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
        stage.showAndWait();
    }

    @FXML
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initData();
        User user = userData.get(0);
        // устанавливаем тип и значение которое должно хранится в колонке
        number_phone_column.setCellValueFactory(new PropertyValueFactory<>("number_phone"));
        first_name_column.setCellValueFactory(new PropertyValueFactory<>("name"));
        type_service_column.setCellValueFactory(new PropertyValueFactory<>("type_service"));




        for(User obj : userData) {
//            table.getItems().remove(obj);
            if(!obj.equals(user)) {
                table.setItems(userData);
            }
        }

        registration_client.setOnAction(event -> {
                    openNewScene("ClientInfo.fxml");
                }
        );


        for(User user1 : userData)
        System.out.println(user1);



    }



}
