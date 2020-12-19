package sample;

import GameLogic.GameManager;
import GameLogic.Land;
import GameLogic.LandableType;
import GameLogic.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    public ImageView landImage;

    @FXML
    public Label landName;


    @FXML
    public Button buyButton;

    @FXML
    public void closeButtonClicked(ActionEvent event) throws Exception {
        System.out.println("close Button clicked. ");
        GameScreen.landPopup.hide();
        AssetManager.gameManager.playTurnPostDice((Land)AssetManager.gameManager.gameScreenController.currentLandable);
    }

    @FXML
    public void buyButtonClicked(ActionEvent event) throws Exception {
        AssetManager.gameManager.executeBuyable(AssetManager.gameManager.gameScreenController.currentLandable, buyButton);
        GameScreen.landPopup.hide();
    }

    @FXML
    public void initialize()
    {
        landName.setText(AssetManager.gameManager.gameScreenController.nameOfLand);
        rent.setText("Rent: " + "₿" + AssetManager.gameManager.gameScreenController.rentPopup);
        rentWithColorSet.setText("Rent with Color Set: " + "₿" +AssetManager.gameManager.gameScreenController.rentColorSetPopup);
        rentWithOneSB.setText("Rent with 1 Starbucks: " + "₿" +AssetManager.gameManager.gameScreenController.rentWithOneSBPopup);
        rentWithTwoSB.setText("Rent with 2 Starbucks: " + "₿" +AssetManager.gameManager.gameScreenController.rentWithTwoSBPopup);
        rentWithThreeSB.setText("Rent with 3 Starbucks: " + "₿" +AssetManager.gameManager.gameScreenController.rentWithThreeSBPopup);
        rentWithBilka.setText("Rent with Bilka: " + "₿" +AssetManager.gameManager.gameScreenController.rentWithBilkaPopup);

        Image image = new Image(AssetManager.gameManager.gameScreenController.imageNamePopup);
        landImage.setImage(image);

        Land curLand = (Land)AssetManager.gameManager.gameScreenController.currentLandable;
        Player curPlayer = AssetManager.gameManager.getCurrentPlayer();

        if (curLand.isBought() && !curPlayer.getOwnedLands().contains(curLand)) {
                buyButton.setText("Pay Rent");
        }
    }
}
