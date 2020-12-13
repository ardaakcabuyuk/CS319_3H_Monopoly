package sample;

import GameLogic.*;

import GameLogic.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class AssetManager extends Application {

    // variables
    protected static int playerNumber;
    protected static Player[] players = null;
    protected static int initialMoney;
    protected static boolean boardMode;
    protected static boolean timeMode;
    protected static int timeLimit = -1;

    public static MediaPlayer mediaPlayer;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bilpoly");
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        Scene scene = new Scene(root, screenBounds.getMaxX(), screenBounds.getMaxY());
        //initialize the theme
        scene.getStylesheets().add(getClass().getResource("background.css").toString());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        //music
         URL resource = getClass().getResource("music/fever_cut.mp3");
          Media media = new Media(resource.toString());
          mediaPlayer = new MediaPlayer(media);
          mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
          mediaPlayer.play();
    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void constructGameManager(){
        System.out.println("constructGameManager() is called.");
        ArrayList<Player> playerList = new ArrayList<Player>();
        for(int i = 0; i < players.length; i++){
            playerList.add(players[i]);
        }
        PlayerDeck playerDeck = new PlayerDeck(playerList);
        Landable[] landableList = getLandableList(boardMode);
        CardDeck cardDeck = getCardDeck(boardMode);
        System.out.println("GameManager is initialized.");
        GameManager gameManager = new GameManager(playerDeck, landableList, cardDeck, timeMode, timeLimit);
    }

    public static void setPlayerNumber(int playerNum){
        playerNumber = playerNum;
    }
    public static int getPlayerNumber(){
        return playerNumber;
    }
    public static void setPlayers(Player[] players1){
        players = Arrays.copyOf(players1, players1.length);
    }
    public static void setInitialMoney(int money){
        initialMoney = money;
    }
    public static void setBoardMode(boolean bMode){
        boardMode = bMode;
    }
    public static void setTimeMode(boolean tMode){
        timeMode = tMode;
    }
    public static void setTimeLimit(int limit){
        timeLimit = limit;
    }
    public static Player[] getPlayers(){
        return  players;
    }
    private static Landable[] getLandableList(boolean boardMode){
        return null;
    }
    private static CardDeck getCardDeck(boolean boardMode){
        CardDeck cardDeck = null;
        return cardDeck;
    }
}
