package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.io.IOException;

public class GameOverController {

    @FXML
    public Label playerName;

    @FXML
    public ImageView playerPawn;

    @FXML
    public void backButtonClicked(ActionEvent event) throws IOException {
        System.out.println("back button clicked");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }
}
