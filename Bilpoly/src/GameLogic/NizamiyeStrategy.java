package GameLogic;

public class NizamiyeStrategy implements PlaceStrategy {
    final int MIZAMIYE_MONEY = 2000;
    @Override
    public void executeFunctional(GameManager mgr, Player player) {
        player.changeMoney(MIZAMIYE_MONEY);
    }
}
