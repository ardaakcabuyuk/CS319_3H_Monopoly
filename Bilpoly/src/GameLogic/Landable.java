package GameLogic;
enum LandableType {
    FUNCTIONAL_PLACE,
    ATALARS_ROOM,
    CARD_PLACE,
    CAFE,
    LAND
};

public abstract class Landable {
    private int index;
    private Location location;
    private Location[] location_available;
    private LandableType type;
}
