package GameLogic;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import javafx.scene.paint.Color;

//Player Class
public class Player {

    //variables
    private String name;
    private Color color;
    private String colorName;
    private Pawn pawn;
    private int money;
    private int score;
    private boolean isTurn;
    private boolean isBankrupt;
    private boolean isInAtalarsRoom;
    private int atalarsRoomFreeCardNum;
    private ArrayList<Land> ownedLands;
    private ArrayList<Cafe> ownedCafes;


    //constructor
    public Player(String name, Pawn pawn, int initMoney, String colorName){
        this.name = name;
        this.pawn = pawn;
        this.money = initMoney;
        this.score = 0;
        this.isTurn = false;
        this.isBankrupt = false;
        this.isInAtalarsRoom = false;
        this.atalarsRoomFreeCardNum = 0;
        this.ownedLands =  new ArrayList<Land>();
        this.ownedCafes = new ArrayList<Cafe>();

        if(colorName == "blue")
        {
            color = Color.BLUE;
        }
        else if(colorName == "purple")
        {
            color = Color.PURPLE;
        }
        else if(colorName == "green")
        {
            color = Color.GREEN;
        }
        else if(colorName == "red")
        {
            color = Color.RED;
        }


    }
    public Player(){
        this.name = "";
        this.pawn = null;
        this.money = 0;
        this.score = 0;
        this.isTurn = false;
        this.color = null;
        this.colorName = "init";
        this.isBankrupt = false;
        this.isInAtalarsRoom = false;
        this.atalarsRoomFreeCardNum = 0;
        this.ownedLands =  new ArrayList<Land>();
        this.ownedCafes = new ArrayList<Cafe>();
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

    // This method buys a land for player.
    // TODO land has to change and this method has to be implemented.
    public boolean buyLand(Land land){
        //check if the cafe is avaliable
        if (!land.isBought()) {
            if (money >= land.getCost()) {
                land.buy(this);
                changeMoney(-land.getCost());
                ownedLands.add(land);
                return true;
            }
            //TODO Warning insufficient funds
            return false;
        }
        return false;
    }

    // This method buys a cafe for player.
    // TODO cafe has to change and this method has to be implemented.
    public boolean buyCafe(Cafe cafe){
        //check if the cafe is avaliable
        if (!cafe.isBought()) {
            if (money >= cafe.getCost()) {
                cafe.buy(this);
                changeMoney(-cafe.getCost());
                ownedCafes.add(cafe);
                return true;
            }
            return false;
        }
        return false;
    }

    // This method sells a land for player.
    // TODO land has to change and this method has to be implemented.
    public boolean sellLand(Land land){
        //check if the land owned by this player
        land.sell();
        //delete land from the ownedLands
        //changeMoney();
        return true;
    }

    // This method sells a cafe for player.
    // TODO cafe has to change and this method has to be implemented.
    public boolean sellCafe(Cafe cafe){
        //check if the cafe owned by this player
        cafe.sell();
        //delete cafe from the ownedCafes
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

    public boolean isEqual(Player p) {
        if (color.equals(p.color))
            return true;
        return false;
    }

    // getter name
    public String getName() { return name; }

    // getter pawn
    public Pawn getPawn() { return pawn; }

    // getter color
    public Color getColor() { return color; }

    // getter ownedLands
    public ArrayList<Land> getOwnedLands() { return ownedLands; }

    // getter ownedCafes
    public ArrayList<Cafe> getOwnedCafes() { return ownedCafes; }

    public int getMoney() {
        return money;
    }

    public int getScore() {
        return score;
    }

    // set name
    public void setName(String name1) { name = name1; }
    // set pawn
    public void setPawn(Pawn pawn1) { pawn = pawn1; }
    // set color
    public void setColor(String colorName) {
        this.colorName = colorName;
        if(colorName == "blue")
        {
            color = Color.BLUE;
        }
        else if(colorName == "purple")
        {
            color = Color.PURPLE;
        }
        else if(colorName == "green")
        {
            color = Color.GREEN;
        }
        else if(colorName == "red")
        {
            color = Color.RED;
        }
    }

    public void setInitMoney(int money) { this.money = money; }

    public String getColorName() { return colorName; }



}
