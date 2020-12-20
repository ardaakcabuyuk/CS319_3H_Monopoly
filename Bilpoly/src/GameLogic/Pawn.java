package GameLogic;

import javafx.scene.image.ImageView;

public class Pawn {

    private final String NAME;
    private ImageView image;
    private Location currentLocation;
    private PawnType type;
    private int currentLandableIndex;

    //constructor
    public Pawn(String name, PawnType pType) {
        this.NAME = name;
        this.type = pType;
        currentLandableIndex = 0;
    }

    //methods
    // This method moves the pawn in board order.
    //TODO will be implemented.
    public int movePawn(int index) {
        currentLandableIndex = index;
        return currentLandableIndex;
    }

    // GETTERS AND SETTERS

    public int getCurrentLandableIndex(){
        return currentLandableIndex;
    }
    public PawnType getType(){
        return type;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public ImageView getImage() {
        return image;
    }
}
