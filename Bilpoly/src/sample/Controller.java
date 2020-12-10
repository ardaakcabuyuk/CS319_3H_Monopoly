package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.*;

public class Controller {

    public static Popup popup = new Popup();

    @FXML
    public void pauseButtonClicked(ActionEvent event) throws Exception {
        System.out.println("pause Button clicked.");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pause_menu.fxml"));
        popup.getContent().add((Parent)loader.load());
        Parent root = FXMLLoader.load(getClass().getResource("game_screen.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        popup.show(window);
    }
}
