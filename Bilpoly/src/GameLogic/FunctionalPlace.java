package GameLogic;

// enum for functional place type
enum FunctionalPlaceType {
    NIZAMIYE,
    FREE_PARKING,
    GO_TO_ATALARS_ROOM,
    FEE
}

public class FunctionalPlace extends Landable {
    //attributes
    private PlaceStrategy strategy;
    private FunctionalPlaceType functionalPlaceType;

    //constructor
    public FunctionalPlace(PlaceStrategy strategy) {
        type = LandableType.FUNCTIONAL_PLACE;
        if (strategy instanceof NizamiyeStrategy)
            functionalPlaceType = FunctionalPlaceType.NIZAMIYE;
        else if (strategy instanceof FreeParkingStrategy)
            functionalPlaceType = FunctionalPlaceType.FREE_PARKING;
        else if (strategy instanceof GoToAtalarStrategy)
            functionalPlaceType = FunctionalPlaceType.GO_TO_ATALARS_ROOM;
        else
            functionalPlaceType = FunctionalPlaceType.FEE;
        this.strategy = strategy;
    }

    //methods

    // This method executes the functional place.
    public void executeFunctional(GameManager mgr, Player player){
        strategy.executeFunctional(mgr, player);
    }

    public FunctionalPlaceType getFunctionalPlaceType() {
        return functionalPlaceType;
    }

    public PlaceStrategy getStrategy() {
        return strategy;
    }
}
