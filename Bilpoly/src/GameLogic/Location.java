package GameLogic;

public class Location {
    private int xLocation;
    private int yLocation;

    public Location(int xLocation, int yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

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
