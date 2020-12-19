package GameLogic;

import java.util.Arrays;

public class AtalarsRoom extends Landable {
    //constants
    public final int FEE; //TODO to be determined

    //constructor
    public AtalarsRoom(int fee) {
        FEE = fee;
        type = LandableType.ATALARS_ROOM;
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
