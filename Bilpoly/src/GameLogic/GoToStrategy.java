package GameLogic;

public class GoToStrategy implements CardStrategy {
    @Override
    public boolean executeCard(GameManager mgr, Card card) {
        return false;
    }
}