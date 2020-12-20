package GameLogic;

import java.util.ArrayList;
import java.util.Collections;

public class PlayerDeck {

    //constants

    //variables
    private Player currentPlayer;
    private ArrayList<Player> playerList;

    //constructor
    public PlayerDeck(ArrayList<Player> playerList){
        this.playerList = playerList;
        Collections.rotate(playerList, 1);
        this.currentPlayer = playerList.get(0);
    }


    // This method shows a player using UI
    public void showAPlayer(Player player){

    }

    // This method changes the turn.
    public void nextPlayer(){
        // rotates the list
        Collections.rotate(playerList, -1);
        // update current player
        this.currentPlayer = playerList.get(0);
        // update player deck UI
    }

    // This method deletes the given player from the player deck.
    public boolean deleteAPlayer(Player player){
        int index = playerList.indexOf(player);
        if (index > 0){
            playerList.remove(player);
            return true;
        }
        else{
            return false;
        }
    }

    //GETTERS AND SETTERS

    // getter currentPlayer
    public Player getCurrentPlayer() { return currentPlayer; }
    public Player getNextPlayer() { return playerList.get(1); }

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }

}
