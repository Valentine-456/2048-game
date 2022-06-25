package com.project.game;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainSceneController {
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
    void onEasyClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-easy.fxml", stage, "easy");
    }

    @FXML
    void onEasyMedClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-easy-medium.fxml", stage, "easy-medium");
    }

    @FXML
    void onMediumClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-medium.fxml", stage, "medium");

    }
    @FXML
    void onMediumHardClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-medium-hard.fxml", stage, "medium-hard");
    }
    @FXML
    void onHardClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-hard.fxml", stage, "hard");
    }

    private void switchScene(String sceneFileName, Stage stage, String title) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource(sceneFileName));
        Scene scene = new Scene(fxmlLoader.load(), 800, 600);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
}