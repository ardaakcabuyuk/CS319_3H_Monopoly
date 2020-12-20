package GameLogic;

public class CardPlace extends Landable {
    //attributes
    private CardType cardType;

    //constructor
    public CardPlace(CardType cardType) {
        type = LandableType.CARD_PLACE;
        this.cardType = cardType;
    }

    //methods

    // GETTERS SETTERS
    public CardType getCardType(){
        return cardType;
    }
}
