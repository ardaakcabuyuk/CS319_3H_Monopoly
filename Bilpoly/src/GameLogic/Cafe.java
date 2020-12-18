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
                int rentWith3, int rentWith4) {
        //buyable attributes
        this.name = name;
        this.cost = cost;
        owner = null;
        isBought = false;
        isMortgaged = false;

        //cafe attributes
        this.type = LandableType.CAFE;
        this.rentWith1 = rentWith1;
        this.rentWith2 = rentWith2;
        this.rentWith3 = rentWith3;
        this.rentWith4 = rentWith4;
        this.location = null;
        this.location_available = null;
    }
    //methods
    //TODO will be implemented
    public void showCard() {

    }

    //TODO will be implemented
    public void closeCard() {

    }

    public String getName(){
        return name;
    }
    public int getRentWith1() {
        return rentWith1;
    }

    public void setRentWith1(int rentWith1) {
        this.rentWith1 = rentWith1;
    }

    public int getRentWith2() {
        return rentWith2;
    }

    public void setRentWith2(int rentWith2) {
        this.rentWith2 = rentWith2;
    }

    public int getRentWith3() {
        return rentWith3;
    }

    public void setRentWith3(int rentWith3) {
        this.rentWith3 = rentWith3;
    }

    public int getRentWith4() {
        return rentWith4;
    }

    public void setRentWith4(int rentWith4) {
        this.rentWith4 = rentWith4;
    }


    /*
    @Override
    public void buy(String playerName) {
        super.buy();

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

     */

}
