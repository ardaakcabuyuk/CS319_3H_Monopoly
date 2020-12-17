package sample;

import GameLogic.*;
import com.sun.javafx.geom.Rectangle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
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
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Popup;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.util.Timer;
import java.util.TimerTask;


public class GameScreen {

    final double WIDTH_RESIZE = 0.645;
    final double HEIGHT_RESIZE = 0.955;

    // variables
    ImageView pawnFerrariImage;
    ImageView pawnTMDImage;
    ImageView pawnTaxiImage;
    ImageView pawnBMWImage;

    Rectangle2D screenBounds;
    double windowWidth;
    double windowHeight;
    double boardWidth;
    double boardHeight;
    public boolean doneClicked;
    public boolean rolledDice;
    private Timeline timeline;

    //ObservableList<ImageView> pawnList = FXCollections.observableArrayList(pawn1, pawn2, pawn3, pawn4);

    private IntegerProperty timeSeconds = new SimpleIntegerProperty(AssetManager.timeLimit);

    @FXML
    public void initialize(){
        screenBounds = Screen.getPrimary().getBounds();
        windowWidth =  screenBounds.getMaxX();
        windowHeight = screenBounds.getMaxY();

        boardWidth = windowWidth * WIDTH_RESIZE;
        boardHeight = windowHeight * HEIGHT_RESIZE;

        timeLabel.textProperty().bind(timeSeconds.asString());
        timeSeconds.set(AssetManager.timeLimit);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(AssetManager.timeLimit+1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();

        rolledDice = false;
        doneClicked = false;
        initializePawns();
    }
    @FXML
    public static Popup popup = new Popup();
    @FXML
    public AnchorPane boardAnchorPane;
    @FXML
    public ImageView boardImage;
    @FXML
    public Button rollDiceButton;
    @FXML
    public Label timeLabel;

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
        nizamiyeLocations[0] = new Location(810, 800);
        nizamiyeLocations[1] = new Location(810, 750);
        nizamiyeLocations[2] = new Location(870, 800);
        nizamiyeLocations[3] = new Location(870, 750);


        final double PAWN_SIZE = 50;

        boardImage.setFitWidth(boardWidth);
        boardImage.setFitHeight(boardHeight);

        //pawnFerrariImage
        pawnFerrariImage = new ImageView(getClass().getResource("Images/ferrari.png").toExternalForm());
        pawnFerrariImage.relocate(nizamiyeLocations[0].getX(), nizamiyeLocations[0].getY());
        pawnFerrariImage.setFitHeight(PAWN_SIZE);
        pawnFerrariImage.setFitWidth(PAWN_SIZE);
        //pawnTMDImage
        pawnTMDImage = new ImageView(getClass().getResource("Images/tmd.png").toExternalForm());
        pawnTMDImage.relocate(nizamiyeLocations[1].getX(), nizamiyeLocations[1].getY());
        pawnTMDImage.setFitHeight(PAWN_SIZE);
        pawnTMDImage.setFitWidth(PAWN_SIZE);
        //pawnTaxiImage
        pawnTaxiImage = new ImageView(getClass().getResource("Images/taxi.png").toExternalForm());
        pawnTaxiImage.relocate(nizamiyeLocations[2].getX(), nizamiyeLocations[2].getY());
        pawnTaxiImage.setFitHeight(PAWN_SIZE);
        pawnTaxiImage.setFitWidth(PAWN_SIZE);
        //pawnBMWImage
        pawnBMWImage = new ImageView(getClass().getResource("Images/bmw.png").toExternalForm());
        pawnBMWImage.relocate(nizamiyeLocations[3].getX(), nizamiyeLocations[3].getY());
        pawnBMWImage.setFitHeight(PAWN_SIZE);
        pawnBMWImage.setFitWidth(PAWN_SIZE);

        boardAnchorPane.getChildren().addAll(pawnFerrariImage, pawnTMDImage, pawnTaxiImage, pawnBMWImage);
        System.out.println("x: " + pawnFerrariImage.getX() + " Y: " + pawnFerrariImage.getY());
    }

    public void movePawns(){

    }

    @FXML
    public void rollDiceClicked(MouseEvent event) throws Exception{
 
        System.out.println("rollDiceClicked");

        // show dice UI
        int[] dices = AssetManager.gameManager.rollDice();

        rolledDice = true;

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


        //move pawn
        Pawn currentPawn = AssetManager.gameManager.getCurrentPlayer().getPawn();
        ImageView currentPawnImageView = getPawnImage(currentPawn);
        // get current pawn image view
        currentPawnImageView.relocate(200, 200);
        System.out.println("x: " + currentPawnImageView.getX() + " Y: " + currentPawnImageView.getY());

        rollDiceButton.setDisable(true);
    }

    @FXML
    public void doneButtonClicked(MouseEvent event) throws Exception{
        doneClicked = true;
        enableRollDiceButton();
    }
    public void enableRollDiceButton(){
        System.out.println("enableRollDiceButton");
        rollDiceButton.setDisable(false);
    }

    public ImageView getPawnImage(Pawn pawn){
        if(pawn.getType() == PawnType.FERRARI){
            return pawnFerrariImage;
        }
        else if(pawn.getType() == PawnType.TMD){
            return pawnTMDImage;
        }
        else if(pawn.getType() == PawnType.TAXI){
            return pawnTaxiImage;
        }
        else if(pawn.getType() == PawnType.BMW){
            return pawnBMWImage;
        }
        else{
            return null;
        }
    }
    public void disableRollDiceButton(){
        System.out.println("disableRollDiceButton");
        rollDiceButton.setDisable(true);
    }
}
