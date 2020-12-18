package GameLogic;

public abstract class Buyable extends Landable {
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
            owner = player;
        }
    }
    public void sell() {
        if (isBought) {
            isBought = false;
            owner = null;
        }
    }
    public Player getOwner() { return owner; }
    public void mortgage() {
        if (isBought && !isMortgaged) {
            isMortgaged = true;
        }
    }
    public int getCost() {
        return cost;
    }

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

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public void setBought(boolean bought) {
        isBought = bought;
    }

    public boolean isMortgaged() {
        return isMortgaged;
    }

    public void setMortgaged(boolean mortgaged) {
        isMortgaged = mortgaged;
    }

}
