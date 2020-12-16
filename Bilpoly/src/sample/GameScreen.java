package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class GameScreen {

    @FXML
    public static Popup popup = new Popup();
    @FXML
    public AnchorPane boardAnchorPane;

    @FXML
    public void pauseButtonClicked(ActionEvent event) throws Exception {
        System.out.println("pause Button clicked.");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pause_menu.fxml"));
        popup.getContent().add((Parent)loader.load());
        Parent root = FXMLLoader.load(getClass().getResource("../GameLogic/game_screen.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        popup.show(window);
    }

    @FXML
    public void mouseClicked(MouseEvent event) throws Exception {
        System.out.println("X: " + event.getX());
        System.out.println("Y: " + event.getY());
        addImage();
    }

    public void addImage(){
        //Image pawn = new Image("/Images/pawns/p2.jpg");
        BufferedImage pawn = new BufferedImage();
        try {
            pawn = ImageIO.read(new File("/Images/pawns/p2.jpg"));
        } catch (IOException e) {
            System.out.println(e);
        }
        boardAnchorPane.getChildren().addAll(new ImageView(pawn));
    }
}
