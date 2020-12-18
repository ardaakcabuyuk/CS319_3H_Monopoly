package GameLogic;

public class FreeParkingStrategy implements PlaceStrategy {
    @Override
    public void executeFunctional(GameManager mgr, Player player) {
        player.changeMoney(mgr.freeParkingMoney);
    }
}
