package GameLogic;

import java.awt.*;
import java.util.ArrayList;

//Player Class
public class Player {

    //constants
    private final String NAME;
    private final Color COLOR;

    //variables
    private Pawn pawn;
    private int money;
    private int score;
    private boolean isTurn;
    private boolean isBankrupt;
    private boolean isInAtalarsRoom;
    private int atalarsRoomFreeCardNum;
    private ArrayList<Buyable> ownedLands;

    //constructor
    public Player(String name, Pawn pawn, int initMoney, int initScore, boolean isTurn,
                  Color color){
        this.NAME = name;
        this.pawn = pawn;
        this.money = initMoney;
        this.score = initScore;
        this.isTurn = isTurn;
        this.COLOR = color;
        this.isBankrupt = false;
        this.isInAtalarsRoom = false;
        this.atalarsRoomFreeCardNum = 0;
        this.ownedLands =  new ArrayList<Buyable>();
    }

    //methods

    // This method will be called to update player's money.
    public boolean changeMoney(int amount){
        if(amount < 0 && this.money + amount < 0){
            return false;
        }
        else {
            this.money = this.money + amount;
            return true;
        }
    }

    // This method will be called when players money is not enough to perform changeMoney().
    // This method returns how much money the player is short.
    public int howMuchPlayerIsShort(int amount){
        if(amount < 0 && this.money + amount < 0)
            return this.money + amount;
        else
            return 0;
    }

    // This method buys a buyable for player.
    // TODO Buyable has to change and this method has to be implemented.
    public boolean buyLandOrCafe(Buyable buyable){
        //check if the buyable is avaliable
        buyable.buy();
        //add buyable to the ownedLands
        //changeMoney();
        return true;
    }

    // This method sells a buyable for player.
    // TODO Buyable has to change and this method has to be implemented.
    public boolean sellLandOrCafe(Buyable buyable){
        //check if the buyable owned by this player
        buyable.sell();
        //delete buyable from the ownedLands
        //changeMoney();
        return true;
    }

    // This method will be called to update player's score.
    public void updateScore(int amount){
        this.score = this.score + amount;
    }

    //GETTERS AND SETTERS
    // getter isTurn
    public boolean isTurn() { return isTurn; }
    // setter isTurn
    public void setTurn(boolean turn) { isTurn = turn; }

    // getter isBankrupt
    public boolean isBankrupt() { return isBankrupt; }
    // setter isBankrupt
    public void setBankrupt(boolean bankrupt) { isBankrupt = bankrupt; }

    // getter isInAtalarsRoom
    public boolean isInAtalarsRoom() { return isInAtalarsRoom; }
    // setter isInAtalarsRoom
    public void setInAtalarsRoom(boolean inAtalarsRoom) { isInAtalarsRoom = inAtalarsRoom; }

    // getter atalarsRoomFreeCardNum
    public int getAtalarsRoomFreeCardNum() { return atalarsRoomFreeCardNum; }
    // setter atalarsRoomFreeCardNum
    public void setAtalarsRoomFreeCardNum(int atalarsRoomFreeCardNum) { this.atalarsRoomFreeCardNum = atalarsRoomFreeCardNum; }

    // getter name
    public String getName() { return NAME; }

    // getter pawn
    public Pawn getPawn() { return pawn; }

    // getter color
    public Color getColor() { return COLOR; }

    // getter ownedLands
    public ArrayList<Buyable> getOwnedLands() { return ownedLands; }
}
