package GameLogic;

import javafx.scene.paint.Color;
import sample.GameScreen;

import java.awt.*;
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
    private GoToAtalarsRoom atalarsRoom;

    //private GameOver gameOver;
    //private PauseMenu pauseMenu;
    //private GameScreen gameScreen;


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
        this.atalarsRoom = new GoToAtalarsRoom(0 ,0 ,null, null);
        //this.gameOver =  new GameOver();
        //this.pauseMenu =  new PauseMenu();
        //this.gameScreen = gameScreen;

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

        //while(!isGameOver){
            /*if(!playerDeck.getCurrentPlayer().isTurn()){
                playerDeck.nextPlayer();
                // update playerDeck UI
            }*/
            playTurn(new Player("arda", new Pawn("Ferrari", PawnType.FERRARI), 300, Color.RED));
        //}
        // gameOver.update();
    }


    // This method handles the each turn for given player.
    // TODO will be implemented.

    // wait for rollDice();
    // rollDice();
    // movePawn();
    // executeLadable(Landlable land);
    // history.update();
    // gameScreen.update()

    public void playTurn(Player curPlayer) {

        if (curPlayer.isInAtalarsRoom()) {
            atalarsRoom.tryToGetOut(curPlayer);
            return;
        }

        //TODO CANIM ARKADAŞLARIM BURAYI YAPIN
        /*while (true) {
            if (diceRolled) {
                int diceValue = dice.getTotalFaceValue();
                //int pawnNewIndex = curPlayer.getPawn().movePawn(diceValue, landableList.length);
                //executeLandable(landableList[pawnNewIndex], curPlayer);
                diceRolled = false;
                System.out.println("player " + curPlayer.getName() + " rolled the dice: " + diceValue);
                break;
            }
        }*/
    }



    // This method executes the given land.
    // TODO will be implemented.

    // executeLadable(Landlable land){
    //    if land.type == card{
    //        cardn.executeCard()
    //    }
    //    else if land.type == funct
    //    else if land.type == land
    //        wait
    //    else if land.type == cafe
    //        wait
    //        if(bought)
    //            history.update();
    //    else if land.type == atalar
    //        history.update();
    //    else{
    //    }
    // }

    public void executeLandable(Landable landable, Player curPlayer){
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

                atalarsRoom.goToAtalarsRoom(curPlayer);

                break;



            default:
                // error
        }
    }


    //GETTERS AND SETTERS
    public int[] rollDice()  {
        dice.rollDice();
        int val1 = dice.getDie1FaceValue();
        int val2 = dice.getTotalFaceValue() - val1;
        int[] values = {val1, val2};
        diceRolled = true;
        return values;
    }
}
