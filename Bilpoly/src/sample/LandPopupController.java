package sample;

import GameLogic.GameManager;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LandPopupController {



    String landNameNew = "";
    String rentNew;
    String rentWithColorSet;
    String rentWithOneSB;
    String rentWithTwoSB;
    String rentWithThreeSB;
    String rentWithBilka;

    String buildStarbucks;
    String buildBilka;

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

    @FXML
    public void initialize()
    {
        landName.setText(AssetManager.gameManager.gameScreenController.nameOfLand);
    }

    public String getLandNameNew() {
        return landNameNew;
    }

    public void setLandNameNew(String landNameNew) {
        this.landNameNew = landNameNew;
    }

    public String getRentNew() {
        return rentNew;
    }

    public void setRentNew(String rentNew) {
        this.rentNew = rentNew;
    }

    public String getRentWithColorSet() {
        return rentWithColorSet;
    }

    public void setRentWithColorSet(String rentWithColorSet) {
        this.rentWithColorSet = rentWithColorSet;
    }

    public String getRentWithOneSB() {
        return rentWithOneSB;
    }

    public void setRentWithOneSB(String rentWithOneSB) {
        this.rentWithOneSB = rentWithOneSB;
    }

    public String getRentWithTwoSB() {
        return rentWithTwoSB;
    }

    public void setRentWithTwoSB(String rentWithTwoSB) {
        this.rentWithTwoSB = rentWithTwoSB;
    }

    public String getRentWithThreeSB() {
        return rentWithThreeSB;
    }

    public void setRentWithThreeSB(String rentWithThreeSB) {
        this.rentWithThreeSB = rentWithThreeSB;
    }

    public String getRentWithBilka() {
        return rentWithBilka;
    }

    public void setRentWithBilka(String rentWithBilka) {
        this.rentWithBilka = rentWithBilka;
    }

    public String getBuildStarbucks() {
        return buildStarbucks;
    }

    public void setBuildStarbucks(String buildStarbucks) {
        this.buildStarbucks = buildStarbucks;
    }

    public String getBuildBilka() {
        return buildBilka;
    }

    public void setBuildBilka(String buildBilka) {
        this.buildBilka = buildBilka;
    }

}
