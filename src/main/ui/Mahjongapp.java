package ui;

import model.Mahjong;
import model.ScoreCalculator;
import persistence.HandReader;

import persistence.HandWriter;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//reference for the safe hand and load hand method form:
//https://github.students.cs.ubc.ca/CPSC210/JsonSerializationDemo
//Mahjong score calculating application
public class Mahjongapp {

    private int round;
    private int position;

    private ArrayList<String> openedhand;

    private ArrayList<String> closedhand;

//    private static final String JSON_STORE = "./data/hand.json";
//
//    private HandWriter handWriter;
//
//
//    private HandReader handReader;
//    private Scanner scanner = new Scanner(System.in);


    //EFFECTS: run the mahjong application and r
    public Mahjongapp() {
//        handWriter = new HandWriter(JSON_STORE);
//        handReader = new HandReader(JSON_STORE);
//
//        introductions();
//        userInput();
    }

    //REQUIRE input that follows the input instruction on displaymenu()
    // MODIFIES: this
    //EFFECTS: receive user input for round and position
//    protected void userInput() {
//        System.out.println("enter l to load from previous input or s to start new input");
//        String loadornot = scanner.next();
////        if (loadornot.equals("l")) {
////            windAndPosition();
////            loadHand();
////            furtherCommend();
////        } else
//        if (loadornot.equals("s")) {
//            windAndPosition();
//
//            displayMenu(1);
//            entertiles();
//        }
//    }
//
//
//    //Effect take and set the value for round wind and player position
//    protected void windAndPosition() {
//        System.out.println("please indicate current round in 1 2 3 4 for East South West North round:");
//        String t = scanner.next();
//        if (t.equals("1") || t.equals("2")
//                || t.equals("3") ||t.equals("4")) {
//
//            round = Integer.parseInt(t);
//        } else {
//            System.out.println("didn't enter wind in the correct formate");
//            System.exit(0);
//        }
//        System.out.println("please enter current position 1 2 3 4 East South West North position");
//        String s = scanner.next();
//
//        if (s.equals("1") || s.equals("2")
//                || s.equals("3") || s.equals("4")) {
//
//            position = Integer.parseInt(s);
//            System.out.println("round = " + round + ", position = " + position);
//            printemptyrows(2);
//        } else {
//            System.out.println("didn't enter position in the correct formate");
//            System.exit(0);
//        }
//
//
//    }
//
//    // MODIFIES: this
//    //EFFECTS: receive user input for desired tiles entries and initialize input when enter wrong tiles/ output result
//    protected void entertiles() {
//        enterClosedhand();
//        enterOpenedhand();
//
//
////
////        for (int i = 0; i < 14; i++) {
////            String t = scanner.next();
////            openhand.add(t);
////            printCurrentHand();
////
////        }
//
//        furtherCommend();
//
//    }
//
//    protected void enterOpenedhand() {
//        openedhand = new ArrayList<String>();
//        boolean keepruning = true;
//
//        System.out.println("\tEnter tile for your opened tiles or enter s to stop ");
//
//
//        while (keepruning) {
//            String t = scanner.next();
//            if (!t.equals("s")) {
//                openedhand.add(t);
//                printCurrentHand(2);
//            } else {
//                keepruning = false;
//            }
//
//        }
//
//
//    }
//
//    protected void enterClosedhand() {
//        closedhand = new ArrayList<String>();
//        boolean keepruning = true;
//
//        System.out.println("\tEnter tile for your closed tiles or enter s to stop ");
//
//
//        while (keepruning) {
//            String t = scanner.next();
//            if (!t.equals("s")) {
//                closedhand.add(t);
//                printCurrentHand(1);
//            } else {
//                keepruning = false;
//            }
//
//        }
//
//
//    }
//
//
//    //Effect take commend such as restart,save,load,quit,calculate,print and execute them
//    protected void furtherCommend() {
//        displayMenu(2);
//        String commend = scanner.next();
//        if (commend.equals("r")) {
//            userInput();
//        } else if (commend.equals("s")) {
//            saveHand();
//            furtherCommend();
//        } else if (commend.equals("l")) {
//            loadHand();
//            furtherCommend();
//        } else if (commend.equals("q")) {
//            System.exit(0);
//        } else if (commend.equals("c")) {
//            Mahjong game = new Mahjong(closedhand, openedhand, round, position);
//            ScoreCalculator score = new ScoreCalculator((game));
//            System.out.println("your yaku is " + score.getScore());
//            System.out.println(Arrays.toString(score.getWiningMessages().toArray()));
//        } else if (commend.equals("p")) {
//            printCurrentHand(1);
//            printCurrentHand(2);
//            furtherCommend();
//        } else {
//            System.out.println("invalid commend");
//            furtherCommend();
//        }
//    }
//
//    // MODIFIES: this
//    //EFFECTS: print the tiles in the current hand list
//
//    protected void printCurrentHand(int i) {
////        String closedlist = "empty";
////        String openlist = "empty";
////        if (closedhand.size() > 0) {
////            closedlist = String.join(" ", closedhand);
////        }
////        if (closedhand.size() > 0) {
////            openlist = String.join(" ", openedhand);
////        }
////        System.out.println("\nyour hand : " + closedlist);
////        System.out.println("\tclosed tiles : " + closedlist);
////        System.out.println("\topened tiles :" + openlist);
//        if (i == 1) {
//            String strList = String.join(" ", closedhand);
//            System.out.println("your closed tiles : " + strList);
//        } else if (i == 2) {
//            String strList = String.join(" ", openedhand);
//            System.out.println("your opened tiles : " + strList);
//        }
//    }
//
//    // EFFECTS: provide a  instruction for the format of entering tiles and further commend
//    protected void displayMenu(int i) {
//
//
//        if (i == 1) {
//            System.out.println("s1 = So1 , p2 = Pin2 , m3 = Man3");
//            System.out.println("w1,2,3,4 = East , South , West, North");
//            System.out.println("h1,2,3 = White, Green, Red");
//        } else if (i == 2) {
//            System.out.println("\nSelect from:");
//            System.out.println("\tr -> restart");
//            System.out.println("\ts -> save your hand ");
//            System.out.println("\tl -> load your hand");
//            System.out.println("\tp -> print your hand");
//            System.out.println("\tq -> quit");
//            System.out.println("\tc -> calculate points");
//        }
//    }
//
//    //EFFECT provide a brief introduction to how the mahjong game work
//    protected void introductions() {
//        System.out.println("\n mahjong is a game that require player "
//                + "to complete a set of 14 tiles according to the general rules listed below:");
//        System.out.println("\t 1.set must contain a eye(a set of two identical tiles) ");
//        System.out.println("\t 2.rest of 12 tiles must be either Triplet  or Shuntsu ");
//        System.out.println("\t -Triplet is a set of three identical tiles from any catergory of tiles");
//        System.out.println("\t -Shuntsu  is a set of three consequtive tiles(example: tiles with ID <1,2,3>");
//        System.out.println("\t , <5,6,7> of only category Man , Pin ,or So tiles))  ");
//        System.out.println();
//
//
//    }
//
//
//    //    EFFECTS:saves theworkroom to file
//    protected void saveHand() {
//        try {
//            handWriter.open();
//            handWriter.write(this);
//            handWriter.close();
//            System.out.println("Saved " + "your hand" + " to " + JSON_STORE);
//            printCurrentHand(1);
//        } catch (FileNotFoundException e) {
//            System.out.println("Unable to write to file: " + JSON_STORE);
//        }
//    }
//
//    //     MODIFIES: this
////     EFFECTS: loads workroom from file
//    protected void loadHand() {
//        try {
//            Mahjongapp app = handReader.read();
//            closedhand = app.getClosedhand();
//            openedhand = app.getOpenedhand();
//            round = app.getRound();
//            position = app.getPosition();
//
//            System.out.println("Loaded " + "your hand" + " from " + JSON_STORE);
//        } catch (IOException e) {
//            System.out.println("Unable to read from file: " + JSON_STORE);
//        }
//
//
//    }
//
//    //EFFECT print l lines of empty lines
//    protected void printemptyrows(int l) {
//        for (int i = 0; i < l; i++) {
//            System.out.println();
//        }
//    }

    public int getRound() {
        return round;
    }


    public int getPosition() {
        return position;
    }


    public ArrayList<String> getOpenedhand() {
        return openedhand;
    }


    public ArrayList<String> getClosedhand() {
        return closedhand;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void setOpenedhand(ArrayList<String> openedhand) {
        this.openedhand = openedhand;
    }

    public void setClosedhand(ArrayList<String> closedhand) {
        this.closedhand = closedhand;
    }
}
