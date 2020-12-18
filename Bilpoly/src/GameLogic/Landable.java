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
    protected String name;

    double boardWidth;
    double boardHeight;

    public Landable(){

    }

    public Location getLocation() {
        return location;
    }

    public int getIndex() {
        return index;
    }
    public void setIndex(int i){
        index = i;
    }

    public LandableType getType() {
        return type;
    }
    
    
    public void setLocation() {
        //System.out.println("AssetManager.gameManager: " + AssetManager.gameManager);
        if (AssetManager.gameManager != null) {
            boardHeight = AssetManager.gameManager.gameScreenController.getBoardHeight();
            boardWidth = AssetManager.gameManager.gameScreenController.getBoardWidth();
        } else {
            boardHeight = 0;
            boardWidth = 0;
        }
        
        double widthNormalized = boardWidth / 929;
        double heightNormalized = boardWidth / 940;
        //System.out.println("widthNormalized: " + widthNormalized + " boardWidth: " + boardWidth);

        location = new Location(0, 0);
        switch (index) {
            case 0:
                location.setX(widthNormalized * 856);
                location.setY(heightNormalized * 767);
                break;
            case 1:
                location.setX(widthNormalized * 752);
                location.setY(heightNormalized * 809);
                break;
            case 2:
                location.setX(widthNormalized * 678);
                location.setY(heightNormalized * 784);
                break;
            case 3:
                location.setX(widthNormalized * 596);
                location.setY(heightNormalized * 808);
                break;
            case 4:
                location.setX(widthNormalized * 521);
                location.setY(heightNormalized * 766);
                break;
            case 5:
                location.setX(widthNormalized * 446);
                location.setY(heightNormalized * 770);
                break;
            case 6:
                location.setX(widthNormalized * 364);
                location.setY(heightNormalized * 805);
                break;
            case 7:
                location.setX(widthNormalized * 292);
                location.setY(heightNormalized * 772);
                break;
            case 8:
                location.setX(widthNormalized * 213);
                location.setY(heightNormalized * 803);
                break;
            case 9:
                location.setX(widthNormalized * 134);
                location.setY(heightNormalized * 805);
                break;
            case 10:
                location.setX(widthNormalized * 9);
                location.setY(heightNormalized * 756);
                break;
            case 11:
                location.setX(widthNormalized * 11);
                location.setY(heightNormalized * 687);
                break;
            case 12:
                location.setX(widthNormalized * 50);
                location.setY(heightNormalized * 619);
                break;
            case 13:
                location.setX(widthNormalized * 13);
                location.setY(heightNormalized * 547);
                break;
            case 14:
                location.setX(widthNormalized * 13);
                location.setY(heightNormalized * 480);
                break;
            case 15:
                location.setX(widthNormalized * 50);
                location.setY(heightNormalized * 406);
                break;
            case 16:
                location.setX(widthNormalized * 12);
                location.setY(heightNormalized * 336);
                break;
            case 17:
                location.setX(widthNormalized * 43);
                location.setY(heightNormalized * 266);
                break;
            case 18:
                location.setX(widthNormalized * 12);
                location.setY(heightNormalized * 193);
                break;
            case 19:
                location.setX(widthNormalized * 15);
                location.setY(heightNormalized * 124);
                break;
            case 20:
                location.setX(widthNormalized * 31);
                location.setY(heightNormalized * 12);
                break;
            case 21:
                location.setX(widthNormalized * 134);
                location.setY(heightNormalized * 9);
                break;
            case 22:
                location.setX(widthNormalized * 212);
                location.setY(heightNormalized * 44);
                break;
            case 23:
                location.setX(widthNormalized * 286);
                location.setY(heightNormalized * 10);
                break;
            case 24:
                location.setX(widthNormalized * 362);
                location.setY(heightNormalized * 11);
                break;
            case 25:
                location.setX(widthNormalized * 442);
                location.setY(heightNormalized * 35);
                break;
            case 26:
                location.setX(widthNormalized * 516);
                location.setY(heightNormalized * 11);
                break;
            case 27:
                location.setX(widthNormalized * 595);
                location.setY(heightNormalized * 13);
                break;
            case 28:
                location.setX(widthNormalized * 673);
                location.setY(heightNormalized * 50);
                break;
            case 29:
                location.setX(widthNormalized * 749);
                location.setY(heightNormalized * 12);
                break;
            case 30:
                location.setX(widthNormalized * 832);
                location.setY(heightNormalized * 36);
                break;
            case 31:
                location.setX(widthNormalized * 872);
                location.setY(heightNormalized * 122);
                break;
            case 32:
                location.setX(widthNormalized * 872);
                location.setY(heightNormalized * 188);
                break;
            case 33:
                location.setX(widthNormalized * 843);
                location.setY(heightNormalized * 263);
                break;
            case 34:
                location.setX(widthNormalized * 870);
                location.setY(heightNormalized * 334);
                break;
            case 35:
                location.setX(widthNormalized * 817);
                location.setY(heightNormalized * 404);
                break;
            case 36:
                location.setX(widthNormalized * 836);
                location.setY(heightNormalized * 475);
                break;
            case 37:
                location.setX(widthNormalized * 869);
                location.setY(heightNormalized * 543);
                break;
            case 38:
                location.setX(widthNormalized * 818);
                location.setY(heightNormalized * 618);
                break;
            case 39:
                location.setX(widthNormalized * 868);
                location.setY(heightNormalized * 686);
                break;
        }
    }
}
