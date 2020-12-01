package GameLogic;

public interface Buyable {
    //methods
    public boolean buy();
    public boolean sell();
    public Player getOwner();
    public boolean mortgage();
}
