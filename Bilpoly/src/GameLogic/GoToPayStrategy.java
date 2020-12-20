package GameLogic;

public class GoToPayStrategy implements CardStrategy {
    @Override
    public boolean executeCard(GameManager mgr, Card card) {
        if(card.getMoveTo() == 10) {
            mgr.sendPlayerToAtalarsRoom(card.getInteractedPlayer());
        }
        card.getInteractedPlayer().changeMoney(-card.getToPay());
        if (card.getMoveTo() != -1) {
            mgr.movePlayerTo(card.getMoveTo());
        }
        else if (card.getToMove() != -1) {
            mgr.movePlayerWithStep(card.getToMove());
        }
        else {
            System.out.println("GOTOPAY STRATEGY ERROR");
            return false;
        }
        return true;
    }
}