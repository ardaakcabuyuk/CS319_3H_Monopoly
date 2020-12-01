package GameLogic;

public class AtalarsRoom {
    //constants
    public static final int FEE_NORMAL = -1; //TODO to be determined
    public static final int FEE_CS = -1; //TODO to be determined

    //constructor
    public AtalarsRoom() {}

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
