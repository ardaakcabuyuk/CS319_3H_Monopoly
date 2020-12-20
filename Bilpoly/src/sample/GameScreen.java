package sample;

import GameLogic.*;
import com.sun.javafx.geom.Rectangle;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
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

    final int MAX_SECOND_VALUE = 60;
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

    //properties for updating popup
    public Landable currentLandable;
    public String nameOfLand;
    public String rentPopup;
    public String rentColorSetPopup;
    public String rentWithOneSBPopup;
    public String rentWithTwoSBPopup;
    public String rentWithThreeSBPopup;
    public String rentWithBilkaPopup;
    public String imageNamePopup;
    public String cardStrategy;
    public String cardText;

    private Card pickedCard;


    @FXML
    private ImageView nextPlayerPawnImage;

    @FXML
    private Label history1Label;
    @FXML
    private Label history2Label;
    @FXML
    private Label history3Label;
    @FXML
    private Label nextTurnNameLabel;
    @FXML
    private Label nextTurnMoneyLabel;
    @FXML
    private Label curPlayerName;

    @FXML
    private Label curPlayerMoney;

    @FXML
    private ImageView cardDeckImage;

    LandPopupController landPopupController;

    private int timeSeconds =MAX_SECOND_VALUE;
    private int timeMinutes = AssetManager.timeLimit;
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

        if ( AssetManager.timeMode) {
            timeLabel.setText(AssetManager.timeLimit + ":00");
            startTimer();
        }
        else
        {
            timeLabel.setText("");
        }

        rolledDice = false;
       // doneClicked = false;
       // doneButton.setDisable(true);

        this.history1Label.setText("Game Started !!!");
        this.history2Label.setText("");
        this.history3Label.setText("");

    }
    @FXML
    public static Popup landPopup = new Popup();
    @FXML
    public static Popup cafePopup = new Popup();
    @FXML
    public static Popup cardPopup = new Popup();
    @FXML
    public static Popup pausePopup = new Popup();
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
        pausePopup.getContent().add((Parent)loader.load());
        //Parent root = FXMLLoader.load(getClass().getResource("game_screen.fxml"));
        Stage window = (Stage)( ((Node) event.getSource()).getScene().getWindow());
        rollDiceButton.setDisable(true);
        pausePopup.show(window);
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

    public void changePlayerLabels(Player current)
    {
        System.out.println("sample/Images/card_deck_"+AssetManager.gameManager.getCurrentPlayer().getColorName()+"_turn.png");
        Image img = new Image("sample/Images/card_deck_"+AssetManager.gameManager.getCurrentPlayer().getColorName()+"_turn.png");
        cardDeckImage.setImage(img);
        String moneyBuffer = String.valueOf(current.getMoney());
        if(moneyBuffer.length() >= 4) {
            int index = moneyBuffer.length() - 4;
            moneyBuffer = moneyBuffer.substring(0, index + 1)
                    + " "
                    + moneyBuffer.substring(index + 1);
            curPlayerMoney.setText(moneyBuffer + "₿");
        }
        else{
            curPlayerMoney.setText(current.getMoney() + "₿");
        }
        curPlayerName.setText(current.getName());
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
                AssetManager.gameManager.getPlayers().get(p).getPawn().setImage(pawnFerrariImage);
                pawnFerrariImage.relocate(nizamiyeLocation.getX(), nizamiyeLocation.getY());
                pawnFerrariImage.setFitHeight(PAWN_SIZE);
                pawnFerrariImage.setFitWidth(PAWN_SIZE);
                boardAnchorPane.getChildren().addAll(pawnFerrariImage);
                ferrariInit = true;
            }
            else if(AssetManager.gameManager.getPlayers().get(p).getPawn().getType() == PawnType.TMD && !tmdInit){
                //pawnTMDImage
                pawnTMDImage = new ImageView(getClass().getResource("Images/tmd.png").toExternalForm());
                AssetManager.gameManager.getPlayers().get(p).getPawn().setImage(pawnTMDImage);
                pawnTMDImage.relocate(nizamiyeLocation.getX(), nizamiyeLocation.getY());
                pawnTMDImage.setFitHeight(PAWN_SIZE);
                pawnTMDImage.setFitWidth(PAWN_SIZE);
                boardAnchorPane.getChildren().addAll(pawnTMDImage);
                tmdInit = true;
            }
            else if(AssetManager.gameManager.getPlayers().get(p).getPawn().getType() == PawnType.TAXI && !taxiInit){
                //pawnTaxiImage
                pawnTaxiImage = new ImageView(getClass().getResource("Images/taxi.png").toExternalForm());
                AssetManager.gameManager.getPlayers().get(p).getPawn().setImage(pawnTaxiImage);
                pawnTaxiImage.relocate(nizamiyeLocation.getX(), nizamiyeLocation.getY());
                pawnTaxiImage.setFitHeight(PAWN_SIZE);
                pawnTaxiImage.setFitWidth(PAWN_SIZE);
                boardAnchorPane.getChildren().addAll(pawnTaxiImage);
                taxiInit = true;
            }
            else if(AssetManager.gameManager.getPlayers().get(p).getPawn().getType() == PawnType.BMW && !bmwInit){
                //pawnBMWImage
                pawnBMWImage = new ImageView(getClass().getResource("Images/bmw.png").toExternalForm());
                AssetManager.gameManager.getPlayers().get(p).getPawn().setImage(pawnBMWImage);
                pawnBMWImage.relocate(nizamiyeLocation.getX(), nizamiyeLocation.getY());
                pawnBMWImage.setFitHeight(PAWN_SIZE);
                pawnBMWImage.setFitWidth(PAWN_SIZE);
                boardAnchorPane.getChildren().addAll(pawnBMWImage);
                bmwInit = true;
            }
        }
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
    public void startTimer()
    {
        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    public void run() {
                        if ( timeMinutes == AssetManager.timeLimit )
                        {
                            timeMinutes--;
                        }
                        timeSeconds--;

                        timeLabel.setText( timeMinutes + ":" + timeSeconds);
                        if ( timeSeconds == 0)
                        {
                            timeMinutes--;
                            timeSeconds = MAX_SECOND_VALUE;
                        }
                        if (timeMinutes < 0)
                            timer.cancel();

                    }
                });
            }
        }, 1000, 1000);
    }

    public void executeLandPopup() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("land_popup.fxml"));
        landPopup.getContent().add((Parent)loader.load());
        Stage window = (Stage) boardAnchorPane.getScene().getWindow();
        rollDiceButton.setDisable(true);
        landPopup.show(window);
    }

    public void executeCafePopup() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("cafe_popup.fxml"));
        cafePopup.getContent().add((Parent)loader.load());
        Stage window = (Stage)  boardAnchorPane.getScene().getWindow();
        rollDiceButton.setDisable(true);
        cafePopup.show(window);
    }


    public void executeCardPopup() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("card_popup.fxml"));
        cardPopup.getContent().add((Parent)loader.load());
        Stage window = (Stage)  boardAnchorPane.getScene().getWindow();
        rollDiceButton.setDisable(true);
        cardPopup.show(window);
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
        //Landable curLandable = AssetManager.gameManager.getLandableList()[curPawn.getCurrentLandableIndex()];
        Landable nextLandable = AssetManager.gameManager.getLandableList()[(index) % 40];
        currentLandable = nextLandable;
        //Location currentLocation = new Location(curLandable.getLocation().getX(), curLandable.getLocation().getY());
        Location toGoLocation = new Location(nextLandable.getLocation().getX(), nextLandable.getLocation().getY());
        pawnImage.relocate(toGoLocation.getX(), toGoLocation.getY());
        curPawn.movePawn(((index) % 40));

        //If landed landable is not functional place, popups will show
        if ( nextLandable.getType() != LandableType.FUNCTIONAL_PLACE )
        {
            //for land popup
            if ( nextLandable.getType() == LandableType.LAND )
            {
                nameOfLand = ( (Land) nextLandable).getName();

                rentColorSetPopup = String.valueOf(( (Land) nextLandable).getRENT_WITH_SET());
                rentPopup = String.valueOf(( (Land) nextLandable).getRENT());
                rentWithOneSBPopup = String.valueOf(( (Land) nextLandable).getRENT_WITH_1_SECONDARY());
                rentWithTwoSBPopup = String.valueOf(( (Land) nextLandable).getRENT_WITH_2_SECONDARY());
                rentWithThreeSBPopup = String.valueOf(( (Land) nextLandable).getRENT_WITH_3_SECONDARY());
                rentWithBilkaPopup = String.valueOf(( (Land) nextLandable).getRENT_WITH_PRIMARY());

                imageNamePopup = "sample/Images/buildings_all_png/" + nameOfLand + ".png";

                executeLandPopup();

            }
            //for cafe popup
            else if ( nextLandable.getType() == LandableType.CAFE )
            {
                nameOfLand = ( ( Cafe ) nextLandable).getName();

                rentColorSetPopup = "";
                rentPopup = "";

                rentWithOneSBPopup = String.valueOf(( (Cafe) nextLandable).getRentWith1());
                rentWithTwoSBPopup = String.valueOf(( (Cafe) nextLandable).getRentWith2());
                rentWithThreeSBPopup = String.valueOf(( (Cafe) nextLandable).getRentWith3());
                rentWithBilkaPopup = String.valueOf(( (Cafe) nextLandable).getRentWith4());

                imageNamePopup = "sample/Images/cafes_png/" + nameOfLand + ".png";

                executeCafePopup();
            }
            //for card popups
            else if ( nextLandable.getType() == LandableType.CARD_PLACE ) {

                cardStrategy = ((CardPlace) nextLandable).getCardType().name();
                System.out.println("Card Type:" + cardStrategy);

                pickedCard = AssetManager.gameManager.getCardDeck().drawCard(((CardPlace) nextLandable).getCardType());
                cardText = String.valueOf(AssetManager.gameManager.getCardDeck().getCurrentCard().getText());

                executeCardPopup();
            }
        }
        else{
            AssetManager.gameManager.playTurnPostDice(nextLandable);
        }
    }

    public Card getPickedCard() {
        return pickedCard;
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
/*
    public void constructLandPopup() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("land_popup.fxml"));
        Parent root = loader.load();

        landPopupController = loader.getController();

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


    public void setNextTurn(String nextTurnNameLabel, String nextTurnMoneyLabel, Pawn nextPlayerPawn){
        this.nextTurnNameLabel.setText(nextTurnNameLabel);

        this.nextPlayerPawnImage.setImage(getPawnImage(nextPlayerPawn).getImage());

        String moneyBuffer = nextTurnMoneyLabel;
        if(moneyBuffer.length() >= 4) {

            int index = moneyBuffer.length() - 4;
            moneyBuffer = moneyBuffer.substring(0, index + 1)
                    + " "
                    + moneyBuffer.substring(index + 1);
            this.nextTurnMoneyLabel.setText(moneyBuffer + "₿");
        }
        else{
            this.nextTurnMoneyLabel.setText(nextTurnMoneyLabel + "₿");
        }
    }

    public void addHistory(String newHist){
        this.history3Label.setText(history2Label.getText());
        this.history2Label.setText(history1Label.getText());
        this.history1Label.setText(newHist);
    }

}
