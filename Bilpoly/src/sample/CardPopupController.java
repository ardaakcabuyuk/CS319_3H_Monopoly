package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class CardPopupController {

    @FXML
    public Label cardType;

    @FXML
    public ImageView cardImage;

    @FXML
    public void initialize()
    {
        cardType.setText(AssetManager.gameManager.gameScreenController.cardStrategy);

        if(cardType.getText().equals("CHANCE"))
        {
            Image image = new Image("sample/Images/taxi.png");
            cardImage.setImage(image);
        }
        else
        {
            Image image = new Image("sample/Images/tmd.png");
            cardImage.setImage(image);
        }

    }
}
