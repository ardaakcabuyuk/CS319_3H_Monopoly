package GameLogic;

public class RectorsWhisperCardDecorator implements CardStrategy {
    private CardStrategy strategy;
    public RectorsWhisperCardDecorator(CardStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCard(GameManager gm, Card card) {
        return false;
    }
}