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
        initializePawns();
    }

    public void initializePawns(){
        //pawn1
        ImageView pawn1 = new ImageView(getClass().getResource("Images/pawns/p1.jpg").toExternalForm());
        pawn1.relocate(830, 800);
        pawn1.setFitHeight(40);
        pawn1.setFitWidth(40);
        //pawn2
        ImageView pawn2 = new ImageView(getClass().getResource("Images/pawns/p2.jpg").toExternalForm());
        pawn2.relocate(830, 760);
        pawn2.setFitHeight(40);
        pawn2.setFitWidth(40);
        //pawn3
        ImageView pawn3 = new ImageView(getClass().getResource("Images/pawns/p3.jpg").toExternalForm());
        pawn3.relocate(860, 800);
        pawn3.setFitHeight(40);
        pawn3.setFitWidth(40);
        //pawn4
        ImageView pawn4 = new ImageView(getClass().getResource("Images/pawns/p4.jpg").toExternalForm());
        pawn4.relocate(860, 760);
        pawn4.setFitHeight(40);
        pawn4.setFitWidth(40);
        boardAnchorPane.getChildren().addAll(pawn1, pawn2, pawn3, pawn4);
        System.out.println(boardAnchorPane.getLayoutX());
        System.out.println(boardAnchorPane.getLayoutY());
        System.out.println(boardAnchorPane.widthProperty().doubleValue());
        System.out.println(boardAnchorPane.heightProperty().doubleValue());
    }
}
