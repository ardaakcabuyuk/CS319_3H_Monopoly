package GameLogic;

import java.util.Arrays;

public class CardPlace extends Landable {
    //attributes
    private CardType cardType;

    //constructor
    public CardPlace(CardType cardType) {
        type = LandableType.CARD_PLACE;
        this.cardType = cardType;
    }

    //methods
    //TODO will be implemented
    public void showCard() {}

    //TODO will be implemented
    public void closeCard() {}

    // GETTERS SETTERS
    public CardType getCardType(){
        return cardType;
    }
}
