package GameLogic;

public class GoToAtalarStrategy implements PlaceStrategy {
    @Override
    public void executeFunctional(GameManager mgr, Player player) {
        mgr.sendPlayerToAtalarsRoom(player);
    }
}
