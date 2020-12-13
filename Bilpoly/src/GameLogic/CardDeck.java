package GameLogic;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

    //variables
    // Important Note: Since we rotate the deck, these decks are not constant.
    private ArrayList<Card> CHANCE_CARDS;
    private ArrayList<Card> RECTORSW_CARDS;

    //variables
    private Card currentCard;

    //constructor
    public CardDeck(ArrayList<Card> chance_cards, ArrayList<Card> rectorsw_cards){
        CHANCE_CARDS = chance_cards;
        RECTORSW_CARDS = rectorsw_cards;
        this.currentCard = null;
        shuffleAllCards();
    }

    //methods
    // This method draws a dard from the deck according to given parameter type.
    // TODO will be implemented.
    public Card drawCard(CardType type){
        if(type == CardType.CHANCE){
            currentCard = CHANCE_CARDS.get(0);
            Collections.rotate(CHANCE_CARDS, 1);
        }
        else{
            currentCard = RECTORSW_CARDS.get(0);
            Collections.rotate(RECTORSW_CARDS, 1);
        }
        return currentCard;
    }

    // This method executes the currentCard.
    // TODO will be implemented.
    public boolean executeCard(){
        return true;
    }

    public void shuffleAllCards(){
        Collections.shuffle(CHANCE_CARDS);
        Collections.shuffle(RECTORSW_CARDS);
    }
}
