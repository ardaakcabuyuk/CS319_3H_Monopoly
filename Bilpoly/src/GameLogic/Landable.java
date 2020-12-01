package GameLogic;
private enum LandableType {
    FunctionalPlace,
    AtalarsRoom,
    CardPlace,
    Cafe,
    Land
};

public abstract class Landable {
    private int index;
    private Location location;
    private Location[] location_available;

}
