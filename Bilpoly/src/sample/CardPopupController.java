package sample;

import GameLogic.CardPlace;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardPopupController {

    @FXML
    public Label cardType;

    @FXML
    public Label cardText;

    @FXML
    public ImageView cardImage;

    @FXML
    public void initialize()
    {
        cardType.setText(AssetManager.gameManager.gameScreenController.cardStrategy);
        cardText.setText(AssetManager.gameManager.gameScreenController.cardText);


        if(cardType.getText().equals("CHANCE"))
        {
            cardType.setText("CHANCE CARD");
            Image image = new Image("sample/Images/chance.png");
            cardImage.setImage(image);
        }
        else
        {
            cardType.setText("RECTOR'S WHISPER CARD");
            Image image = new Image("sample/Images/avocadoMan.png");
            cardImage.setImage(image);
        }

    }

    @FXML
    public void okayButtonClicked(ActionEvent event) throws Exception {
        System.out.println("okay Button clicked. ");
        GameScreen.cardPopup.hide();
        AssetManager.gameManager.playTurnPostDice(AssetManager.gameManager.gameScreenController.currentLandable);
        AssetManager.gameManager.gameScreenController.enableRollDiceButton();
    }
}
