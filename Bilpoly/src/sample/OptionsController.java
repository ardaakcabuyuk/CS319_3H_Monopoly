package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.scene.control.*;

public class OptionsController {
    Button backButton = new Button();

    @FXML
    Slider musicSlider;

    @FXML
    Slider effectsSlider;

    @FXML
    Label musicLabel;

    @FXML
    Label effectsLabel;

    @FXML
    AnchorPane anchorBackground;

    @FXML
    public void image1ButtonClicked(ActionEvent event) throws Exception {
        System.out.println("default bilkent Button clicked. ");
        anchorBackground.getStyleClass().remove("bodybg2");
        anchorBackground.getStyleClass().add("bodybg");
    }

    @FXML
    public void image2ButtonClicked(ActionEvent event) throws Exception {
        System.out.println("odeon Button clicked. ");
        anchorBackground.getStyleClass().remove("bodybg");
        anchorBackground.getStyleClass().add("bodybg2");
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws Exception {
        System.out.println("back Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    public void initialize() {

        musicSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            musicLabel.setText("%" + Integer.toString((int) newValue.intValue()));


        });

        effectsSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            effectsLabel.setText("%" + Integer.toString((int) newValue.intValue()));


        });

    }
}
