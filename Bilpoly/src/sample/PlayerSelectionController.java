package sample;

import GameLogic.*;
import GameLogic.Pawn;
import GameLogic.PawnType;
import GameLogic.Player;
import com.sun.media.jfxmedia.events.PlayerEvent;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.util.*;

import javax.swing.*;
import java.awt.*;

public class PlayerSelectionController {

    @FXML
    private TextField name1;
    @FXML
    private TextField name2;
    @FXML
    private TextField name3;
    @FXML
    private TextField name4;
    @FXML
     private ComboBox combo1;
    @FXML
     private ComboBox combo2;
    @FXML
     private ComboBox combo3;
    @FXML
     private ComboBox combo4;
    @FXML
    private Button nextButton;
    @FXML
    private GridPane player1;
    @FXML
    private GridPane player2;
    @FXML
    private GridPane player3;
    @FXML
    private GridPane player4;
    @FXML
    private Button ok1Button;
    @FXML
    private Button ok2Button;
    @FXML
    private Button ok3Button;
    @FXML
    private Button ok4Button;

    int[] selected = {0, 0 , 0, 0};

    @FXML
    public void inputCheck1(ActionEvent event) throws Exception{
        if ( !(name1.getText().trim().isEmpty() )){
            combo1.setDisable(false);
        }
    }
    @FXML
    public void inputCheck2(ActionEvent event) throws Exception{
        if ( !(name2.getText().trim().isEmpty() )){
            combo2.setDisable(false);
        }
    }
    @FXML
    public void inputCheck3(ActionEvent event) throws Exception{
        if ( !(name3.getText().trim().isEmpty() )){
            combo3.setDisable(false);
        }
    }
    @FXML
    public void inputCheck4(ActionEvent event) throws Exception{
        if ( !(name4.getText().trim().isEmpty() )){
            combo4.setDisable(false);
        }
    }

    @FXML
    public void select1(ActionEvent event) throws Exception {
        System.out.println("selected: "+ combo1.getSelectionModel().getSelectedItem().toString());
        String pawnName = combo1.getSelectionModel().getSelectedItem().toString();
        PawnType pType = null;
        if(pawnName == "Ferrari")
            pType = PawnType.FERRARI;
        else if(pawnName == "TMD")
            pType = PawnType.TMD;
        else if(pawnName == "TAXI")
            pType = PawnType.TAXI;
        else if(pawnName == "BMW")
            pType = PawnType.BMW;
        if(AssetManager.players[0] != null && pType != null){
            AssetManager.players[0].setPawn(new Pawn(pawnName, pType));
            ok1Button.setDisable(false);

            enableNextButton();
        }
    }

    @FXML
    public void select2(ActionEvent event) throws Exception {
        System.out.println("selected: "+ combo2.getSelectionModel().getSelectedItem().toString());
        String pawnName = combo2.getSelectionModel().getSelectedItem().toString();
        PawnType pType = null;
        if(pawnName == "Ferrari")
            pType = PawnType.FERRARI;
        else if(pawnName == "TMD")
            pType = PawnType.TMD;
        else if(pawnName == "TAXI")
            pType = PawnType.TAXI;
        else if(pawnName == "BMW")
            pType = PawnType.BMW;
        if(AssetManager.players[1] != null && pType != null){
            AssetManager.players[1].setPawn(new Pawn(pawnName, pType));

            ok2Button.setDisable(false);
            selected[1] = 2;
            enableNextButton();
        }
    }

    @FXML
    public void select3(ActionEvent event) throws Exception {
        System.out.println("selected: "+ combo3.getSelectionModel().getSelectedItem().toString());
        String pawnName = combo3.getSelectionModel().getSelectedItem().toString();
        PawnType pType = null;
        if(pawnName == "Ferrari")
            pType = PawnType.FERRARI;
        else if(pawnName == "TMD")
            pType = PawnType.TMD;
        else if(pawnName == "TAXI")
            pType = PawnType.TAXI;
        else if(pawnName == "BMW")
            pType = PawnType.BMW;
        if(AssetManager.players[2] != null && pType != null){
            AssetManager.players[2].setPawn(new Pawn(pawnName, pType));
            ok3Button.setDisable(false);
            selected[2] = 1;
            enableNextButton();

        }
    }

    @FXML
    public void select4(ActionEvent event) throws Exception {
        System.out.println("selected: "+ combo4.getSelectionModel().getSelectedItem().toString());
        String pawnName = combo4.getSelectionModel().getSelectedItem().toString();
        PawnType pType = null;
        if(pawnName == "Ferrari")
            pType = PawnType.FERRARI;
        else if(pawnName == "TMD")
            pType = PawnType.TMD;
        else if(pawnName == "TAXI")
            pType = PawnType.TAXI;
        else if(pawnName == "BMW")
            pType = PawnType.BMW;
        if(AssetManager.players[3] != null && pType != null){
            AssetManager.players[3].setPawn(new Pawn(pawnName, pType));
            ok4Button.setDisable(false);
            selected[3] = 1;
            enableNextButton();

        }
    }

