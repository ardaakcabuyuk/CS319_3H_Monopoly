package sample;

import GameLogic.GameManager;
import GameLogic.LandableType;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CafePopupController {


    @FXML
    public Label rentWith1;

    @FXML
    public Label rentWith2;

    @FXML
    public Label rentWith3;

    @FXML
    public Label rentWith4;

    @FXML
    public Label cafeName;


    @FXML
    public Button buyButton;

    @FXML
    public void closeButtonClicked(ActionEvent event) throws Exception {
        System.out.println("close Button clicked. ");
        GameScreen.popup.hide();
    }

    @FXML
    public void buyButtonClicked(ActionEvent event) throws Exception {
        System.out.println("buy Button clicked. ");
    }

    @FXML
    public void initialize()
    {
        cafeName.setText(AssetManager.gameManager.gameScreenController.nameOfLand);
        rentWith1.setText("Rent with 1 Cafe: " + "$" +AssetManager.gameManager.gameScreenController.rentWithOneSBPopup);
        rentWith2.setText("Rent with 2 Cafe: " + "$" +AssetManager.gameManager.gameScreenController.rentWithTwoSBPopup);
        rentWith3.setText("Rent with 3 Cafe: " + "$" +AssetManager.gameManager.gameScreenController.rentWithThreeSBPopup);
        rentWith4.setText("Rent with 4 Cafe: " + "$" +AssetManager.gameManager.gameScreenController.rentWithBilkaPopup);

    }

}
