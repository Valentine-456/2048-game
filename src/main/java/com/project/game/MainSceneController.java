package com.project.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {
    private Stage stage;

    @FXML
    private Button hard;

    @FXML
    private Button easy;

    @FXML
    private Button easyMedium;

    @FXML
    private Button medium;

    @FXML
    private Button mediumHard;

    @FXML
    private void onLevelButtonClicked(ActionEvent event) throws IOException {
        if (easy.isPressed()) {
            switchScene("level-easy.fxml");
        } else if (easyMedium.isPressed()) {
            switchScene("level-easy-medium.fxml");
        } else if (medium.isPressed()) {
            switchScene("level-medium.fxml");
        } else if (mediumHard.isPressed()) {
            switchScene("level-medium-hard.fxml");
        } else if (hard.isPressed()) {
            switchScene("level-hard.fxml");
        }
    }

    private void switchScene(String sceneFileName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource(sceneFileName));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage = GameApplication.getStage();
        stage.setTitle("");
        stage.setScene(scene);
        stage.show();
    }
}