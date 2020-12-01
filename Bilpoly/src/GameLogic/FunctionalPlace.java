package GameLogic;

import java.util.Arrays;

// enum for functional place type
enum FunctionalPlaceType {
    NIZAMIYE,
    FREE_PARKING,
    GO_TO_ATALARS_ROOM,
    TAX
}

// FunctionalPlace Class
public class FunctionalPlace extends Landable {
    //attributes
    private FunctionalPlaceType functionalPlaceType;

    //constructor
    public FunctionalPlace(FunctionalPlaceType functionalPlaceType, int index, Location location, Location[] location_available) {
        type = LandableType.FUNCTIONAL_PLACE;
        this.functionalPlaceType = functionalPlaceType;
        this.index = index;
        this.location = new Location(location.getX(), location.getY());
        this.location_available = Arrays.copyOf(location_available, location_available.length);
    }

    //methods

    // This method executes the functional place.
    // TODO will be implemented.
    public void executeFuctional(Player player){

    }

    //GETTERS AND SETTERS
}
