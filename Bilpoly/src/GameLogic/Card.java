package GameLogic;

public class Card {

    //constants
    private final String TEXT;
    private final int CARDNUM;


    //variables
    private CardStrategy cardStrategy;
    private int toPay;
    private int toEarn;
    private int toMove;
    private Player interactedPlayer;
    private boolean toPlayer;
    private boolean toBank;
    private int moveTo;


    //constructor


    public Card(String TEXT, int CARDNUM, CardStrategy cardStrategy, int toPay, int toEarn, int toMove, boolean toPlayer, boolean toBank, int moveTo) {
        this.TEXT = TEXT;
        this.CARDNUM = CARDNUM;
        this.cardStrategy = cardStrategy;
        this.toPay = toPay;
        this.toEarn = toEarn;
        this.toMove = toMove;
        this.toPlayer = toPlayer;
        this.toBank = toBank;
        this.moveTo = moveTo;
    }

    public Card(Card c) {
        this.TEXT = c.TEXT;
        this.CARDNUM = c.CARDNUM;
        this.cardStrategy = c.cardStrategy;
        this.interactedPlayer = c.interactedPlayer;
        this.toPay = c.toPay;
        this.toEarn = c.toEarn;
        this.toMove = c.toMove;
        this.toPlayer = c.toPlayer;
        this.toBank = c.toBank;
        this.moveTo = c.moveTo;
    }

    //methods
    // This method executes the card.
    // TODO will be implemented.
    public boolean executeCard(GameManager mgr){
        cardStrategy.executeCard(mgr,this);
        return true;
    }

    //GETTERS AND SETTERS
    public String getText() { return TEXT; }

    public int getCARDNUM() {
        return CARDNUM;
    }

    public CardStrategy getCardStrategy() {
        return cardStrategy;
    }

    public int getToPay() {
        return toPay;
    }

    public int getToEarn() {
        return toEarn;
    }

    public int getToMove() {
        return toMove;
    }

    public Player getInteractedPlayer() {
        return interactedPlayer;
    }

    public boolean isToPlayer() {
        return toPlayer;
    }

    public boolean isToBank() {
        return toBank;
    }

    public int getMoveTo() {
        return moveTo;
    }

    public void setInteractedPlayer(Player interactedPlayer) {
        this.interactedPlayer = interactedPlayer;
    }

    public void setToPay(int toPay) {
        this.toPay = toPay;
    }

    public void setToEarn(int toEarn) {
        this.toEarn = toEarn;
    }
}
