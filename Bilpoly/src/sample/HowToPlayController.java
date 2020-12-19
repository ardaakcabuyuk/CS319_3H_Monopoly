package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.Window;

public class HowToPlayController {
    Button backButton = new Button();

    @FXML
    public void backButtonClicked(ActionEvent event) throws Exception {
        if(!(PauseMenuController.inGame)) {
            System.out.println("back Button clicked. ");
            Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
            Stage window = (Stage) (((Node) event.getSource()).getScene().getWindow());
            window.getScene().setRoot(root);
        }
        else
        {
            System.out.println("back Button clicked in pause menu ");
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pause_menu.fxml"));
            GameScreen.pausePopup.getContent().add((Parent)loader.load());
            GameScreen.pausePopup.show(GameScreen.pausePopup.getOwnerWindow());
        }
    }
}
