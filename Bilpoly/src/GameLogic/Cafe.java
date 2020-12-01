package GameLogic;

import java.util.Arrays;

public class Cafe extends Buyable {
    //attributes
    private int rentWith1;
    private int rentWith2;
    private int rentWith3;
    private int rentWith4;

    //constructor
    public Cafe(String name, int cost, int rentWith1, int rentWith2,
                int rentWith3, int rentWith4, int index, Location location, Location[] location_available) {
        this.type = LandableType.CAFE;
        this.name = name;
        this.cost = cost;
        this.rentWith1 = rentWith1;
        this.rentWith2 = rentWith2;
        this.rentWith3 = rentWith3;
        this.rentWith4 = rentWith4;
        owner = null;
        isBought = false;
        isMortgaged = false;
        this.index = index;
        this.location = new Location(location.getX(), location.getY());
        this.location_available = Arrays.copyOf(location_available, location_available.length);
    }
    //methods
    //TODO will be implemented
    public void showCard() {

    }

    //TODO will be implemented
    public void closeCard() {

    }

    @Override
    public void buy(String playerName) {
        super.buy(playerName);
    }

    @Override
    public void sell() {
        super.sell();
    }

    //TODO should be improved
    @Override
    public void mortgage() {
        super.mortgage();
    }

    @Override
    public boolean isBought() { return super.isBought(); }

    @Override
    public int getCost() { return super.getCost(); }

    @Override
    public String getOwner() { return super.getOwner(); }

}
