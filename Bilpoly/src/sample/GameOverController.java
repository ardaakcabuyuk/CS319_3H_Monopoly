package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import javafx.event.ActionEvent;
import java.io.IOException;

public class GameOverController {

    @FXML
    public Label playerName;

    @FXML
    public ImageView playerPawn;

    GameScreen gameScreen;

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        System.out.println("back button clicked");
        GameScreen.gameOverPopup.hide();
        changeGameScene();
    }

    public void changeGameScene() throws IOException {
        Parent root1 = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage gameWindow = (Stage) (AssetManager.gameManager.gameScreenController.boardAnchorPane.getScene().getWindow());

        gameWindow.getScene().setRoot(root1);

    }
}
