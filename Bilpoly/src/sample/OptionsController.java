package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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
    AnchorPane anchorOptions;

    private String urlTheme1 = getClass().getResource("background.css").toExternalForm();
    private String urlTheme2 = getClass().getResource("background2.css").toExternalForm();

    @FXML
    public void image1ButtonClicked(ActionEvent event) throws Exception {
        System.out.println("default bilkent Button clicked. ");

        Scene scene1 =  ((Node) event.getSource()).getScene();
        scene1.getStylesheets().remove(urlTheme2);
        scene1.getStylesheets().add(urlTheme1);

    }

    @FXML
    public void image2ButtonClicked(ActionEvent event) throws Exception {
        System.out.println("odeon Button clicked. ");

        Scene scene1 =  ((Node) event.getSource()).getScene();
        scene1.getStylesheets().remove(urlTheme1);
        scene1.getStylesheets().add(urlTheme2);
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
