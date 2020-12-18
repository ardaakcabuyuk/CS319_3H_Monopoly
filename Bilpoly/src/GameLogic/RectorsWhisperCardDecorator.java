package GameLogic;

public class RectorsWhisperCardDecorator implements CardStrategy {
    private CardStrategy strategy;
    public RectorsWhisperCardDecorator(CardStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCard(Card card, Player player) {
        return false;
    }
}