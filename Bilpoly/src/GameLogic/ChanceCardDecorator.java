package GameLogic;

public class ChanceCardDecorator implements CardStrategy {
    private CardStrategy strategy;
    public ChanceCardDecorator(CardStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCard(GameManager gm, Card card) {
        return false;
    }
}
