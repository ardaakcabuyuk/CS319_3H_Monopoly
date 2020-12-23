package ApplicationControl;

import GameLogic.Land;
import GameLogic.LandableType;
import GameLogic.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

public class LandPopupController {

    @FXML
    public Label rent1;

    @FXML
    public Label rentWithColorSet1;

    @FXML
    public Label rentWithOneSB1;

    @FXML
    public Label rentWithTwoSB1;

    @FXML
    public Label rentWithThreeSB1;

    @FXML
    public Label rentWithBilka1;

    @FXML
    public Label buildStarbucks1;

    @FXML
    public Label buildBilka1;

    @FXML
    public ImageView landImage1;

    @FXML
    public Label landName1;


    @FXML
    public Label rent11;

    @FXML
    public Label rentWithColorSet11;

    @FXML
    public Label rentWithOneSB11;

    @FXML
    public Label rentWithTwoSB11;

    @FXML
    public Label rentWithThreeSB11;

    @FXML
    public Label rentWithBilka11;

    @FXML
    public Label buildStarbucks11;

    @FXML
    public Label buildBilka11;

    @FXML
    public ImageView landImage11;

    @FXML
    public Label landName11;

    //third panel
    @FXML
    public Label rent111;

    @FXML
    public Label rentWithColorSet111;

    @FXML
    public Label rentWithOneSB111;

    @FXML
    public Label rentWithTwoSB111;

    @FXML
    public Label rentWithThreeSB111;

    @FXML
    public Label rentWithBilka111;

    @FXML
    public Label buildStarbucks111;

    @FXML
    public Label buildBilka111;

    @FXML
    public ImageView landImage111;

    @FXML
    public Label landName111;


    @FXML
    public Button buyButton;

    @FXML
    public Button closeButton;

    @FXML
    public VBox p1;

    @FXML
    public VBox p2;

    @FXML
    public VBox p3;

    @FXML
    public Button p1s1Button;

    @FXML
    public Button p1s2Button;

    @FXML
    public Button p1s3Button;


    @FXML
    public Button p2s1Button;

    @FXML
    public Button p2s2Button;

    @FXML
    public Button p2s3Button;

    @FXML
    public Button p3s1Button;

    @FXML
    public Button p3s2Button;

    @FXML
    public Button p3s3Button;

    @FXML
    public Button p1BilkaButton;

    @FXML
    public Button p2BilkaButton;

    @FXML
    public Button p3BilkaButton;

    @FXML
    public void closeButtonClicked(ActionEvent event) throws Exception {
        System.out.println("close Button clicked. ");
        GameScreen.landPopup.hide();
        AssetManager.gameManager.playTurnPostDice((Land) AssetManager.gameManager.gameScreenController.currentLandable);
        AssetManager.gameManager.gameScreenController.enableRollDiceButton();
    }

    @FXML
    public void buyButtonClicked(ActionEvent event) throws Exception {
        AssetManager.gameManager.executeBuyable(AssetManager.gameManager.gameScreenController.currentLandable, buyButton);
        GameScreen.landPopup.hide();
        AssetManager.gameManager.gameScreenController.enableRollDiceButton();
    }

