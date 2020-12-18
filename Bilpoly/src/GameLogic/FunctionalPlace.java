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
    private PlaceStrategy strategy;

    //constructor
    public FunctionalPlace(PlaceStrategy strategy) {
        type = LandableType.FUNCTIONAL_PLACE;
        this.strategy = strategy;
        this.location = null;
        this.location_available = null;
    }

    //methods

    // This method executes the functional place.
    // TODO will be implemented.
    public void executeFunctional(GameManager mgr, Player player){
        strategy.executeFunctional(mgr, player);
    }

    //GETTERS AND SETTERS
}
