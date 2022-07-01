package com.project.game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    // --------------------- Game logic -------------

    private GameLogic gameSession;

    // --------------------- Main scene methods-------------

    @FXML
    private void getBack(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        switchToMainScene(stage);
        this.gameSession = null;
    }

    @FXML
    private void onEasyClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.gameSession = new GameLogic(8);
        switchScene("level-easy.fxml", stage, "easy", 640);
    }

    @FXML
    private void onEasyMedClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.gameSession = new GameLogic(6);
        switchScene("level-easy-medium.fxml", stage, "easy-medium", 610);
    }

    @FXML
    private void onMediumClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.gameSession = new GameLogic(5);
        switchScene("level-medium.fxml", stage, "medium", 610);
    }

    @FXML
    private void onMediumHardClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.gameSession = new GameLogic(4);
        switchScene("level-medium-hard.fxml", stage, "medium-hard", 610);
    }

    @FXML
    private void onHardClicked(MouseEvent event) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        this.gameSession = new GameLogic(3);
        switchScene("level-hard.fxml", stage, "hard", 610);
    }

    private void switchScene(String sceneFileName, Stage stage, String title, int height) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource(sceneFileName));
        Scene scene = new Scene(fxmlLoader.load(), 650, height);
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();

        this.gameSession.initGame();
        Tile[][] matrix = this.gameSession.getRenderMatrix();
        this.renderGameChanges(matrix, scene);
    }

    private void switchToMainScene(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(GameApplication.class.getResource("main-screen.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 450);
        stage.setTitle("2048");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void renderGameChanges(Tile[][] matrix, Scene scene) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                Button btn = (Button) scene.lookup(String.format("#tile_%d_%d", i, j));
                btn.getStyleClass().clear();
                btn.getStyleClass().add("game-cell");

                if (matrix[i][j] != null) {
                    int currentTileValue = matrix[i][j].getValue();
                    btn.getStyleClass().add(String.format("cell-%d", currentTileValue));
                }
            }
        }
    }
}