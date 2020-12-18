package sample;

import GameLogic.*;
import com.sun.javafx.geom.Rectangle;
import javafx.animation.AnimationTimer;
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
import javafx.geometry.Bounds;
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

import java.io.IOException;
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
    protected double boardWidth;
    protected double boardHeight;
    //public boolean doneClicked;
    public boolean rolledDice;
    private Timeline timeline;



    //ObservableList<ImageView> pawnList = FXCollections.observableArrayList(pawn1, pawn2, pawn3, pawn4);

    private IntegerProperty timeSeconds = new SimpleIntegerProperty(AssetManager.timeLimit);

    @FXML
    AnchorPane BoardAnchorPane;

    @FXML
    public void initialize(){
        screenBounds = Screen.getPrimary().getBounds();
        windowWidth =  screenBounds.getMaxX();
        windowHeight = screenBounds.getMaxY();

        boardWidth = windowWidth * WIDTH_RESIZE;
        boardHeight = windowHeight * HEIGHT_RESIZE;
        System.out.println("boardWidth: " + boardWidth + " boardHeight: " + boardHeight);

        timeLabel.textProperty().bind(timeSeconds.asString());
        timeSeconds.set(AssetManager.timeLimit);
        timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.seconds(AssetManager.timeLimit+1),
                        new KeyValue(timeSeconds, 0)));
        timeline.playFromStart();

        rolledDice = false;
       // doneClicked = false;
       // doneButton.setDisable(true);

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
        //Parent root = FXMLLoader.load(getClass().getResource("game_screen.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        popup.show(window);
    }

    @FXML
    public void mainMenuButtonClicked(ActionEvent event) throws Exception {
        System.out.println("main menu Button clicked.");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        window.getScene().setRoot(root);
    }

    @FXML
    public void mouseClicked(MouseEvent event) throws Exception {
        System.out.println("X: " + event.getX());
        System.out.println("Y: " + event.getY());
    }

    public void initializePawns(Landable[] landableList){
        final double PAWN_SIZE = 50;

        boardImage.setFitWidth(boardWidth);
        boardImage.setFitHeight(boardHeight);

        Location nizamiyeLocation = landableList[0].getLocation();

        //System.out.println("landableList[0].getIndex(): " + landableList[0].getIndex());
        //System.out.println("nizamiye x: " + nizamiyeLocation.getX() + " y: " + nizamiyeLocation.getY());
        // for test
        //Location nizamiyeLocation = new Location(boardWidth * 0.871905, boardHeight * 0.873108);

        boolean ferrariInit = false;
        boolean tmdInit = false;
        boolean taxiInit = false;
        boolean bmwInit = false;
        for(int p = 0; p < AssetManager.gameManager.getPlayers().size(); p++){
            if(AssetManager.gameManager.getPlayers().get(p).getPawn().getType() == PawnType.FERRARI && !ferrariInit){
                //pawnFerrariImage
                pawnFerrariImage = new ImageView(getClass().getResource("Images/ferrari.png").toExternalForm());
                pawnFerrariImage.relocate(nizamiyeLocation.getX(), nizamiyeLocation.getY());
                pawnFerrariImage.setFitHeight(PAWN_SIZE);
                pawnFerrariImage.setFitWidth(PAWN_SIZE);
                boardAnchorPane.getChildren().addAll(pawnFerrariImage);
                ferrariInit = true;
            }
            else if(AssetManager.gameManager.getPlayers().get(p).getPawn().getType() == PawnType.TMD && !tmdInit){
                //pawnTMDImage
                pawnTMDImage = new ImageView(getClass().getResource("Images/tmd.png").toExternalForm());
                pawnTMDImage.relocate(nizamiyeLocation.getX(), nizamiyeLocation.getY());
                pawnTMDImage.setFitHeight(PAWN_SIZE);
                pawnTMDImage.setFitWidth(PAWN_SIZE);
                boardAnchorPane.getChildren().addAll(pawnTMDImage);
                tmdInit = true;
            }
            else if(AssetManager.gameManager.getPlayers().get(p).getPawn().getType() == PawnType.TAXI && !taxiInit){
                //pawnTaxiImage
                pawnTaxiImage = new ImageView(getClass().getResource("Images/taxi.png").toExternalForm());
                pawnTaxiImage.relocate(nizamiyeLocation.getX(), nizamiyeLocation.getY());
                pawnTaxiImage.setFitHeight(PAWN_SIZE);
                pawnTaxiImage.setFitWidth(PAWN_SIZE);
                boardAnchorPane.getChildren().addAll(pawnTaxiImage);
                taxiInit = true;
            }
            else if(AssetManager.gameManager.getPlayers().get(p).getPawn().getType() == PawnType.BMW && !bmwInit){
                //pawnBMWImage
                pawnBMWImage = new ImageView(getClass().getResource("Images/bmw.png").toExternalForm());
                pawnBMWImage.relocate(nizamiyeLocation.getX(), nizamiyeLocation.getY());
                pawnBMWImage.setFitHeight(PAWN_SIZE);
                pawnBMWImage.setFitWidth(PAWN_SIZE);
                boardAnchorPane.getChildren().addAll(pawnBMWImage);
                bmwInit = true;
            }
        }
    }

    public void movePawns(){

    }

    @FXML
    public void rollDiceClicked(MouseEvent event) throws Exception{

        System.out.println("rollDiceClicked");

        // show dice UI
        int[] dices = AssetManager.gameManager.rollDice();
        int totalDiceValue = dices[0] + dices[1];

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
                 //   doneButton.setDisable(false);
                    cancel();
                }
            }
        },0, 1000);
        System.out.println("Dice 1: " + dices[0] + "\nDice 2: " + dices[1]);


        //move pawn
        Pawn currentPawn = AssetManager.gameManager.getCurrentPlayer().getPawn();
        // get current pawn image view
        ImageView currentPawnImageView = getPawnImage(currentPawn);

        movePawnImage(currentPawnImageView, ((currentPawn.getCurrentLandableIndex() + totalDiceValue) % 40), currentPawn);

        //animatePawnImageMovement(currentPawnImageView, ((currentPawn.getCurrentLandableIndex() + totalDiceValue) % 40), currentPawn);

        System.out.println("dice: " + totalDiceValue + " currentPawn.getCurrentLandableIndex(): " + currentPawn.getCurrentLandableIndex());

        System.out.println("currentPawn.getCurrentLandableIndex(): " + currentPawn.getCurrentLandableIndex());

        //rollDiceButton.setDisable(true);
        //doneButton.setDisable(true);

    }
