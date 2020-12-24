package GameLogic;

public class NizamiyeStrategy implements PlaceStrategy {
    final int NIZAMIYE_MONEY = 2000;
    @Override
    public void executeFunctional(GameManager mgr, Player player) {
        player.changeMoney(NIZAMIYE_MONEY);
    }
}
