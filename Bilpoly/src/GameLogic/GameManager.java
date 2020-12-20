package GameLogic;

import javafx.scene.control.Button;
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
    private boolean timeMode;
    private int timeLimit;
    private boolean isGameOver;
    private AtalarsRoom atalarsRoom;

    public GameScreen gameScreenController;


    //constructor
    public GameManager(PlayerDeck playerDeck, Landable[] landableList, CardDeck cardDeck,
                       boolean timeMode, int timeLimit) {

        System.out.println("GameManager is initialized.");
        this.timer = new Timer();
        this.winner = null;
        this.freeParkingMoney = 0;
        this.landableList = landableList;
        this.playerDeck = playerDeck;
        this.cardDeck = cardDeck;
        this.dice = new Dice();
        diceRolled = false;
        this.timeMode = timeMode;
        this.timeLimit = timeLimit;
        this.isGameOver = false;

        this.atalarsRoom = (AtalarsRoom) landableList[10];

        System.out.println("GameManager is initialized.");

    }

    //methods
    // This method handles the game turn system.
    // TODO will be implemented.
    public void playGame(){
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
    }

    public void playTurnPreDice() {

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
        //if passes through nizamiye
        if (nextLandable.getIndex() - diceValue < 0)
            executeLandable(landableList[0]);
        executeLandable(nextLandable);
        diceRolled = false;
        System.out.println("player " + playerDeck.getCurrentPlayer().getName() + " rolled the dice: " + diceValue);
    }



    // This method executes the given land.
    // TODO will be implemented.
    public void executeLandable(Landable currentLandable){
        Player currentPlayer = playerDeck.getCurrentPlayer();
        boolean doNotGo = false;
        if(playerDeck.getCurrentPlayer().isTurn())
            doNotGo = true;

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

                System.out.println("before executeCard");
                System.out.println("currentCard.getInteractedPlayer(): " + currentCard.getInteractedPlayer().getName());
                currentCard.executeCard(this);
                break;

        }

        System.out.println("PLAY GAME CALLED");
        gameScreenController.enableRollDiceButton();
        if(!doNotGo)
            playGame();
        else
            playerDeck.getCurrentPlayer().setTurn(false);

    }

    public void executeBuyable(Landable currentLandable, Button button){
        System.out.println(button.getText());
        boolean doNotGo = false;
        if(playerDeck.getCurrentPlayer().isTurn())
            doNotGo = true;

        System.out.println("---executeBuyable()");
        String curPlayerName = getCurrentPlayer().getName();

        Player currentPlayer = playerDeck.getCurrentPlayer();
        switch (currentLandable.type){
            case LAND:
                Land currentLand = ((Land) currentLandable);
                if(currentLand.isBought() && button.getText().equals("Pay Rent") && !currentLand.isMortgaged()){ //if land is bought
                    if (getCurrentPlayer().getMoney() >= currentLand.getCurrentRent()) {
                        getCurrentPlayer().payRentLand(currentLand, currentLand.getOwner());
                        gameScreenController.addHistory(curPlayerName + " paid rent to " + currentLand.owner.getName() + " for " + currentLandable.getName());
                    }
                    else {
                        //warning
                        System.out.println("NOT ENOUGH MONEY " + getCurrentPlayer().howMuchPlayerIsShort(currentLand.getCurrentRent()));
                    }
                }
                else if(currentLand.isBought() && currentPlayer.getOwnedLands().contains(currentLand)){
                    break;
                }
                else if (button.getText().equals("Buy")){
                    // buy
                    if (getCurrentPlayer().getMoney() >= currentLand.getCost()) {
                        getCurrentPlayer().buyLand(currentLand);
                        gameScreenController.addHistory( curPlayerName + " bought " + currentLand.getName() + ".");
                    }
                    else {
                        System.out.println("NOT ENOUGH MONEY " + getCurrentPlayer().howMuchPlayerIsShort(currentLand.getCost()));
                        //warning
                    }
                }

                break;

            case CAFE:
                Cafe currentCafe = ((Cafe) currentLandable);
                if(currentCafe.isBought() && button.getText().equals("Pay Rent") && !currentCafe.isMortgaged()){ //if land is bought
                    if (getCurrentPlayer().payRentCafe(currentCafe, currentCafe.getOwner())) {
                        gameScreenController.addHistory(curPlayerName + " paid rent to " + currentCafe.owner.getName());
                    }
                    else {
                        //warning
                        System.out.println("NOT ENOUGH MONEY " + getCurrentPlayer().howMuchPlayerIsShort(currentCafe.getCost()));
                    }
                }
                else if(currentCafe.isBought() && currentPlayer.getOwnedLands().contains(currentCafe)){
                    // his land
                }
                else if (button.getText().equals("Buy")){
                    // buy
                    if (getCurrentPlayer().getMoney() >= currentCafe.getCost()) {
                        getCurrentPlayer().buyCafe(currentCafe);
                        gameScreenController.addHistory(curPlayerName + " bought " + currentCafe.getName() + ".");
                    }
                    else {
                        //warning
                        System.out.println("NOT ENOUGH MONEY " + getCurrentPlayer().howMuchPlayerIsShort(currentCafe.getCost()));
                    }
                }
                break;

            default:
                // error
        }
        gameScreenController.enableRollDiceButton();
        if(!doNotGo)
            playGame();
        else
            playerDeck.getCurrentPlayer().setTurn(false);
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
        playerDeck.getCurrentPlayer().setTurn(true);
        try {
            gameScreenController.movePawnImage(playerPawn.getImage(), index, playerPawn);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("CANNOT MOVE PAWN OF PLAYER WITH A CARD");
        }
    }

    public void movePlayerWithStep(int step) {
        Pawn playerPawn = playerDeck.getCurrentPlayer().getPawn();
        playerDeck.getCurrentPlayer().setTurn(true);
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
