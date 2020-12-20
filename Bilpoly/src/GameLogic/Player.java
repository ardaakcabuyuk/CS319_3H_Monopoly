package GameLogic;

import java.util.ArrayList;
import java.util.HashMap;

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
    private HashMap<Color,Integer> sets;


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
        this.ownedLands = new ArrayList<>();
        this.ownedCafes = new ArrayList<>();

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

        sets = new HashMap<Color, Integer>();
        sets.put(Color.BROWN, 0);
        sets.put(Color.LIGHTSKYBLUE, 0);
        sets.put(Color.HOTPINK, 0);
        sets.put(Color.ORANGE, 0);
        sets.put(Color.RED, 0);
        sets.put(Color.YELLOW, 0);
        sets.put(Color.LIMEGREEN, 0);
        sets.put(Color.DARKBLUE, 0);

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
        this.sets = new HashMap<Color, Integer>();
        sets.put(Color.BROWN, 0);
        sets.put(Color.LIGHTSKYBLUE, 0);
        sets.put(Color.HOTPINK, 0);
        sets.put(Color.ORANGE, 0);
        sets.put(Color.RED, 0);
        sets.put(Color.YELLOW, 0);
        sets.put(Color.LIMEGREEN, 0);
        sets.put(Color.DARKBLUE, 0);
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
                sets.put(land.getCOLOR(), sets.get(land.getCOLOR()) + 1);
                for (Color key : sets.keySet()) {
                    System.out.println("Color: " + key.toString() + "Quantity:" + sets.get(key).toString());
                }
                if (isBoughtSet(land.getCOLOR())) {
                    for (int i = 0; i < ownedLands.size(); i++) {
                        if (ownedLands.get(i).getCOLOR() == land.getCOLOR()) {
                            ownedLands.get(i).increaseRent();
                        }
                    }
                }
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
    public boolean sellLand(Land land) {
        if (!ownedLands.contains(land))
            return false;
        land.sell();
        ownedLands.remove(land);
        changeMoney(land.getCost());
        return true;
    }

    // This method sells a cafe for player.
    // TODO cafe has to change and this method has to be implemented.
    public boolean sellCafe(Cafe cafe) {
       if (!ownedCafes.contains(cafe))
           return false;
       cafe.sell();
       ownedCafes.remove(cafe);
       changeMoney(cafe.getCost());
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

    public boolean payRentLand(Land land, Player p) {
        if (changeMoney(-land.getCurrentRent())) {
            p.changeMoney(land.getCurrentRent());
            return true;
        }
        return false;
    }

    public boolean payRentCafe(Cafe cafe, Player p) {
        int cafeNum = cafe.getOwner().getOwnedCafes().size();
        int curRent;
        if(cafeNum == 1) {
            curRent = cafe.getRentWith1();
        }
        else if (cafeNum == 2) {
            curRent = cafe.getRentWith2();
        }
        else if (cafeNum == 3) {
            curRent = cafe.getRentWith3();
        }
        else {
            curRent = cafe.getRentWith4();
        }

        if (changeMoney(-curRent)) {
            p.changeMoney(curRent);
            return true;
        }
        return false;

    }

    public boolean isBoughtSet(Color color) {
        if (color.equals(Color.BROWN) || color.equals(Color.DARKBLUE)) {
            if (sets.get(color) == 2)
                return true;
        }
        else {
            if (sets.get(color) == 3)
                return true;
        }
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
