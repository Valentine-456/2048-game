package com.project.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
    private Button backButton;

    @FXML
    private void getBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchToMainScene(stage);
    }

    @FXML
    private void onEasyClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-easy.fxml", stage, "easy", 640);
    }

    @FXML
    private void onEasyMedClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-easy-medium.fxml", stage, "easy-medium", 610);
    }

    @FXML
    private void onMediumClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-medium.fxml", stage, "medium", 610);
    }

    @FXML
    private void onMediumHardClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-medium-hard.fxml", stage, "medium-hard", 610);
    }

    @FXML
    private void onHardClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchScene("level-hard.fxml", stage, "hard", 610);
    }

    private void switchScene(String sceneFileName, Stage stage, String title, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource(sceneFileName));
        Scene scene = new Scene(fxmlLoader.load(), 650, height);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }

    private void switchToMainScene(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();
    }

}