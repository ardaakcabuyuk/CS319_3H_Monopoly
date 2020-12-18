package GameLogic;

public class GoToPayStrategy implements CardStrategy {
    @Override
    public boolean executeCard(Card card, Player player) {
        return false;
    }
}