package GameLogic;

import sample.AssetManager;

enum LandableType {
    FUNCTIONAL_PLACE,
    ATALARS_ROOM,
    CARD_PLACE,
    CAFE,
    LAND
}

public abstract class Landable {
    //variables
    protected int index;
    protected Location location;
    protected Location[] location_available;
    protected LandableType type;

    double boardWidth;
    double boardHeight;

    public Landable(){
        setLocation();
    }

    public Location getLocation() {
        return location;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int i){
        index = i;
        setLocation();
    }

    public LandableType getType() {
        return type;
    }
    
    
    public void setLocation() {
        if (AssetManager.gameManager != null) {
            boardHeight = AssetManager.gameManager.gameScreenController.getBoardHeight();
            boardWidth = AssetManager.gameManager.gameScreenController.getBoardWidth();
        } else {
            boardHeight = 0;
            boardWidth = 0;
        }
        
        double widthNormalized = boardWidth / 929;
        double heightNormalized = boardWidth / 859;

        location = new Location(0, 0);
        switch (index) {
            case 0:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 1:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 2:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 3:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 4:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 5:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 6:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 7:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 8:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 9:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 10:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 11:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 12:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 13:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 14:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 15:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 16:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 17:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 18:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 19:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 20:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 21:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 22:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 23:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 24:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 25:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 26:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 27:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 28:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 29:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 30:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 31:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 32:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 33:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 34:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 35:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 36:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 37:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 38:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
            case 39:
                location.setX(widthNormalized * 1);
                location.setY(heightNormalized * 1);
                break;
        }
    }
}