    @FXML
    public void initialize() {
        landName11.setText(AssetManager.gameManager.gameScreenController.nameOfLand);
        rent11.setText("Rent: " + AssetManager.gameManager.gameScreenController.rentPopup + "B");
        rentWithColorSet11.setText("Rent with Color Set: " + AssetManager.gameManager.gameScreenController.rentColorSetPopup + "B");
        rentWithOneSB11.setText("Rent with 1 Starbucks: " + AssetManager.gameManager.gameScreenController.rentWithOneSBPopup + "B");
        rentWithTwoSB11.setText("Rent with 2 Starbucks: " + AssetManager.gameManager.gameScreenController.rentWithTwoSBPopup + "B");
        rentWithThreeSB11.setText("Rent with 3 Starbucks: " + AssetManager.gameManager.gameScreenController.rentWithThreeSBPopup + "B");
        rentWithBilka11.setText("Rent with Bilka: " + AssetManager.gameManager.gameScreenController.rentWithBilkaPopup + "B");
        buildStarbucks11.setText("Build Starbucks: " + AssetManager.gameManager.gameScreenController.buildStarbucksPopup + "B");
        buildBilka11.setText("Build Bilka: " + AssetManager.gameManager.gameScreenController.buildBilkaPopup + "B");

        Image image = new Image(AssetManager.gameManager.gameScreenController.imageNamePopup);
        landImage11.setImage(image);

        Land curLand = (Land) AssetManager.gameManager.gameScreenController.currentLandable;
        Player curPlayer = AssetManager.gameManager.getCurrentPlayer();

        p2s1Button.setVisible(false);
        p2s2Button.setVisible(false);
        p2s3Button.setVisible(false);
        p2BilkaButton.setVisible(false);

        if (curLand.isBought() && !curPlayer.getOwnedLands().contains(curLand)) {
            buyButton.setText("Pay Rent");
            closeButton.setDisable(true);

        }
        else if (curLand.isBought() && curPlayer.isBoughtSet(curLand.getCOLOR()))
        {
                Land[] lands = new Land[2];

                int j = 0;

                for (int i = 0; i < AssetManager.gameManager.getLandableList().length; i++) {
                    if (((AssetManager.gameManager.getLandableList())[i]).getType() == LandableType.LAND) {
                        if (((Land) ((AssetManager.gameManager.getLandableList())[i])).getCOLOR() == curLand.getCOLOR() && ((Land) ((AssetManager.gameManager.getLandableList())[i])).getName() != curLand.getName()) {
                            lands[j] = ((Land) ((AssetManager.gameManager.getLandableList())[i]));
                            j++;
                        }
                    }
                }

                p2s1Button.setVisible(true);
                p2s2Button.setVisible(true);
                p2s3Button.setVisible(true);
                p2BilkaButton.setVisible(true);
                buyButton.setVisible(false);

                //initialize panes
                p1.setVisible(true);

                landName1.setText(lands[0].getName());
                rent1.setText("Rent: " + String.valueOf(lands[0].getRENT()) + "B");
                rentWithColorSet1.setText("Rent with Color Set: " + String.valueOf(lands[0].getRENT_WITH_SET()) + "B");
                rentWithOneSB1.setText("Rent with 1 Starbucks: " + String.valueOf(lands[0].getRENT_WITH_1_SECONDARY()) + "B");
                rentWithTwoSB1.setText("Rent with 2 Starbucks: " + String.valueOf(lands[0].getRENT_WITH_2_SECONDARY()) + "B");
                rentWithThreeSB1.setText("Rent with 3 Starbucks: " + lands[0].getRENT_WITH_3_SECONDARY() + "B");
                rentWithBilka1.setText("Rent with Bilka: " + lands[0].getRENT_WITH_PRIMARY() + "B");
                buildStarbucks1.setText("Build Starbucks: " + lands[0].getSECONDARY_COST() + "B");
                buildBilka1.setText("Build Bilka: " + lands[0].getPRIMARY_COST() + "B");

                String imageName1 = "ApplicationControl/Images/buildings_all_png/" + lands[0].getName()+ ".png";
                Image image1 = new Image(imageName1);
                landImage1.setImage(image1);


                if (j > 1) {
                    p3.setVisible(true);

                    landName111.setText(lands[1].getName());
                    rent111.setText("Rent: " + String.valueOf(lands[1].getRENT()) + "B");
                    rentWithColorSet111.setText("Rent with Color Set: " + String.valueOf(lands[1].getRENT_WITH_SET()) + "B");
                    rentWithOneSB111.setText("Rent with 1 Starbucks: " + String.valueOf(lands[1].getRENT_WITH_1_SECONDARY()) + "B");
                    rentWithTwoSB111.setText("Rent with 2 Starbucks: " + String.valueOf(lands[1].getRENT_WITH_2_SECONDARY()) + "B");
                    rentWithThreeSB111.setText("Rent with 3 Starbucks: " + lands[1].getRENT_WITH_3_SECONDARY() + "B");
                    rentWithBilka111.setText("Rent with Bilka: " + lands[1].getRENT_WITH_PRIMARY() + "B");
                    buildStarbucks111.setText("Build Starbucks: " + lands[1].getSECONDARY_COST() + "B");
                    buildBilka111.setText("Build Bilka: " + lands[1].getPRIMARY_COST() + "B");

                    String imageName3 = "ApplicationControl/Images/buildings_all_png/" + lands[1].getName()+ ".png";
                    Image image3 = new Image(imageName3);
                    landImage111.setImage(image3);

                }


        }
        else if (curLand.isBought() && curPlayer.getOwnedLands().contains(curLand)) {
                rent11.setText("You own this place.");
                rentWithColorSet11.setText("");
                rentWithOneSB11.setText("");
                rentWithTwoSB11.setText("");
                rentWithThreeSB11.setText("");
                rentWithBilka11.setText("");
                buildStarbucks11.setText("");
                buildBilka11.setText("");
                buyButton.setText("Cool");
        }
    }


    @FXML
    public void p1s1ButtonClicked ( ActionEvent event) throws Exception
    {

    }

    @FXML
    public void p1s2ButtonClicked ( ActionEvent event) throws Exception
    {

    }
    @FXML
    public void p1s3ButtonClicked ( ActionEvent event) throws Exception
    {

    }

    @FXML
    public void p1BilkaButtonClicked ( ActionEvent event) throws Exception
    {

    }

    @FXML
    public void p2s1ButtonClicked ( ActionEvent event) throws Exception
    {

    }

    @FXML
    public void p2s2ButtonClicked ( ActionEvent event) throws Exception
    {

    }

    @FXML
    public void p2s3ButtonClicked ( ActionEvent event) throws Exception
    {

    }


    @FXML
    public void p2BilkaButtonClicked ( ActionEvent event) throws Exception
    {

    }

    @FXML
    public void p3s1ButtonClicked ( ActionEvent event) throws Exception
    {

    }

    @FXML
    public void p3s2ButtonClicked ( ActionEvent event) throws Exception
    {

    }

    @FXML
    public void p3s3ButtonClicked ( ActionEvent event) throws Exception
    {

    }


    @FXML
    public void p3BilkaButtonClicked ( ActionEvent event) throws Exception
    {

    }
}
