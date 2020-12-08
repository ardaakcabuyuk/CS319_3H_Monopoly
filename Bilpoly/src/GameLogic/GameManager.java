package GameLogic;

import java.util.*;

public class GameManager {

    //constants

    //variables
    private Timer timer;
    private Player winner;
    private int freeParkingMoney;
    //private GameScreen gameScreen;
    private Landable[] landableList;
    private PlayerDeck playerDeck;
    private CardDeck cardDeck;
    private Dice dice;
    private HistoryManager historyManager;
    //private GameOver gameOver;
    //private PauseMenu pauseMenu;


    //constructor
    public GameManager(//GameScreen gameScreen,
                       PlayerDeck playerDeck, Landable[] landableList, CardDeck cardDeck
                       //GameOver gameOver, PauseMenu pauseMenu
                        ){
        this.timer = new Timer();
        this.winner = null;
        this.freeParkingMoney = 0;
        //this.gameScreen = gameScreen;
        this.landableList = landableList;
        this.playerDeck = playerDeck;
        this.cardDeck = cardDeck;
        this.dice = new Dice();
        this.historyManager =  new HistoryManager();
        //this.gameOver =  new GameOver();
        //this.pauseMenu =  new PauseMenu();
    }

    //methods
    // This method handles the game turn system.
    // TODO will be implemented.
    /*
        playGame(){
        while(!isGameOver()){
            if(!currentPlayer.isTurn)
                currentPlayer = ...;
                playerDeck.updateDec();
            playTurn(Player currentPlayer)
        }
        gameOver.update();
        }
     */
    public void playGame(){}

    // This method handles the each turn for given player.
    // TODO will be implemented.
    /*
        playTurn(Player currentPlayer){

        wait for rollDice();
        rollDice();
        movePawn();

        executeLadable(Landlable land);

        history.update();
        gameScreen.update()
        }
     */
    public void playTurn(Player curPlayer){}

    // This method executes the given land.
    // TODO will be implemented.
    /*
        executeLadable(Landlable land){
        if land.type == card{
            cardn.executeCard()
        }
        else if land.type == funct
        else if land.type == land
            wait
        else if land.type == cafe
            wait
            if(bought)
                history.update();
        else if land.type == atalar
            history.update();
        else{

        }
        }
     */
    public void executeLandable(Landable landable){}


    //GETTERS AND SETTERS

}
