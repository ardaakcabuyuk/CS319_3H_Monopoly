package GameLogic;

import java.util.Arrays;

public class CardPlace extends Landable {
    //attributes
    private CardType cardType;

    //constructor
    public CardPlace(CardType cardType, int index, Location location, Location[] location_available) {
        type = LandableType.CARD_PLACE;
        this.cardType = cardType;
        this.index = index;
        this.location = new Location(location.getX(), location.getY());
        this.location_available = Arrays.copyOf(location_available, location_available.length);
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
