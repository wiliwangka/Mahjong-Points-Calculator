package ui;

import model.Mahjong;
import persistence.HandReader;

import persistence.HandWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Scanner;

//reference for the safe hand and load hand method form:
//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
//Mahjong score calculating application
public class Mahjongapp {

    private int round;
    private int position;

    private ArrayList<String> hand;

    private static final String JSON_STORE = "./data/hand.json";

    private HandWriter handWriter;

    private HandReader handReader;
    private Scanner scanner = new Scanner(System.in);


    //EFFECTS: run the mahjong application and r
    public Mahjongapp() {
        handWriter = new HandWriter(JSON_STORE);
        handReader = new HandReader(JSON_STORE);
        introductions();
        userInput();
    }

    //REQUIRE input that follows the input instruction on displaymenu()
    // MODIFIES: this
    //EFFECTS: receive user input for round and position
    private void userInput() {
        System.out.println("enter l to load from previous input or s to start new input");
        String loadornot = scanner.next();
        if (loadornot.equals("l")) {
            windAndPosition();
            loadHand();
            furtherCommend();
        } else if (loadornot.equals("s")) {
            windAndPosition();

            displayMenu(1);
            entertiles();
        }
    }


    //Effect take and set the value for round wind and player position
    private void windAndPosition() {
        System.out.println("please indicate current round in 1 2 3 4 for East South West North position:");
        round = Integer.parseInt(scanner.next());
        System.out.println("please enter current position 1 2 3 4 East South West North position");
        position = Integer.parseInt(scanner.next());
        System.out.println("round = " + round + ", position = " + position);
        System.out.println();
    }

    // MODIFIES: this
    //EFFECTS: receive user input for desired tiles entries and initialize input when enter wrong tiles/ output result
    private void entertiles() {

        hand = new ArrayList<String>();

        System.out.println("enter the tiles in the above format :");


        for (int i = 0; i < 14; i++) {
            String t = scanner.next();
            hand.add(t);
            printCurrentHand();

        }

        furtherCommend();

    }

    //Effect take commend such as restart,save,load,quit,calculate,print and execute them
    private void furtherCommend() {
        displayMenu(2);
        String commend = scanner.next();
        if (commend.equals("r")) {
            userInput();
        } else if (commend.equals("s")) {
            saveHand();
            furtherCommend();
        } else if (commend.equals("l")) {
            loadHand();
            furtherCommend();
        } else if (commend.equals("q")) {
            System.exit(0);
        } else if (commend.equals("c")) {
            Mahjong game = new Mahjong(hand, round, position);
            game.mahjongGame();
            System.out.println("your yaku is " + game.getScore());
        } else if (commend.equals("p")) {
            printCurrentHand();
            furtherCommend();
        } else {
            System.out.println("invalid commend");
            furtherCommend();
        }
    }

    // MODIFIES: this
    //EFFECTS: print the tiles in the current hand list
    private void printCurrentHand() {
        String strList = String.join(" ", hand);
        System.out.println("your hand : " + strList);

    }

    // EFFECTS: provide instruction for the format of entering tiles
    private void displayMenu(int i) {


        if (i == 1) {
            System.out.println("s1 = So1 , p2 = Pin2 , m3 = Man3");
            System.out.println("w1,2,3,4 = East , South , West, North");
            System.out.println("h1,2,3 = White, Green, Red");
        } else if (i == 2) {
            System.out.println("\nSelect from:");
            System.out.println("\tr -> restart");
            System.out.println("\ts -> save your hand ");
            System.out.println("\tl -> load your hand");
            System.out.println("\tl -> print your hand");
            System.out.println("\tq -> quit");
            System.out.println("\tc -> calculate points");
        }
    }


    // EFFECTS: saves the workroom to file
    private void saveHand() {
        try {
            handWriter.open();
            handWriter.write(hand);
            handWriter.close();
            System.out.println("Saved " + "your hand" + " to " + JSON_STORE);
        } catch (FileNotFoundException e) {
            System.out.println("Unable to write to file: " + JSON_STORE);
        }
    }

    private void introductions() {
        System.out.println("\n mahjong is a game that require player "
                + "to complete a set of 14 tiles according to the general rules listed below:");
        System.out.println("\t 1. must contain a eye(a set of two identical tiles) ");
        System.out.println("\t 2.rest of 12 tiles must be either Triplet  or Shuntsu ");
        System.out.println("\t -Triplet is a set of three identical tiles from any catergory of tiles");
        System.out.println("\t -Shuntsu  is a set of three consequtive tiles(example: tiles with ID <1,2,3>");
        System.out.println("\t , <5,6,7> of only category Man , Pin ,or So tiles))  ");
        System.out.println();


    }

    // MODIFIES: this
    // EFFECTS: loads workroom from file
    private void loadHand() {
        try {
            hand = handReader.read();
            System.out.println("Loaded " + "your hand" + " from " + JSON_STORE);
        } catch (IOException e) {
            System.out.println("Unable to read from file: " + JSON_STORE);
        }
    }
}
