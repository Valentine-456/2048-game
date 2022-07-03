module com.project.game {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.project.game to javafx.fxml;
    exports com.project.game;
    exports com.project.game.gameLogic;
    opens com.project.game.gameLogic to javafx.fxml;
}