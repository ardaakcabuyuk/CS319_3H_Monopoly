package GameLogic;

import java.util.Arrays;

public class AtalarsRoom extends Landable {
    //constants
    public final int FEE; //TODO to be determined

    //constructor
    public AtalarsRoom(int fee, int index, Location location, Location[] location_available) {
        FEE = fee;
        type = LandableType.ATALARS_ROOM;
        this.index = index;
        this.location = new Location(location.getX(), location.getY());
        this.location_available = Arrays.copyOf(location_available, location_available.length);
    }

    //methods
    public void goToAtalarsRoom(Player player) {
        player.setInAtalarsRoom(true);
    }

    //TODO change fee according to game mode;
    public void payAtalarsRoomFee(Player player) {
        if (player.isInAtalarsRoom()) {
            player.changeMoney(-FEE);
            player.setInAtalarsRoom(false);
        }
    }
}
