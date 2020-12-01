package GameLogic;

import java.util.Arrays;

public class AtalarsRoom extends Landable {
    //constants
    public static final int FEE_NORMAL = -1; //TODO to be determined
    public static final int FEE_CS = -1; //TODO to be determined

    //constructor
    public AtalarsRoom(int index, Location location, Location[] location_available) {
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
//        if (GameManager.GAME_MODE == NORMAL) {
//            player.changeMoney(-FEE_NORMAL);
//        }
//        else if (GameManager.GAME_MODE == CS) {
//            player.changeMoney(-FEE_CS)
//        }
//        player.setInAtalarsRoom(false);
    }

}
