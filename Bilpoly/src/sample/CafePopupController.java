package sample;

import GameLogic.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    public ImageView landImage;


    @FXML
    public Button buyButton;

    @FXML
    public void closeButtonClicked(ActionEvent event) throws Exception {
        System.out.println("close Button clicked. ");
        GameScreen.cafePopup.hide();
        AssetManager.gameManager.playTurnPostDice((Cafe)AssetManager.gameManager.gameScreenController.currentLandable);
        AssetManager.gameManager.gameScreenController.enableRollDiceButton();
    }

    @FXML
    public void buyButtonClicked(ActionEvent event) throws Exception {
        System.out.println("buy Button clicked. ");
        AssetManager.gameManager.executeBuyable(AssetManager.gameManager.gameScreenController.currentLandable, buyButton);
        GameScreen.cafePopup.hide();
        AssetManager.gameManager.gameScreenController.enableRollDiceButton();
    }

    @FXML
    public void initialize()
    {
        cafeName.setText(AssetManager.gameManager.gameScreenController.nameOfLand);
        rentWith1.setText("Rent with 1 Cafe: "  +AssetManager.gameManager.gameScreenController.rentWithOneSBPopup+ "B");
        rentWith2.setText("Rent with 2 Cafe: "  +AssetManager.gameManager.gameScreenController.rentWithTwoSBPopup+ "B");
        rentWith3.setText("Rent with 3 Cafe: "  +AssetManager.gameManager.gameScreenController.rentWithThreeSBPopup+ "B");
        rentWith4.setText("Rent with 4 Cafe: "  +AssetManager.gameManager.gameScreenController.rentWithBilkaPopup+ "B");

        Image image = new Image(AssetManager.gameManager.gameScreenController.imageNamePopup);
        landImage.setImage(image);

        Cafe curCafe = (Cafe)AssetManager.gameManager.gameScreenController.currentLandable;
        Player curPlayer = AssetManager.gameManager.getCurrentPlayer();

        if (curCafe.isBought() && !curPlayer.getOwnedCafes().contains(curCafe)) {
            buyButton.setText("Pay Rent");
        }
        else if (curCafe.isBought() && curPlayer.getOwnedCafes().contains(curCafe)) {
            rentWith1.setText("You own this cafe.");
            rentWith2.setText("");
            rentWith3.setText("");
            rentWith4.setText("");
            buyButton.setText("Cool");
        }

    }

}
