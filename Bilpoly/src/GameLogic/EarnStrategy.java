package GameLogic;

public class EarnStrategy implements CardStrategy {
    @Override
    public boolean executeCard(GameManager mgr, Card card) {
        card.getInteractedPlayer().changeMoney(card.getToEarn());
        return true;
    }
}