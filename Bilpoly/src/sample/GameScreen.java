package sample;

import GameLogic.Location;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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


public class GameScreen {

    // variables
    ImageView pawn1;
    ImageView pawn2;
    ImageView pawn3;
    ImageView pawn4;
    //ObservableList<ImageView> pawnList = FXCollections.observableArrayList(pawn1, pawn2, pawn3, pawn4);

    @FXML
    public void initialize(){
        initializePawns();
    }
    @FXML
    public static Popup popup = new Popup();
    @FXML
    public AnchorPane boardAnchorPane;
    @FXML
    public ImageView boardImage;

    @FXML
    public void pauseButtonClicked(ActionEvent event) throws Exception {
        System.out.println("pause Button clicked.");
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pause_menu.fxml"));
        popup.getContent().add((Parent)loader.load());
        Parent root = FXMLLoader.load(getClass().getResource("game_screen.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        popup.show(window);
    }

    @FXML
    public void mouseClicked(MouseEvent event) throws Exception {
        System.out.println("X: " + event.getX());
        System.out.println("Y: " + event.getY());
    }

    public void initializePawns(){

        Location[] nizamiyeLocations = new Location[4];
        nizamiyeLocations[0] = new Location(830, 800);
        nizamiyeLocations[1] = new Location(830, 760);
        nizamiyeLocations[2] = new Location(860, 800);
        nizamiyeLocations[3] = new Location(860, 760);

        final double WIDTH_RESIZE = 0.645;
        final double HEIGHT_RESIZE = 0.955;
        final double PAWN_SIZE = 40;

        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        double windowWidth =  screenBounds.getMaxX();
        double windowHeight = screenBounds.getMaxY();

        double boardWidth = windowWidth * WIDTH_RESIZE;
        double boardHeight = windowHeight * HEIGHT_RESIZE;

        boardImage.setFitWidth(boardWidth);
        boardImage.setFitHeight(boardHeight);

        //pawn1
        pawn1 = new ImageView(getClass().getResource("Images/pawns/p1.jpg").toExternalForm());
        pawn1.relocate(nizamiyeLocations[0].getX(), nizamiyeLocations[0].getY());
        pawn1.setFitHeight(PAWN_SIZE);
        pawn1.setFitWidth(PAWN_SIZE);
        //pawn2
        pawn2 = new ImageView(getClass().getResource("Images/pawns/p2.jpg").toExternalForm());
        pawn2.relocate(nizamiyeLocations[1].getX(), nizamiyeLocations[1].getY());
        pawn2.setFitHeight(PAWN_SIZE);
        pawn2.setFitWidth(PAWN_SIZE);
        //pawn3
        pawn3 = new ImageView(getClass().getResource("Images/pawns/p3.jpg").toExternalForm());
        pawn3.relocate(nizamiyeLocations[2].getX(), nizamiyeLocations[2].getY());
        pawn3.setFitHeight(PAWN_SIZE);
        pawn3.setFitWidth(PAWN_SIZE);
        //pawn4
        pawn4 = new ImageView(getClass().getResource("Images/pawns/p4.jpg").toExternalForm());
        pawn4.relocate(nizamiyeLocations[3].getX() / 2, nizamiyeLocations[3].getY() / 2);
        pawn4.setFitHeight(PAWN_SIZE);
        pawn4.setFitWidth(PAWN_SIZE);

        boardAnchorPane.getChildren().addAll(pawn1, pawn2, pawn3, pawn4);
        System.out.println("x: " + pawn1.getX() + " Y: " + pawn1.getY());
    }

    @FXML
    public void rollDiceClicked(MouseEvent event) throws Exception{
        System.out.println("rollDiceClicked");
        pawn1.relocate(200, 200);
        System.out.println("x: " + pawn1.getX() + " Y: " + pawn1.getY());
    }
}
