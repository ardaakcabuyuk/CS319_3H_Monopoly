package GameLogic;

import java.util.Arrays;

public class Cafe extends Landable {
    //attributes
    private String name;
    private int cost;
    private int rentWith1;
    private int rentWith2;
    private int rentWith3;
    private int rentWith4;
    private Player owner;
    private boolean isBought;
    private boolean isMortgaged;

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
    //TODO should be improved
    public boolean mortgage() {
        if (isBought) {
            isMortgaged = true;
            return true;
        }
        return false;
    }

    //TODO will be implemented
    public void showCard() {

    }

    //TODO will be implemented
    public void closeCard() {

    }

}
