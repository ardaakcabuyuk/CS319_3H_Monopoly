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
    //constants
    private final LandableType TYPE = LandableType.FUNCTIONAL_PLACE;

    //attributes
    private FunctionalPlaceType type;
    private int index;
    private Location location;
    private Location[] location_available;


    //constructor
    public FunctionalPlace(FunctionalPlaceType type, int index, Location location, Location[] location_available) {
        this.type = type;
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