    @FXML
    public void initialize()
    {
        ObservableList<String> pawnList = FXCollections.observableArrayList("Ferrari","TMD","TAXI","BMW");
        combo1.setItems(pawnList);
        combo2.setItems(pawnList);
        combo3.setItems(pawnList);
        combo4.setItems(pawnList);

        //nextButton.setDisable(true);
        player1.setDisable(true);
        player2.setDisable(true);
        player3.setDisable(true);
        player4.setDisable(true);

        //ok button
        ok1Button.setDisable(true);
        ok2Button.setDisable(true);
        ok3Button.setDisable(true);
        ok4Button.setDisable(true);

        //combo
        combo1.setDisable(true);
        combo2.setDisable(true);
        combo3.setDisable(true);
        combo4.setDisable(true);
    }



    @FXML
    public void okButtonClicked1(ActionEvent event) throws Exception {

        if(AssetManager.players[0] != null){
            AssetManager.players[0].setName(name1.getText());
            AssetManager.players[0].setColor("red");
        }

        String nameOne = name1.getText();
        System.out.println("name1 : "+ nameOne);
        System.out.println("name1: "+ AssetManager.players[0].getName() );
        selected[0] = 1;

        enableNextButton();

    }

    @FXML
    public void okButtonClicked2(ActionEvent event) throws Exception {
        if(AssetManager.players[1] != null){
            AssetManager.players[1].setName(name2.getText());
            AssetManager.players[1].setColor("purple");
        }

        //checking if it is set or not
        String nameTwo = name2.getText();
        System.out.println("name2: "+ nameTwo);

        System.out.println("name2 checking again: "+ AssetManager.players[1].getName() );

        selected[1] = 1;

        enableNextButton();


    }

    @FXML
    public void okButtonClicked3(ActionEvent event) throws Exception {

        if(AssetManager.players[2] != null){
            AssetManager.players[2].setName(name3.getText());
            AssetManager.players[2].setColor("blue");
            System.out.println("colorrrrr:" + AssetManager.players[2].getColor().toString());
        }

        String nameThree = name3.getText();
        System.out.println("name3: "+ nameThree);

        //checking if it is set or not
        System.out.println("name3 checking again:  "+ AssetManager.players[2].getName() );

        selected[2] = 1;
        //deciding if the next button should be activated after clicking ok
        enableNextButton();

    }

    @FXML
    public void okButtonClicked4(ActionEvent event) throws Exception {
        if(AssetManager.players[3] != null){
            AssetManager.players[3].setName(name4.getText());
            AssetManager.players[3].setColor("green");
            System.out.println("color setted: " + AssetManager.players[3].getColorName());
        }
        String nameFour = name4.getText();
        System.out.println("name4: "+ nameFour);

        selected[3] = 1;
        //checking if it is set or not
        System.out.println("second check name4: "+ AssetManager.players[3].getName() );
        enableNextButton();
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws Exception {
        System.out.println("Back Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    @FXML
    public void twoPlayersButtonClicked(ActionEvent event) throws Exception {
        System.out.println("2 players selected");
        AssetManager.setPlayerNumber(2);

        AssetManager.setPlayers(initializePlayerArray(2));

        player1.setDisable(false);
        player2.setDisable(false);
        player3.setDisable(true);
        player4.setDisable(true);

    }

    @FXML
    public void threePlayersButtonClicked(ActionEvent event) throws Exception {
        System.out.println("3 players selected");
        AssetManager.setPlayerNumber(3);

        AssetManager.setPlayers(initializePlayerArray(3));

        player1.setDisable(false);
        player2.setDisable(false);
        player3.setDisable(false);
        player4.setDisable(true);

    }

    @FXML
    public void fourPlayersButtonClicked(ActionEvent event) throws Exception {
        System.out.println("4 players selected");
        AssetManager.setPlayerNumber(4);

        AssetManager.setPlayers(initializePlayerArray(4));


        player1.setDisable(false);
        player2.setDisable(false);
        player3.setDisable(false);
        player4.setDisable(false);
    }

    @FXML
    public void nextButtonClicked(ActionEvent event) throws Exception {

        System.out.println("next Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("pre_game_settings.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    //initializes an array according to the choosen player number
    //everytime user pushes the player number buttons
    public Player[] initializePlayerArray(int playerCount)
    {
        Player[] playerArray = new Player[playerCount];
        for ( int i = 0; i < playerArray.length; i++) {
            playerArray[i] = new Player();
        }
        return playerArray;
    }

    //enables next button if pawns are decided for each player
    public void enableNextButton() {
        boolean full = true;

        int check = 0;

        for ( int i = 0; i < selected.length; i++ )
        {
            if ( selected[i] == 1)
            {
                check++;
            }
        }

        if ( check == AssetManager.getPlayerNumber() )
        {
            nextButton.setDisable(false);
        }

        /*
        for (int i = 0; i < AssetManager.getPlayerNumber(); i++) {
            System.out.println("AssetManager.players[i].getPawn(): " + AssetManager.players[i].getPawn() + " i: " + i);
            if ( AssetManager.players[i].getPawn() == null ) {
                full = false;
            }
        }

        //if there is no pawns undecided, enable next button
        if ( full ) {
            nextButton.setDisable(false);
        }

         */
    }
}