/*
    @FXML
    public void doneButtonClicked(MouseEvent event) throws Exception{
        doneClicked = true;

        AssetManager.gameManager.playGame();
    }*/

    public void executePopup() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("land_popup.fxml"));
        popup.getContent().add((Parent)loader.load());
        Stage window = (Stage)  boardAnchorPane.getScene().getWindow();

        popup.show(window);
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

    public void movePawnImage(ImageView pawnImage, int index, Pawn curPawn) throws IOException {
        Landable curLandable = AssetManager.gameManager.getLandableList()[curPawn.getCurrentLandableIndex()];
        Landable nextLandable = AssetManager.gameManager.getLandableList()[(index) % 40];
        Location currentLocation = new Location(curLandable.getLocation().getX(), curLandable.getLocation().getY());
        Location toGoLocation = new Location(nextLandable.getLocation().getX(), nextLandable.getLocation().getY());
        pawnImage.relocate(toGoLocation.getX(), toGoLocation.getY());
        curPawn.movePawn(((index) % 40));
        executePopup();
        AssetManager.gameManager.playTurnPostDice(nextLandable);
    }


/*
    public void animatePawnImageMovement(ImageView pawnImage, int index, Pawn curPawn){
        Landable curLandable = null;
        Landable nextLandable = null;
        Location currentLocation = null;
        Location toGoLocation = null;

        curLandable = AssetManager.gameManager.getLandableList()[curPawn.getCurrentLandableIndex()];
        nextLandable = AssetManager.gameManager.getLandableList()[(curPawn.getCurrentLandableIndex() + 1) % 40];
        currentLocation = new Location(curLandable.getLocation().getX(), curLandable.getLocation().getY());
        toGoLocation = new Location(nextLandable.getLocation().getX(), nextLandable.getLocation().getY());

        new Timer().schedule(new TimerTask(){

            @Override
            public void run() {
                //System.out.println("toGoLocation.getX(): " + toGoLocation.getX() + " toGoLocation.gety(): " + toGoLocation.getY());

                if (currentLocation.getX() > toGoLocation.getX() + 1){
                    currentLocation.setX((int)(currentLocation.getX() - 1));
                    pawnImage.relocate(currentLocation.getX(), pawnImage.getLayoutY());
                }
                if (currentLocation.getX() < toGoLocation.getX() - 1){
                    currentLocation.setX((int)(currentLocation.getX() + 1));
                    pawnImage.relocate(currentLocation.getX(), pawnImage.getLayoutY());
                }
                if (currentLocation.getY() > toGoLocation.getY() - 1){
                    currentLocation.setY((int)(currentLocation.getY() - 1));
                    pawnImage.relocate(pawnImage.getLayoutX(), currentLocation.getY());
                }
                if (currentLocation.getY() < toGoLocation.getY() + 1){
                    currentLocation.setY((int)(currentLocation.getY() + 1));
                    pawnImage.relocate(pawnImage.getLayoutX(), currentLocation.getY());
                }
                System.out.println("currentLocation.getX(): " + currentLocation.getX() + " currentLocation.gety(): " + currentLocation.getY());


                if (((currentLocation.getX() - toGoLocation.getX()) < 1) && ((currentLocation.getY() - toGoLocation.getY()) < 1)) {
                    if(curPawn.getCurrentLandableIndex() == index){
                        System.out.println("cancel() !!!");
                        cancel();
                    }
                    else{
                        nextLandable = AssetManager.gameManager.getLandableList()[(curPawn.getCurrentLandableIndex() + 1) % 40];
                        System.out.println("nextLandable.getIndex(): " + nextLandable.getIndex());
                        toGoLocation.setX(nextLandable.getLocation().getX());
                        toGoLocation.setX(nextLandable.getLocation().getY());
                        //currentLocation.setX(pawnImage.getLayoutX());
                        //currentLocation.setY(pawnImage.getLayoutY());
                        curPawn.movePawn(1);
                    }

                }
            }
        },0, 6);
    }

 */

    public void disableRollDiceButton(){
        System.out.println("disableRollDiceButton");
        rollDiceButton.setDisable(true);
    }

    public double getBoardWidth() {

        screenBounds = Screen.getPrimary().getBounds();
        windowWidth =  screenBounds.getMaxX();
        boardWidth = windowWidth * WIDTH_RESIZE;
        return boardWidth;
    }

    public double getBoardHeight() {
        screenBounds = Screen.getPrimary().getBounds();
        windowHeight = screenBounds.getMaxY();
        boardHeight = windowHeight * HEIGHT_RESIZE;
        return boardHeight;
    }

}
