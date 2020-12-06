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
import java.util.Arrays;

public class AssetManager extends Application {

    // variables
    protected static int playerNumber;
    protected static Player[] players = null;
    protected static int initialMoney;
    protected static boolean boardMode;
    protected static boolean timeMode;
    protected static int timeLimit;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Bilpoly");
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        Scene scene = new Scene(root, screenBounds.getMaxX(), screenBounds.getMaxY());
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.setFullScreen(true);
        primaryStage.show();

        //music
         URL resource = getClass().getResource("music/fever.mp3");
          Media media = new Media(resource.toString());
          MediaPlayer mediaPlayer = new MediaPlayer(media);
         mediaPlayer.play();

    }


    public static void main(String[] args) {
        launch(args);
    }

    public static void constructGameManager(){
        //GameManager gameManager = new GameManager();
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
}
