package GameLogic;

public class PayStrategy implements CardStrategy {
    @Override
    public boolean executeCard(GameManager mgr, Card card) {
        card.getInteractedPlayer().changeMoney(card.getToPay());
        return true;
    }
}