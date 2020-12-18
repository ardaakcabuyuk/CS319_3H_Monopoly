package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LandPopupController {

    @FXML
    public Label landName;

    @FXML
    public Label rent;

    @FXML
    public Label rentWithProperty;

    @FXML
    public Label buildProperty;

    @FXML
    public Button buyButton;

    @FXML
    public void closeButtonClicked(ActionEvent event) throws Exception {
        System.out.println("close Button clicked. ");
        GameScreen.popup.hide();
    }

}
