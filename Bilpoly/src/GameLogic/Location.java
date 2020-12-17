package GameLogic;

public class Location {

    //variables
    private double xLocation;
    private double yLocation;

    //constructor
    public Location(double xLocation, double yLocation) {
        this.xLocation = xLocation;
        this.yLocation = yLocation;
    }

    //methods
    public double getX() { return xLocation; }

    public double getY() {
        return yLocation;
    }

    public void setX(double xLoc) {
        xLocation = xLoc;
    }

    public void setY(double yLoc) {
        yLocation = yLoc;
    }
}
