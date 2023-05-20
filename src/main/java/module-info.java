module com.example.testgui {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.testgui to javafx.fxml;
    exports com.example.testgui;
}