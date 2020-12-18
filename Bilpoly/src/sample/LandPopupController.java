package sample;

import GameLogic.GameManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LandPopupController {


    @FXML
    public Label rent;

    @FXML
    public Label rentWithColorSet;

    @FXML
    public Label rentWithOneSB;

    @FXML
    public Label rentWithTwoSB;

    @FXML
    public Label rentWithThreeSB;

    @FXML
    public Label rentWithBilka;

    @FXML
    public Label buildStarbucks;

    @FXML
    public Label buildBilka;

    @FXML
    public Label landName;


    @FXML
    public Button buyButton;

    @FXML
    public void closeButtonClicked(ActionEvent event) throws Exception {
        System.out.println("close Button clicked. ");
        GameScreen.popup.hide();
    }

    @FXML
    public void initialize()
    {
        landName.setText(AssetManager.gameManager.gameScreenController.nameOfLand);
        rent.setText(AssetManager.gameManager.gameScreenController.rentPopup);
        rentWithColorSet.setText(AssetManager.gameManager.gameScreenController.rentColorSetPopup);
        rentWithOneSB.setText(AssetManager.gameManager.gameScreenController.rentWithOneSBPopup);
        rentWithTwoSB.setText(AssetManager.gameManager.gameScreenController.rentWithTwoSBPopup);
        rentWithThreeSB.setText(AssetManager.gameManager.gameScreenController.rentWithThreeSBPopup);
        rentWithBilka.setText(AssetManager.gameManager.gameScreenController.rentWithBilkaPopup);

    }

}
