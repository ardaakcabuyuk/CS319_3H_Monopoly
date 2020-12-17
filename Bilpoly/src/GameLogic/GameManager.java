package GameLogic;

//import sample.Images.pawns.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.AssetManager;
import sample.GameScreen;

import java.awt.*;
import java.io.IOException;
import java.util.*;

public class GameManager {

    //constants

    //variables
    private Timer timer;
    private Player winner;
    private int freeParkingMoney;
    private Landable[] landableList;
    private PlayerDeck playerDeck;
    private CardDeck cardDeck;
    private Dice dice;
    private boolean diceRolled;
    private HistoryManager historyManager;
    private boolean timeMode;
    private int timeLimit;
    private boolean isGameOver;
    private AtalarsRoom atalarsRoom;

    //private GameOver gameOver;
    //private PauseMenu pauseMenu;
    //private GameScreen gameScreen;

    public GameScreen gameScreenController;


    //constructor
    public GameManager(PlayerDeck playerDeck, Landable[] landableList, CardDeck cardDeck,
                       boolean timeMode, int timeLimit
                       //GameOver gameOver, PauseMenu pauseMenu, GameScreen gameScreen,
                        ){
        this.timer = new Timer();
        this.winner = null;
        this.freeParkingMoney = 0;
        this.landableList = landableList;
        this.playerDeck = playerDeck;
        this.cardDeck = cardDeck;
        this.dice = new Dice();
        diceRolled = false;
        this.historyManager =  new HistoryManager();
        this.timeMode = timeMode;
        this.timeLimit = timeLimit;
        this.isGameOver = false;


        // TODO fix initilization
        this.atalarsRoom = new AtalarsRoom(0 ,0 ,null, null);
        //this.gameOver =  new GameOver();
        //this.pauseMenu =  new PauseMenu();
        //this.gameScreen = gameScreen;

        playGame();

    }

    //methods
    // This method handles the game turn system.
    // TODO will be implemented.
    public void playGame(){
        // if timer => start timer;
        // you have landable[] => built the board;
        // you have playerDeck => built player cards
        // built next player
        // built history

        if(!playerDeck.getCurrentPlayer().isTurn() && !isGameOver ){
            playerDeck.nextPlayer();
            try {
                playTurnPreDice();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        // gameOver.update();
    }


    // This method handles the each turn for given player.
    // TODO will be implemented.
    // history.update();
    // gameScreen.update()

    public void playTurnPreDice() throws IOException {

        Player curPlayer = playerDeck.getCurrentPlayer();
        if (curPlayer.isInAtalarsRoom()) {
            atalarsRoom.tryToGetOut(curPlayer);
            return;
        }

        // activate roll dice button
        gameScreenController.enableRollDiceButton();


        /*
        FXMLLoader loader = new FXMLLoader(getClass().getResource("game_screen.fxml"));
        Parent root = loader.load();
        GameScreen controller = loader.<GameScreen>getController();
        controller.enableRollDiceButton();


         */


        //gameScreenController.enableRollDiceButton();



    }

    public int[] rollDice( ) {
            dice.rollDice();
            int val1 = dice.getDie1FaceValue();
            int val2 = dice.getTotalFaceValue() - val1;
            int[] values = {val1, val2};
            diceRolled = true;
            playTurnPostDice();
            return values;

    }

    public void playTurnPostDice(){
        System.out.println("playTurnPostDice");
        int diceValue = dice.getTotalFaceValue();
        //int pawnNewIndex = curPlayer.getPawn().movePawn(diceValue, landableList.length);
        executeLandable(
                //landableList[pawnNewIndex]
        );
        diceRolled = false;
        System.out.println("player " + playerDeck.getCurrentPlayer().getName() + " rolled the dice: " + diceValue);
    }



    // This method executes the given land.
    // TODO will be implemented.
    public void executeLandable(
            //Landable landable
    ){
        /*
        switch (landable.type){

            case LAND:
                if(((Land)landable).isBought){
                    // player has to pay rent
                }
                else{
                    // ask player if he wants to buy
                }

                break;


            case CAFE:
                if(((Cafe)landable).isBought){
                    // player has to pay rent
                }
                else{
                    // ask player if he wants to buy
                }

                break;


            case CARD_PLACE:

                cardDeck.drawCard(((CardPlace)landable).getCardType());
                cardDeck.executeCard();

                break;



            case FUNCTIONAL_PLACE:

                // i have no idea what to do here -ömer

                break;



            case GO_TO_ATALARS_ROOM:

                atalarsRoom.goToAtalarsRoom(playerDeck.getCurrentPlayer());

                break;



            default:
                // error
        }

         */
        if ( gameScreenController.doneClicked )
        {
            System.out.println("done clicked");
            gameScreenController.enableRollDiceButton();
            playGame();
        }
    }

    //GETTERS AND SETTERS
    public Player getCurrentPlayer(){
        return playerDeck.getCurrentPlayer();
    }

    public Landable[] getLandableList() {
        return landableList;
    }
}
