package GameLogic;

public abstract class Buyable extends Landable {
    //attributes
    protected String name;
    protected int cost;
    protected String owner;
    protected boolean isBought;
    protected boolean isMortgaged;

    //methods
    public void buy(String playerName) {
        if (!isBought) {
            isBought = true;
            owner = playerName;
        }
    }
    public void sell() {
        if (isBought) {
            isBought = false;
            owner = null;
        }
    }
    public String getOwner() { return owner; }
    public void mortgage() {
        if (isBought) {
            isMortgaged = true;
        }
    }
    public int getCost() { return cost; }
    public boolean isBought() { return isBought; }
}
