package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class PreGameSettingsController {

    @FXML
    private Slider timeSlider;

    @FXML
    private Label timeLabel;

    @FXML
    public void money3ButtonClicked(ActionEvent event) throws Exception {
        System.out.println("$150k Button clicked. ");
    }

    @FXML
    public void money2ButtonClicked(ActionEvent event) throws Exception {
        System.out.println("$100k Button clicked. ");
    }

    @FXML
    public void money1ButtonClicked(ActionEvent event) throws Exception {
        System.out.println("$50k Button clicked. ");
    }

    @FXML
    public void buildingsButtonClicked(ActionEvent event) throws Exception {
        System.out.println("Buildings mode selected. ");
    }

    @FXML
    public void coursesButtonClicked(ActionEvent event) throws Exception {
        System.out.println("Courses mode selected. ");
    }

    @FXML
    public void normalButtonClicked(ActionEvent event) throws Exception {
        System.out.println("Normal time mode selected. ");
    }

    @FXML
    public void timedButtonClicked(ActionEvent event) throws Exception {
        System.out.println("Timed mode selected. ");
    }

    @FXML
    public void startButtonClicked(ActionEvent event) throws Exception {
        System.out.println("start Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("game_screen.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
        AssetManager.constructGameManager();
    }

    @FXML
    public void backButtonClicked(ActionEvent event) throws Exception {
        System.out.println("back Button clicked. ");
        Parent root = FXMLLoader.load(getClass().getResource("player_selection.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    //initialize timeLabel text according to the sliders value
    public void initialize() {

        timeSlider.valueProperty().addListener((observable, oldValue, newValue) -> {

            timeLabel.setText(Double.toString(newValue.intValue()));


        });
    }
}
