package GameLogic;

public class PayStrategy implements CardStrategy {
    @Override
    public boolean executeCard(GameManager mgr, Card card) {
        return false;
    }
}