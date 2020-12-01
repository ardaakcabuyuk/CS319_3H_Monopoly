package GameLogic;

import java.util.ArrayList;

enum CardType {
    CHANCE,
    RECTORSWHISPER
}

public class Card {

    //constants
    private String TEXT;
    private int CARDNUM;
    private CardType CARDTYPE;
    private int PENALTY_NORMAL;
    private int PENALTY_CS;
    private ArrayList<String> choiceOptions;

    //variables
    private int choice;



    //constructor
    public Card(String text, int cardNum, CardType cardType, int penaltyN, int penaltyCS, ArrayList<String> choiceOptions){
        this.TEXT = text;
        this.CARDNUM = cardNum;
        this.CARDTYPE = cardType;
        this.PENALTY_NORMAL = penaltyN;
        this.PENALTY_CS = penaltyCS;
        this.choiceOptions = choiceOptions;
        this.choice = -1;
    }

    //methods
    // This method executes the card.
    // TODO will be implemented.
    public boolean executeCard(){
        return true;
    }

    //GETTERS AND SETTERS
    public String getText() { return TEXT; }

    public CardType getCardType() { return CARDTYPE; }

    public int getPenaltyNormal() { return PENALTY_NORMAL; }

    public int getPenaltyCS() { return PENALTY_CS; }

    public ArrayList<String> getChoiceOptions() { return choiceOptions; }
}
