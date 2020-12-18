package GameLogic;

public class FeeStrategy implements PlaceStrategy {
    private final int FEE;

    public FeeStrategy(int FEE) {
        this.FEE = FEE;
    }

    @Override
    public void executeFunctional(GameManager mgr, Player player) {
        player.changeMoney(-FEE);
    }
}
