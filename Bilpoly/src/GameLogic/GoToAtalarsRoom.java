package GameLogic;

import java.util.Arrays;

public class GoToAtalarsRoom extends Landable {
    //constants
    public final int FEE; //TODO to be determined

    //constructor
    public GoToAtalarsRoom(int fee, int index, Location location, Location[] location_available) {
        FEE = fee;
        type = LandableType.GO_TO_ATALARS_ROOM;
        this.index = index;
        this.location = new Location(location.getX(), location.getY());
        this.location_available = Arrays.copyOf(location_available, location_available.length);
    }

    //methods
    public void goToAtalarsRoom(Player player) {
        // move pawn to actual atars room (there are 2 one for go one for visit; you are currently in the go, you should go to the visit one)
        player.setInAtalarsRoom(true);
    }

    //TODO change fee according to game mode;
    public void payAtalarsRoomFee(Player player) {
        if (player.isInAtalarsRoom()) {
            player.changeMoney(-FEE);
            player.setInAtalarsRoom(false);
        }
    }

    public boolean tryToGetOut(Player player){
        return false;
    }
}
