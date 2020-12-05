package sample;

import GameLogic.*;
import GameLogic.Pawn;
import GameLogic.PawnType;
import GameLogic.Player;
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
import javafx.stage.Stage;

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
    }


    @FXML
    public void okButtonClicked1(ActionEvent event) throws Exception {
        System.out.println("ok Button clicked: "+ name1.getText());
        if(AssetManager.players[0] != null){
            AssetManager.players[0].setName(name1.getText());
            AssetManager.players[0].setColor(Color.BLUE);
        }
    }

    @FXML
    public void okButtonClicked2(ActionEvent event) throws Exception {
        System.out.println("ok Button clicked: "+ name2.getText());
        if(AssetManager.players[1] != null){
            AssetManager.players[1].setName(name2.getText());
            AssetManager.players[1].setColor(Color.ORANGE);
        }
    }

    @FXML
    public void okButtonClicked3(ActionEvent event) throws Exception {
        System.out.println("ok Button clicked: "+ name3.getText());
        if(AssetManager.players[2] != null){
            AssetManager.players[2].setName(name3.getText());
            AssetManager.players[2].setColor(Color.PINK);
        }
    }

    @FXML
    public void okButtonClicked4(ActionEvent event) throws Exception {
        System.out.println("ok Button clicked: "+ name4.getText());
        if(AssetManager.players[3] != null){
            AssetManager.players[3].setName(name4.getText());
            AssetManager.players[3].setColor(Color.GREEN);
        }
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws Exception {
        System.out.println("back Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    @FXML
    public void twoPlayersButtonClicked(ActionEvent event) throws Exception {
        System.out.println("2 players selected");
        AssetManager.setPlayerNumber(2);
        AssetManager.setPlayers(new Player[2]);
    }

    @FXML
    public void threePlayersButtonClicked(ActionEvent event) throws Exception {
        System.out.println("3 players selected");
        AssetManager.setPlayerNumber(3);
        AssetManager.setPlayers(new Player[3]);
    }

    @FXML
    public void fourPlayersButtonClicked(ActionEvent event) throws Exception {
        System.out.println("4 players selected");
        AssetManager.setPlayerNumber(4);
        AssetManager.setPlayers(new Player[4]);
    }


    @FXML
    public void nextButtonClicked(ActionEvent event) throws Exception {
        System.out.println("next Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("pre_game_settings.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }
}
