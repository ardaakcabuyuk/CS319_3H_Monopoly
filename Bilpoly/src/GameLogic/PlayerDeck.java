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
        this.currentPlayer = playerList.get(playerList.size() - 1);
    }

    //methods
    // This method updates the player deck and its UI
    public void updatePlayerDeck(){

    }

    // This method shows a player using UI
    public void showAPlayer(Player player){

    }

    // This method changes the turn.
    public void nextPlayer(){
        // rotates the list
        Collections.rotate(playerList, 1);
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

    public ArrayList<Player> getPlayerList() {
        return playerList;
    }
}
