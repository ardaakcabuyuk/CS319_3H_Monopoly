package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import java.io.IOException;

public class PauseMenuController {

    @FXML
    Button backButton;

    public static boolean inGame = false;

    @FXML
    public void backButtonClicked(ActionEvent event) throws Exception {
        System.out.println("back Button clicked. ");
        GameScreen.popup.hide();
    }

    @FXML
    public void howToPlayButtonClicked(ActionEvent event) throws Exception {
        System.out.println("how to play Button clicked. ");
        inGame = true;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("how_to_play.fxml"));
        GameScreen.popup.getContent().add((Parent)loader.load());
        GameScreen.popup.show(GameScreen.popup.getOwnerWindow());

    }

    @FXML
    public void MainMenuButtonClicked(ActionEvent event) throws Exception {
   
    }
    
}
