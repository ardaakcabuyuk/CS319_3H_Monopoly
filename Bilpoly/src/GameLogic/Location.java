package GameLogic;

public class Location {

    //variables
    private int xLocation;
    private int yLocation;

    //constructor
    public Location(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    //methods
    public int getX() {
        return xLocation;
    }

    public int getY() {
        return yLocation;
    }

    public void setX(int xLoc) {
        xLocation = xLoc;
    }

    public void setY(int yLoc) {
        yLocation = yLoc;
    }
}
