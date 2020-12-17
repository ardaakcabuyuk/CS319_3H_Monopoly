package sample;

import GameLogic.Location;
import com.sun.javafx.geom.Rectangle;
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

import java.util.Timer;
import java.util.TimerTask;


public class GameScreen {

    final double WIDTH_RESIZE = 0.645;
    final double HEIGHT_RESIZE = 0.955;

    // variables
    ImageView pawn1;
    ImageView pawn2;
    ImageView pawn3;
    ImageView pawn4;
    Rectangle2D screenBounds;
    double windowWidth;
    double windowHeight;
    double boardWidth;
    double boardHeight;
    //ObservableList<ImageView> pawnList = FXCollections.observableArrayList(pawn1, pawn2, pawn3, pawn4);

    @FXML
    public void initialize(){
        screenBounds = Screen.getPrimary().getBounds();
        windowWidth =  screenBounds.getMaxX();
        windowHeight = screenBounds.getMaxY();

        boardWidth = windowWidth * WIDTH_RESIZE;
        boardHeight = windowHeight * HEIGHT_RESIZE;
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


        final double PAWN_SIZE = 40;

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
        int[] dices = AssetManager.gameManager.getDiceValues();
        String dicePath = "Images/diceImages/" + dices[0] + "." + dices[1] + ".png";
        Image diceImg = new Image(getClass().getResource(dicePath).toExternalForm());
        ImageView diceImageView = new ImageView(diceImg);
        diceImageView.relocate(boardWidth / 2 - diceImg.getWidth() / 2, boardHeight / 2 - diceImg.getHeight() / 2);
        boardAnchorPane.getChildren().add(diceImageView);
        new Timer().schedule(new TimerTask(){

            int second = 5;
            @Override
            public void run() {
                System.out.println(second--);
                if (second == 0) {
                    diceImageView.setImage(null);
                    cancel();
                }
            }
        },0, 1000);
        System.out.println("Dice 1: " + dices[0] + "\nDice 2: " + dices[1]);
    }
}
