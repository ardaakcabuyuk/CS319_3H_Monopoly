package GameLogic;

public class EarnStrategy implements CardStrategy {
    @Override
    public boolean executeCard(GameManager mgr, Card card) {
        return false;
    }
}