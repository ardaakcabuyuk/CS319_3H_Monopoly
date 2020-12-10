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

    @FXML
    public void backButtonClicked(ActionEvent event) throws Exception {
        System.out.println("back Button clicked. ");
        Controller.popup.hide();
    }
    
}
