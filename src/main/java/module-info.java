module com.example.testgui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.testgui to javafx.fxml;
    exports com.example.testgui;
}