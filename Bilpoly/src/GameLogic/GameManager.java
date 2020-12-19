package GameLogic;

//import sample.Images.pawns.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.AssetManager;
import sample.GameScreen;
import java.io.IOException;
import java.util.*;

public class GameManager {

    //constants


    //variables
    private Timer timer;
    private Player winner;
    protected int freeParkingMoney;
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
                        ) {

        System.out.println("GameManager is initialized.");
        this.timer = new Timer();
        this.winner = null;
        this.freeParkingMoney = 0;
        this.landableList = landableList;
        this.playerDeck = playerDeck;
        this.playerDeck.nextPlayer();
        this.cardDeck = cardDeck;
        this.dice = new Dice();
        diceRolled = false;
        this.historyManager =  new HistoryManager();
        this.timeMode = timeMode;
        this.timeLimit = timeLimit;
        this.isGameOver = false;


        // TODO fix initilization
        this.atalarsRoom = (AtalarsRoom) landableList[10];
        //this.gameOver =  new GameOver();
        //this.pauseMenu =  new PauseMenu();
        //this.gameScreen = gameScreen;

        System.out.println("GameManager is initialized.");

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

        if(!playerDeck.getCurrentPlayer().isTurn() && !isGameOver){
            playerDeck.nextPlayer();
            gameScreenController.changePlayerLabels(playerDeck.getCurrentPlayer());
            try {
                //System.out.println("---------------curPlayer: " + playerDeck.getCurrentPlayer().getName());
                playTurnPreDice();
            } catch (Exception e){
                System.out.println(e);
            }
        }
        // gameOver.update();
    }


    // This method handles the each turn for given player.
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
    }

    public int[] rollDice() {
            dice.rollDice();
            int val1 = dice.getDie1FaceValue();
            int val2 = dice.getTotalFaceValue() - val1;
            int[] values = {val1, val2};
            diceRolled = true;
            return values;

    }

    public void playTurnPostDice(Landable nextLandable){
        System.out.println("playTurnPostDice");
        System.out.println("nextLandable.getType(): " + nextLandable.getType());
        int diceValue = dice.getTotalFaceValue();
        //int pawnNewIndex = curPlayer.getPawn().movePawn(diceValue, landableList.length);
        //if passes through nizamiye
        if (getCurrentPlayer().getPawn().getCurrentLandableIndex() + diceValue >= 40)
            executeLandable(landableList[0]);
        executeLandable(nextLandable);
        diceRolled = false;
        System.out.println("player " + playerDeck.getCurrentPlayer().getName() + " rolled the dice: " + diceValue);
    }



    // This method executes the given land.
    // TODO will be implemented.
    public void executeLandable(Landable currentLandable){
        Player currentPlayer = playerDeck.getCurrentPlayer();

        switch (currentLandable.type){
            case FUNCTIONAL_PLACE:
                // i have no idea what to do here -ömer
                break;
            default:
                // error
        }


    //    if (gameScreenController.doneClicked)
     //   {
      //      System.out.println("done clicked");
            gameScreenController.enableRollDiceButton();
            playGame();
        //}
    }

    public void executeBuyable(Landable currentLandable, Button button){

        System.out.println("---executeBuyable()");

        Player currentPlayer = playerDeck.getCurrentPlayer();
        switch (currentLandable.type){
            case LAND:
                Land currentLand = ((Land) currentLandable);
                if(currentLand.isBought() && button.getText() == "Pay Rent"){ //if land is bought
                    AssetManager.gameManager.getCurrentPlayer().changeMoney(-currentLand.getCurrentRent());
                }
                else if(currentLand.isBought()){
                    // his land
                }
                else{
                    // buy
                    AssetManager.gameManager.getCurrentPlayer().changeMoney(-currentLand.getCost());
                    currentLand.isBought = true;
                    currentLand.owner = AssetManager.gameManager.getCurrentPlayer();
                    currentPlayer.getOwnedLands().add(currentLand);
                }

                break;


            case CAFE:
                Cafe currentCafe = ((Cafe) currentLandable);
                if(currentCafe.isBought() && button.getText() == "Pay Rent"){ //if land is bought
                    int cafeNum = currentCafe.owner.getOwnedCafes().size();
                    if(cafeNum == 1)
                        AssetManager.gameManager.getCurrentPlayer().changeMoney(-currentCafe.getRentWith1());
                    else if (cafeNum == 2)
                        AssetManager.gameManager.getCurrentPlayer().changeMoney(-currentCafe.getRentWith2());
                    else if (cafeNum == 3)
                        AssetManager.gameManager.getCurrentPlayer().changeMoney(-currentCafe.getRentWith3());
                    else if (cafeNum == 4)
                        AssetManager.gameManager.getCurrentPlayer().changeMoney(-currentCafe.getRentWith4());
                }
                else if(currentCafe.isBought()){
                    // his land
                }
                else{
                    // buy
                    AssetManager.gameManager.getCurrentPlayer().changeMoney(-currentCafe.getCost());
                    currentCafe.isBought = true;
                    currentCafe.owner = AssetManager.gameManager.getCurrentPlayer();
                    currentPlayer.getOwnedCafes().add(currentCafe);
                }

                break;


            case CARD_PLACE:

                System.out.println("Execute Card Place");

                break;

            default:
                // error
        }

        gameScreenController.enableRollDiceButton();
        playGame();

    }

    public void sendPlayerToAtalarsRoom(Player p) {
        atalarsRoom.goToAtalarsRoom(p);
        try {
            gameScreenController.movePawnImage(p.getPawn().getImage(), atalarsRoom.getIndex(), p.getPawn());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //GETTERS AND SETTERS
    public Player getCurrentPlayer(){
        return playerDeck.getCurrentPlayer();
    }

    public Landable[] getLandableList() {
        return landableList;
    }

    public void setLandableListLocations(){
        for(int i = 0; i < landableList.length; i++){
            landableList[i].setLocation();
        }
    }

    public ArrayList<Player> getPlayers(){
        return playerDeck.getPlayerList();
    }

    public void movePlayerTo(int index) {
        Pawn playerPawn = playerDeck.getCurrentPlayer().getPawn();
        try {
            gameScreenController.movePawnImage(playerPawn.getImage(), index, playerPawn);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CANNOT MOVE PAWN OF PLAYER WITH A CARD");
        }
    }

    public void movePlayerWithStep(int step) {
        Pawn playerPawn = playerDeck.getCurrentPlayer().getPawn();
        try {
            gameScreenController.movePawnImage(playerPawn.getImage(), (playerPawn.getCurrentLandableIndex() + step) % 40, playerPawn);
            if (playerPawn.getCurrentLandableIndex() + step >= 40)
                executeLandable(landableList[0]);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CANNOT MOVE PAWN OF PLAYER WITH A CARD");
        }
    }

    public CardDeck getCardDeck() {
        return cardDeck;
    }

}
