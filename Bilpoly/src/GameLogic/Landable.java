package GameLogic;

enum LandableType {
    FUNCTIONAL_PLACE,
    GO_TO_ATALARS_ROOM,
    CARD_PLACE,
    CAFE,
    LAND
};

public abstract class Landable {
    //variables
    protected int index;
    protected Location location;
    protected Location[] location_available;
    protected LandableType type;
}
