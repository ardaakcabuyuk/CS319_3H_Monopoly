package GameLogic;

import java.util.Arrays;

enum FunctionalPlaceType {
    NIZAMIYE,
    FREE_PARKING,
    GO_TO_ATALARS_ROOM,
    TAX
}

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
}
