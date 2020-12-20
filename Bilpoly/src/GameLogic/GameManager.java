package GameLogic;

//import sample.Images.pawns.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import sample.GameScreen;
import java.io.IOException;
import java.util.*;

public class GameManager {

    //constants
    private final int TUITION_FEE = 0;
    private final int DORM_FEE = 0;
    private final int BOOK_FEE = 0;
    private final int FOOD_FEE = 0;
    private final int NIZAMIYE_FEE = 0;


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
            gameScreenController.setNextTurn(playerDeck.getNextPlayer().getName(), String.valueOf(playerDeck.getNextPlayer().getMoney()), playerDeck.getNextPlayer().getPawn());
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

        switch (currentLandable.type) {
            case FUNCTIONAL_PLACE:
                FunctionalPlace fPlace = ((FunctionalPlace) currentLandable);
                fPlace.executeFunctional(this, currentPlayer);
                if (fPlace.getFunctionalPlaceType() == FunctionalPlaceType.NIZAMIYE)
                    gameScreenController.addHistory(getCurrentPlayer().getName() + " has passed through Nizamiye.");
                else if (fPlace.getFunctionalPlaceType() == FunctionalPlaceType.FEE) {
                    if (((FeeStrategy) fPlace.getStrategy()).getFeeType() == FeeType.TUITION_FEE) {
                        gameScreenController.addHistory(getCurrentPlayer().getName() + " paid tuition fee.");
                    }
                    else if (((FeeStrategy) fPlace.getStrategy()).getFeeType() == FeeType.DORM_FEE) {
                        gameScreenController.addHistory(getCurrentPlayer().getName() + " paid dorm fee.");
                    }
                    else if (((FeeStrategy) fPlace.getStrategy()).getFeeType() == FeeType.BOOK_FEE) {
                        gameScreenController.addHistory(getCurrentPlayer().getName() + " paid book fee.");
                    }
                    else if (((FeeStrategy) fPlace.getStrategy()).getFeeType() == FeeType.FOOD_FEE) {
                        gameScreenController.addHistory(getCurrentPlayer().getName() + " paid food fee.");
                    }
                    freeParkingMoney += ((FeeStrategy) fPlace.getStrategy()).getFee();
                }
                else if (fPlace.getFunctionalPlaceType() == FunctionalPlaceType.FREE_PARKING) {
                    gameScreenController.addHistory(getCurrentPlayer().getName() + " got free parking money.");
                    freeParkingMoney = 0;
                }
                else if (fPlace.getFunctionalPlaceType() == FunctionalPlaceType.GO_TO_ATALARS_ROOM) {
                    gameScreenController.addHistory(getCurrentPlayer().getName() + " went to Atalar's Room!");
                }
                break;
            case CARD_PLACE:
                CardPlace cPlace = ((CardPlace) currentLandable);
                Card currentCard = gameScreenController.getPickedCard();
                currentCard.setInteractedPlayer(currentPlayer);
                currentCard.executeCard(this);
                System.out.println("-----Card Info-----");
                System.out.println("Text: " + currentCard.getText());
                System.out.println("NO: " + currentCard.getCARDNUM());
                System.out.println("STRATEGY: " + currentCard.getCardStrategy());
                System.out.println("PLAYER NAME: " + currentCard.getInteractedPlayer().getName());
                System.out.println("MOVE TO: " + currentCard.getMoveTo());
                System.out.println("TO EARN: " + currentCard.getToEarn());
                System.out.println("TO PAY: " + currentCard.getToPay());
                System.out.println("TO MOVE: " + currentCard.getToMove());
                System.out.println("TO PLAYER?: " + currentCard.isToPlayer());
                System.out.println("TO BANK?: " + currentCard.isToBank());

                //card = cardDeck.drawCard(((CardPlace)currentLandable).getCardType());
                //card.setInteractedPlayer(currentPlayer);
                //card.executeCard(this);

                break;

        }

        System.out.println("PLAY GAME CALLED");
        gameScreenController.enableRollDiceButton();
        playGame();

    }

    public void executeBuyable(Landable currentLandable, Button button){

        System.out.println("---executeBuyable()");
        String curPlayerName = getCurrentPlayer().getName();

        Player currentPlayer = playerDeck.getCurrentPlayer();
        switch (currentLandable.type){
            case LAND:
                Land currentLand = ((Land) currentLandable);
                if(currentLand.isBought() && button.getText() == "Pay Rent"){ //if land is bought
                    getCurrentPlayer().changeMoney(-currentLand.getCurrentRent());
                    gameScreenController.addHistory( curPlayerName + " paid rent " + currentLand.owner.getName());
                    currentLand.getOwner().changeMoney(currentLand.getCurrentRent());
                }
                else if(currentLand.isBought() && currentPlayer.getOwnedLands().contains(currentLand)){
                    break;
                }
                else{
                    // buy
                    getCurrentPlayer().changeMoney(-currentLand.getCost());
                    currentLand.isBought = true;
                    currentLand.owner = getCurrentPlayer();
                    currentPlayer.getOwnedLands().add(currentLand);
                    gameScreenController.addHistory( curPlayerName + " bought " + currentLand.getName() + ".");
                    for (int i = 0; i < getCurrentPlayer().getOwnedLands().size(); i++) {
                        System.out.println(getCurrentPlayer().getOwnedLands().get(i).getName());
                    }
                }

                break;

            case CAFE:
                Cafe currentCafe = ((Cafe) currentLandable);
                if(currentCafe.isBought() && button.getText() == "Pay Rent"){ //if land is bought
                    int cafeNum = currentCafe.owner.getOwnedCafes().size();
                    if(cafeNum == 1)
                        getCurrentPlayer().changeMoney(-currentCafe.getRentWith1());
                    else if (cafeNum == 2)
                        getCurrentPlayer().changeMoney(-currentCafe.getRentWith2());
                    else if (cafeNum == 3)
                        getCurrentPlayer().changeMoney(-currentCafe.getRentWith3());
                    else if (cafeNum == 4)
                        getCurrentPlayer().changeMoney(-currentCafe.getRentWith4());
                    gameScreenController.addHistory( curPlayerName + " paid rent to " + currentCafe.owner.getName());
                }
                else if(currentCafe.isBought() && currentPlayer.getOwnedLands().contains(currentCafe)){
                    // his land
                }
                else{
                    // buy
                    getCurrentPlayer().changeMoney(-currentCafe.getCost());
                    currentCafe.isBought = true;
                    currentCafe.owner = getCurrentPlayer();
                    currentPlayer.getOwnedCafes().add(currentCafe);
                    gameScreenController.addHistory( curPlayerName + " bought " + currentCafe.getName() + ".");
                    for (int i = 0; i < getCurrentPlayer().getOwnedCafes().size(); i++) {
                        System.out.println(getCurrentPlayer().getOwnedCafes().get(i).getName());
                    }
                }

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
            if (playerPawn.getCurrentLandableIndex() + step > 40)
                getCurrentPlayer().changeMoney(NIZAMIYE_FEE);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CANNOT MOVE PAWN OF PLAYER WITH A CARD");
        }
    }


    public CardDeck getCardDeck() {
        return cardDeck;
    }
}
