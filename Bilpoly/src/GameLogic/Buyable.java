package GameLogic;

public abstract class Buyable extends Landable {

    //constants
    protected final double mortgageRate = 1.1;

    //attributes
    protected String name;
    protected int cost;
    protected Player owner;



    protected boolean isBought;
    protected boolean isMortgaged;

    //methods
    public void buy(Player player) {
        if (!isBought) {
            isBought = true;
            isMortgaged = false;
            owner = player;
        }
    }
    public void sell() {
        if (isBought) {
            isBought = false;
            isMortgaged = false;
            owner = null;
        }
    }

    public boolean mortgage() {
        if (isBought && !isMortgaged) {
            isMortgaged = true;
            return true;
        }
        return false;
    }

    public boolean unMortgage() {
        if (isMortgaged) {
            isMortgaged = false;
            return true;
        }
        return false;
    }

    public int getCost() {
        return cost;
    }

    public Player getOwner() { return owner; }

    public boolean isBought() {
        return isBought;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public double getMortgageRate() {
        return mortgageRate;
    }

}
