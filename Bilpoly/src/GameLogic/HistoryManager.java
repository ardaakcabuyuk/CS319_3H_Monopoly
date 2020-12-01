package GameLogic;

import java.util.ArrayList;

public class HistoryManager {

    //constants
    private final String FIRST_MESSAGE = "Game is started !";
    private final int MAX_SIZE = 3;

    //variables
    private ArrayList<String> history;

    //constructor
    public HistoryManager(){
        history = new ArrayList<String>();
        history.add(FIRST_MESSAGE);
    }

    //methods
    public void updateHistory(String last, Player player){
        String newHistory = "";
        newHistory = newHistory + player.getName();
        newHistory = newHistory + last;
        history.add(newHistory);

        while(history.size() > MAX_SIZE){
            history.remove(history.size() - 1);
        }
    }

    //GETTERS AND SETTERS
    public ArrayList<String> getHistory(){ return history; }
}
