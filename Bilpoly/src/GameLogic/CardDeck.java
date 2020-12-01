package GameLogic;

import java.util.ArrayList;
import java.util.Collections;

public class CardDeck {

    //variables
    // Important Note: Since we rotate the deck, these decks are not constant.
    private ArrayList<Card> CHANCE_CARDS_NORMAL;
    private ArrayList<Card> CHANCE_CARDS_CS;
    private ArrayList<Card> RECTORSW_CARDS_NORMAL;
    private ArrayList<Card> RECTORSW_CARDS_CS;

    //variables
    private Card currentCard;

    //constructor
    public CardDeck(ArrayList<Card> chance_cards_normal, ArrayList<Card> chance_cards_cs,
                    ArrayList<Card> rectorsw_cards_normal, ArrayList<Card> rectorsw_cards_cs){
        CHANCE_CARDS_NORMAL = chance_cards_normal;
        CHANCE_CARDS_CS = chance_cards_cs;
        RECTORSW_CARDS_NORMAL = rectorsw_cards_normal;
        RECTORSW_CARDS_CS = rectorsw_cards_cs;
        this.currentCard = null;
        shuffleAllCards();
    }

    //methods
    // This method draws a dard from the deck according to given parameter type.
    // TODO will be implemented.
    public Card drawCard(CardType type){
        if(type == CardType.CHANCE){
            if(true) {
                currentCard = CHANCE_CARDS_NORMAL.get(0);
                Collections.rotate(CHANCE_CARDS_NORMAL, 1);
            }
            else{
                currentCard = CHANCE_CARDS_CS.get(0);
                Collections.rotate(CHANCE_CARDS_CS, 1);
            }
        }
        else{
            if(true) {
                currentCard = RECTORSW_CARDS_NORMAL.get(0);
                Collections.rotate(RECTORSW_CARDS_NORMAL, 1);
            }
            else{
                currentCard = RECTORSW_CARDS_CS.get(0);
                Collections.rotate(RECTORSW_CARDS_CS, 1);
            }
        }
        return currentCard;
    }

    // This method executes the currentCard.
    // TODO will be implemented.
    public boolean executeCard(){
        return true;
    }

    public void shuffleAllCards(){
        Collections.shuffle(CHANCE_CARDS_NORMAL);
        Collections.shuffle(CHANCE_CARDS_CS);
        Collections.shuffle(RECTORSW_CARDS_NORMAL);
        Collections.shuffle(RECTORSW_CARDS_CS);
    }
}
