package GameLogic;

public class RectorsWhisperCardDecorator implements CardStrategy {
    private CardStrategy strategy;
    public RectorsWhisperCardDecorator(CardStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCard(GameManager mgr, Card card) {
        Card copied = new Card(card);
        if (card.getInteractedPlayer().getMoney() < 7.500) {
            copied.setToEarn(2 * card.getToEarn());
            copied.setToPay(3 * card.getToPay() / 4);
        }
        else {
            copied.setToEarn(card.getToEarn() / 2);
            copied.setToPay(5 * card.getToPay() / 4);
        }
        System.out.println("YENİ EARN: " + copied.getToEarn());
        System.out.println("YENİ PAY: " + copied.getToPay());
        strategy.executeCard(mgr, copied);
        return true;
    }
}