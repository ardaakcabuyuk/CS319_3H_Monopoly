package GameLogic;

import java.util.Arrays;

public class Land extends Buyable {
    //attributes

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
