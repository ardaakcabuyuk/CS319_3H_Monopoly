package GameLogic;

public class NizamiyeStrategy implements PlaceStrategy {
    final int nizamiyeMoney = 2000;
    @Override
    public void executeFunctional(GameManager mgr, Player player) {
        player.changeMoney(nizamiyeMoney);
    }
}
