package GameLogic;

public class ChanceCardDecorator implements CardStrategy {
    private CardStrategy strategy;
    public ChanceCardDecorator(CardStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCard(Card card, Player player) {
        return false;
    }
}
