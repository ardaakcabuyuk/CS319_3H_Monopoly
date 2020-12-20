package GameLogic;

public class ChanceCardDecorator implements CardStrategy {
    private CardStrategy strategy;
    public ChanceCardDecorator(CardStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeCard(GameManager mgr, Card card) {
        Card copied = new Card(card);
        copied.setToEarn((((int) Math.random() * 50) + 1) * card.getToEarn());
        copied.setToPay((((int) Math.random() * 50) + 1) * card.getToPay());
        System.out.println("YENİ EARN: " + copied.getToEarn());
        System.out.println("YENİ PAY: " + copied.getToPay());
        strategy.executeCard(mgr, copied);
        return true;
    }
}
