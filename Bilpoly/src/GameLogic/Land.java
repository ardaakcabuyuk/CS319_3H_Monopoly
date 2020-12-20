package GameLogic;

import javafx.scene.paint.Color;

import java.util.Arrays;

public class Land extends Buyable {

    //constants
    private final int MAX_SECONDARY = 3;
    private final int RENT;                 //help in CS
    private final int RENT_WITH_SET;
    private final int RENT_WITH_1_SECONDARY;
    private final int RENT_WITH_2_SECONDARY;
    private final int RENT_WITH_3_SECONDARY;
    private final int RENT_WITH_PRIMARY;
    private final Color COLOR;

    private final int PRIMARY_COST;         //Bilka || A+
    private final int SECONDARY_COST;       //Starbucks || Assignment


    //attributes
    private int secondaryNumber;
    private boolean hasPrimary;
    private int currentRent;
    private int mortgageRate;


    public Land(Color color, String name, int cost, int secondaryCost, int primaryCost, int rent,
                int rentWithSet, int rentWith1Secondary, int rentWith2Secondary,
                int rentWith3Secondary, int rentWithPrimary) {
        //buyable attributes
        this.name = name;
        this.cost = cost;
        owner = null;
        isBought = false;
        isMortgaged = false;

        //land attributes
        this.type = LandableType.LAND;
        COLOR = color;
        PRIMARY_COST = primaryCost;
        SECONDARY_COST = secondaryCost;
        RENT = rent;
        RENT_WITH_SET = rentWithSet;
        RENT_WITH_1_SECONDARY = rentWith1Secondary;
        RENT_WITH_2_SECONDARY = rentWith2Secondary;
        RENT_WITH_3_SECONDARY = rentWith3Secondary;
        RENT_WITH_PRIMARY = rentWithPrimary;
        secondaryNumber = 0;
        hasPrimary = false;
        currentRent = RENT;
        this.index = index;
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

    /*

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


    public boolean addSecondary() {
        if (secondaryNumber < MAX_SECONDARY) {
            secondaryNumber++;
            increaseRent();
            return true;
        }
        return false;
    }

    public boolean addPrimary() {
        if (secondaryNumber == MAX_SECONDARY && !hasPrimary) {
            hasPrimary = true;
            increaseRent();
            return true;
        }
        return false;
    }

    public boolean sellSecondary() {
        if (secondaryNumber > 0) {
            secondaryNumber--;
            decreaseRent();
            return true;
        }
        return false;
    }

    public boolean sellPrimary() {
        if (hasPrimary) {
            hasPrimary = false;
            decreaseRent();
            return true;
        }
        return false;
    }

    public void increaseRent() {
        if (currentRent == RENT)
            currentRent = RENT_WITH_SET;
        else if (currentRent == RENT_WITH_SET)
            currentRent = RENT_WITH_1_SECONDARY;
        else if (currentRent == RENT_WITH_1_SECONDARY)
            currentRent = RENT_WITH_2_SECONDARY;
        else if (currentRent == RENT_WITH_2_SECONDARY)
            currentRent = RENT_WITH_3_SECONDARY;
        else if (currentRent == RENT_WITH_3_SECONDARY)
            currentRent = RENT_WITH_PRIMARY;
    }

    public void decreaseRent() {
        if (currentRent == RENT_WITH_SET )
            currentRent = RENT;
        else if (currentRent == RENT_WITH_1_SECONDARY)
            currentRent = RENT_WITH_SET;
        else if (currentRent == RENT_WITH_2_SECONDARY)
            currentRent = RENT_WITH_1_SECONDARY;
        else if (currentRent == RENT_WITH_3_SECONDARY)
            currentRent = RENT_WITH_2_SECONDARY;
        else if (currentRent == RENT_WITH_PRIMARY)
            currentRent = RENT_WITH_3_SECONDARY;
    }

    public Color getLandSet() { return COLOR; }
    
    public int getMAX_SECONDARY() {
        return MAX_SECONDARY;
    }

    public int getRENT() {
        return RENT;
    }

    public int getRENT_WITH_SET() {
        return RENT_WITH_SET;
    }

    public int getRENT_WITH_1_SECONDARY() {
        return RENT_WITH_1_SECONDARY;
    }

    public int getRENT_WITH_2_SECONDARY() {
        return RENT_WITH_2_SECONDARY;
    }

    public int getRENT_WITH_3_SECONDARY() {
        return RENT_WITH_3_SECONDARY;
    }

    public int getRENT_WITH_PRIMARY() {
        return RENT_WITH_PRIMARY;
    }

    public Color getCOLOR() {
        return COLOR;
    }

    public int getPRIMARY_COST() {
        return PRIMARY_COST;
    }

    public int getSECONDARY_COST() {
        return SECONDARY_COST;
    }

    public int getSecondaryNumber() {
        return secondaryNumber;
    }

    public void setSecondaryNumber(int secondaryNumber) {
        this.secondaryNumber = secondaryNumber;
    }

    public boolean isHasPrimary() {
        return hasPrimary;
    }

    public void setHasPrimary(boolean hasPrimary) {
        this.hasPrimary = hasPrimary;
    }

    public int getCurrentRent() {
        return currentRent;
    }

    public void setCurrentRent(int currentRent) {
        this.currentRent = currentRent;
    }

    public int getMortgageRate() {
        return mortgageRate;
    }

    public void setMortgageRate(int mortgageRate) {
        this.mortgageRate = mortgageRate;
    }


}
