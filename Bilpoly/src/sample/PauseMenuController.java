package sample;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;
import javafx.stage.*;

import java.io.IOException;

public class PauseMenuController {

    @FXML
    Button backButton;

    @FXML
    Slider musicSlider;

    @FXML
    Slider effectsSlider;

    @FXML
    Label musicLabel;

    @FXML
    Label effectsLabel;

    public static boolean inGame = false;

    @FXML
    public void backButtonClicked(ActionEvent event) throws Exception {
        System.out.println("back Button clicked. ");
        GameScreen.pausePopup.hide();
        AssetManager.gameManager.gameScreenController.enableRollDiceButton();
    }

    @FXML
    public void howToPlayButtonClicked(ActionEvent event) throws Exception {
        System.out.println("how to play Button clicked. ");
        inGame = true;
        FXMLLoader loader = new FXMLLoader(getClass().getResource("how_to_play.fxml"));
        GameScreen.pausePopup.getContent().add((Parent)loader.load());
        GameScreen.pausePopup.show(GameScreen.pausePopup.getOwnerWindow());

    }


    public void initialize() {

        //music slider updates the volume
        musicSlider.setValue(AssetManager.mediaPlayer.getVolume()*100);
        musicLabel.setText("%" + Integer.toString((int)musicSlider.getValue()));
        musicSlider.valueProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                AssetManager.mediaPlayer.setVolume(musicSlider.getValue()/100);
                musicLabel.setText("%" + Integer.toString((int)musicSlider.getValue()));
            }
        });

        effectsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            effectsLabel.setText("%" + Integer.toString((int) newValue.intValue()));


        });

    }

    
}
