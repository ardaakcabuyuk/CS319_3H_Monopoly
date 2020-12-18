package sample;

import GameLogic.*;

import GameLogic.Player;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.awt.*;
import java.io.*;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.Scanner;
import java.util.function.IntFunction;

public class AssetManager extends Application {

    //constants
    final static int LAND_NUMBER = 22;
    final static int CAFE_NUMBER = 4;
    final static int CARD_PLACE_NUMBER = 6;
    final static int FUNCTIONAL_PLACE_NUMBER = 7;

    // variables
    protected static int playerNumber;
    protected static Player[] players = null;
    protected static int initialMoney;
    protected static boolean boardMode;
    protected static boolean timeMode;
    protected static int timeLimit = -1;

    public static GameManager gameManager;
    public static LandPopupController landPopupController;

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

    public static void constructGameManager(GameScreen loader){
        System.out.println("constructGameManager() is called.");
        ArrayList<Player> playerList = new ArrayList<Player>();
        for(int i = 0; i < players.length; i++){
            playerList.add(players[i]);
        }
        PlayerDeck playerDeck = new PlayerDeck(playerList);
        Landable[] landableList = getLandableList(boardMode);
/*
        for (int i = 0; i < landableList.length; i++) {
            System.out.println(landableList[i].getType());
        }

 */
        CardDeck cardDeck = getCardDeck(boardMode);

        gameManager = new GameManager(playerDeck, landableList, cardDeck, timeMode, timeLimit);
        gameManager.gameScreenController = loader;

        gameManager.setLandableListLocations();
        gameManager.gameScreenController.initializePawns(landableList);


        // at the end
        gameManager.playGame();
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


    private static Landable[] getLandableList(boolean boardMode) {
        //Buildings Mode
        Landable[] landableList = new Landable[40];
        //if (boardmode == false) {
            Land[] landList = new Land[LAND_NUMBER];
            Cafe[] cafeList = new Cafe[CAFE_NUMBER];
            CardPlace[] cardPlaceList = new CardPlace[CARD_PLACE_NUMBER];
            FunctionalPlace[] functionalPlaceList = new FunctionalPlace[FUNCTIONAL_PLACE_NUMBER];

            //read lands from file
            try {
                File file = new File("src/sample/Landables/lands.txt");
                System.out.println("Attempting to read from file in: "+ file.getCanonicalPath());
                Scanner scan = new Scanner(file);
                int index = 0;
                while (scan.hasNextLine()) {
                    String[] tokens = scan.nextLine().split(",");
                    landList[index] = new Land(Color.valueOf(tokens[0].toUpperCase()), tokens[1],
                            Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                            Integer.parseInt(tokens[6]), Integer.parseInt(tokens[7]),
                            Integer.parseInt(tokens[8]), Integer.parseInt(tokens[9]),
                            Integer.parseInt(tokens[10]));
                    index++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //read cafes from file
            try {
                File file = new File("src/sample/Landables/cafes.txt");
                System.out.println("Attempting to read from file in: "+ file.getCanonicalPath());
                Scanner scan = new Scanner(file);
                int index = 0;
                while (scan.hasNextLine()) {
                    String[] tokens = scan.nextLine().split(",");
                    cafeList[index] = new Cafe(tokens[0], Integer.parseInt(tokens[1]),
                            Integer.parseInt(tokens[2]), Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]));
                    index++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            //initialize cardPlaceList
            for (int i = 0; i < CARD_PLACE_NUMBER / 2; i++) {
                cardPlaceList[i] = new CardPlace(CardType.CHANCE);
                cardPlaceList[i + CARD_PLACE_NUMBER / 2] = new CardPlace(CardType.RECTORS_WHISPER);
            }

            //initialize functionalPlaceList
            functionalPlaceList[0] = new FunctionalPlace(new NizamiyeStrategy()); //NİZAMİYE
            functionalPlaceList[1] = new FunctionalPlace(new TaxStrategy()); //TUITION FEE
            functionalPlaceList[2] = new FunctionalPlace(new TaxStrategy()); //DORM FEE
            functionalPlaceList[3] = new FunctionalPlace(new FreeParkingStrategy()); //FREE PARKING
            functionalPlaceList[4] = new FunctionalPlace(new TaxStrategy()); //BOOK FEE
            functionalPlaceList[5] = new FunctionalPlace(new GoToAtalarStrategy()); //GO TO ATALAR
            functionalPlaceList[6] = new FunctionalPlace(new TaxStrategy()); //FOOD FEE

            //initialize Atalar's Room
            AtalarsRoom atalarsRoom = new AtalarsRoom(0 ,0 ,null, null);

            //placing the landables according to their positions on the board
            //first, functionalPlaceList
            landableList[0] = functionalPlaceList[0]; //NİZAMİYE
            landableList[4] = functionalPlaceList[1]; //TUITION FEE
            landableList[12] = functionalPlaceList[2]; //DORM FEE
            landableList[20] = functionalPlaceList[3]; //FREE PARKING
            landableList[28] = functionalPlaceList[4]; //BOOK FEE
            landableList[30] = functionalPlaceList[5]; //GO TO ATALAR
            landableList[38] = functionalPlaceList[6]; //FOOD FEE

            //cardPlaceList
            landableList[2] = cardPlaceList[3]; //RECTOR'S WHISPER
            landableList[7] = cardPlaceList[0]; //CHANCE
            landableList[17] = cardPlaceList[4]; //RECTOR'S WHISPER
            landableList[22] = cardPlaceList[1]; //CHANCE
            landableList[33] = cardPlaceList[5]; //RECTOR'S WHISPER
            landableList[36] = cardPlaceList[2]; //CHANCE

            //Atalar's Room
            landableList[10] = atalarsRoom;

            //cafes
            for (int i = 0; i < CAFE_NUMBER; i++) {
                landableList[(2 * i + 1) * 5] = cafeList[i];
            }

            //lands
            int land_index = 0;
            for (int i = 0; i < landableList.length; i++) {
                if (landableList[i] == null) {
                    landableList[i] = landList[land_index];
                    land_index++;
                }
            }

            //setting the index of the landables
            for (int i = 0; i < landableList.length; i++) {
                landableList[i].setIndex(i);
            }

        return landableList;
        //}
    }
    private static CardDeck getCardDeck(boolean boardMode){
        ArrayList<Card> chanceCards = new ArrayList<Card>();
        ArrayList<Card> rectorsWCards = new ArrayList<Card>();

        try {
            File file = new File("src/sample/Cards/cards.txt");
            System.out.println("Attempting to read from file in: "+ file.getCanonicalPath());
            Scanner scan = new Scanner(file);
            int num = 0;
            while (scan.hasNextLine()) {
                String[] tokens = scan.nextLine().split(",");
                CardStrategy strategy = null;
                switch (tokens[2]) {
                    case "earn":
                        strategy = new EarnStrategy();
                        break;
                    case "goTo":
                        strategy = new GoToStrategy();
                        break;
                    case "pay":
                        strategy = new PayStrategy();
                        break;
                    case "goToPay":
                        strategy = new GoToPayStrategy();
                        break;
                }
                if (tokens[1].equals("chance")) {
                    chanceCards.add(new Card(tokens[0], num, new ChanceCardDecorator(strategy), Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                            1 == Integer.parseInt(tokens[6]), 1 == Integer.parseInt(tokens[7]),
                            Integer.parseInt(tokens[8])));
                }
                else {
                    rectorsWCards.add(new Card(tokens[0], num, new RectorsWhisperCardDecorator(strategy), Integer.parseInt(tokens[3]),
                            Integer.parseInt(tokens[4]), Integer.parseInt(tokens[5]),
                            1 == Integer.parseInt(tokens[6]), 1 == Integer.parseInt(tokens[7]),
                            Integer.parseInt(tokens[8])));
                }
                num++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return new CardDeck(chanceCards, rectorsWCards);
    }

}
