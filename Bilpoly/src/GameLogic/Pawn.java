package GameLogic;

import javafx.scene.image.ImageView;

public class Pawn {
    private final String NAME;
    private ImageView image;
    private Location currentLocation;

    //constructor
    public Pawn(String name, ImageView image) {
        this.NAME = name;
    }

    //methods
    // This method moves the pawn in board order.
    //TODO will be implemented.
    public void movePawn(int move) {
    }

    // This method moves the pawn randomly.
    //TODO will be implemented.
    public void goTo(Landable land) {
    }

    // GETTERS AND SETTERS

}