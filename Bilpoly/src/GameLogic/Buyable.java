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
    public int getCost() { return cost; }
    public boolean isBought() { return isBought; }
}
