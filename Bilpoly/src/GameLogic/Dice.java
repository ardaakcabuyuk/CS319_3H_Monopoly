package GameLogic;

public class Dice {

    //variables
    private int die1;
    private int die2;

    //constructor
    public Dice(){
        die1 = -1;
        die2 = -1;
    }

    //methods
    public void rollDice(){
        die1 = (int)(Math.random()*6) + 1;
        die2 = (int)(Math.random()*6) + 1;
    }
    public int getTotalFaceValue(){
        return die1 + die2;
    }
    public int getDie1FaceValue(){
        return die1;
    }
    public boolean isFaceValueEqual(){
        return (die1 == die2);
    }
}
