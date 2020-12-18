package GameLogic;

public class PayStrategy implements CardStrategy {
    @Override
    public boolean executeCard(Card card, Player player) {
        return false;
    }
}