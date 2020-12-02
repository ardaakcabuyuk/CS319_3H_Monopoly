package sample;

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
    private Button okButton1;
    @FXML
    private Button okButton2;
    @FXML
    private Button okButton3;
    @FXML
    private Button okButton4;
    @FXML
     private ComboBox combo1;
    @FXML
     private ComboBox combo2;
    @FXML
     private ComboBox combo3;
    @FXML
     private ComboBox combo4;
    @FXML
    private Button twoPlayersButton;
    @FXML
    private Button threePlayersButton;
    @FXML
    private Button fourPlayersButton;


    @FXML
    public void select1(ActionEvent event) throws Exception {
        System.out.println("selected: "+ combo1.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    public void select2(ActionEvent event) throws Exception {
        System.out.println("selected: "+ combo2.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    public void select3(ActionEvent event) throws Exception {
        System.out.println("selected: "+ combo3.getSelectionModel().getSelectedItem().toString());
    }

    @FXML
    public void select4(ActionEvent event) throws Exception {
        System.out.println("selected: "+ combo4.getSelectionModel().getSelectedItem().toString());
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
    }

    @FXML
    public void okButtonClicked2(ActionEvent event) throws Exception {
        System.out.println("ok Button clicked: "+ name2.getText());
    }

    @FXML
    public void okButtonClicked3(ActionEvent event) throws Exception {
        System.out.println("ok Button clicked: "+ name3.getText());
    }

    @FXML
    public void okButtonClicked4(ActionEvent event) throws Exception {
        System.out.println("ok Button clicked: "+ name4.getText());
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
    }

    @FXML
    public void threePlayersButtonClicked(ActionEvent event) throws Exception {
        System.out.println("3 players selected");
    }

    @FXML
    public void fourPlayersButtonClicked(ActionEvent event) throws Exception {
        System.out.println("4 players selected");
    }


    @FXML
    public void nextButtonClicked(ActionEvent event) throws Exception {
        System.out.println("next Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("pre_game_settings.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }
}
