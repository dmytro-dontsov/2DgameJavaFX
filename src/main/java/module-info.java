module com.example.project2dgames {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.project2dgames to javafx.fxml;
    exports com.example.project2dgames;
}