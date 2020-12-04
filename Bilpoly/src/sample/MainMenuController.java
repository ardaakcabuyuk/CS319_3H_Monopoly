package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    Button playButton = new Button();
    Button howToPlayButton = new Button();
    Button optionsButton = new Button();
    Button creditsButton = new Button();
    Button quitButton = new Button();


    //TODO change scene -- going directly to play game scree for now
    @FXML
    public void playButtonClicked(ActionEvent event) throws Exception {
        System.out.println("play Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("player_selection.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    //TODO change scene
    public void howToPlayButtonClicked(ActionEvent event) throws Exception {
        System.out.println("options Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("how_to_play.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    //TODO change scene
    public void optionsButtonClicked(ActionEvent event) throws Exception {
        System.out.println("options Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("options.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    //TODO change scene
    public void creditsButtonClicked(ActionEvent event) throws Exception {
        System.out.println("credits Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("credits.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    //TODO quit the game ----maybe a confirmbox to ask user
    public void quitButtonClicked(){
        System.out.println("quit Button clicked. ");
        System.exit(0);
    }

}
