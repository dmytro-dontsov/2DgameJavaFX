package com.example.project2dgames;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 710, 399);
        stage.setScene(scene);

        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.A)
                HelloController.left = true;

            if (e.getCode() == KeyCode.D)
                HelloController.right = true;
        });

        scene.setOnKeyReleased(e -> {
            if (e.getCode() == KeyCode.A)
                HelloController.left = false;

            if (e.getCode() == KeyCode.D)
                HelloController.right = false;
        });

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}