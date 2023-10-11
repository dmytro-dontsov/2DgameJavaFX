package com.example.project2dgames;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.*;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ImageView bg1, bg2, player;

    private final int BG_WIDTH = 710;

    private ParallelTransition parallelTransition;

    private static boolean right = false;
    private static boolean left = false;

    private int playerSpeed = 3;

    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long l) {
            if (right)
                player.setLayoutX(player.getLayoutX() - playerSpeed);
            if (left)
                player.setLayoutX(player.getLayoutX() + playerSpeed);
        }
    };

    @FXML
    void initialize() {
        TranslateTransition bgOneTransition = new TranslateTransition(Duration.millis(5000), bg1);
        bgOneTransition.setFromX(0);
        bgOneTransition.setToX(BG_WIDTH * -1);
        bgOneTransition.setInterpolator(Interpolator.LINEAR);

        TranslateTransition bgTwoTransition = new TranslateTransition(Duration.millis(5000), bg2);
        bgTwoTransition.setFromX(0);
        bgTwoTransition.setToX(BG_WIDTH * -1);
        bgTwoTransition.setInterpolator(Interpolator.LINEAR);

        parallelTransition = new ParallelTransition(bgOneTransition, bgTwoTransition);
        parallelTransition.setCycleCount(Animation.INDEFINITE);
        parallelTransition.play();

        timer.start();
    }

}
