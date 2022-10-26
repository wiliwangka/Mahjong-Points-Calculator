package ui;

import model.Mahjong;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Mahjong score calculating application
public class Mahjongapp {

    private int round;
    private int position;

    //EFFECTS: run the mahjong application and r
    public Mahjongapp() {
        userInput();
    }

    //REQUIRE input that follows the input instruction on displaymenu()
    // MODIFIES: this
    //EFFECTS: receive user input for round and position
    private void userInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("please indicate current round in 1 2 3 4 for E S W N :");
        round = Integer.parseInt(scanner.next());
        System.out.println("please enter current position 1 2 3 4 for E S W N");
        position = Integer.parseInt(scanner.next());
        System.out.println("round = " + round + ", position = " + position);
        System.out.println();
        displayMenu();
        entertiles();

    }

    // MODIFIES: this
    //EFFECTS: receive user input for desired tiles entries and initialize input when enter wrong tiles/ output result
    private void entertiles() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> currenthand = new ArrayList<String>();

        System.out.println("enter the tiles in the above format :");


        for (int i = 0; i < 14; i++) {
            String t = scanner.next();
            currenthand.add(t);
            printCurrentHand(currenthand);

        }

        System.out.println("enter restart if you enter the wrong hand otherwise enter any key");
        String commend = scanner.next();
        if (commend.equals("restart")) {
            entertiles();
        } else {

            Mahjong game = new Mahjong(currenthand, round, position);
            game.mahjongGame();
            int score = game.getScore();
            System.out.println("your yaku is " + score);
        }


    }

    // MODIFIES: this
    //EFFECTS: print the tiles in the current hand list
    private void printCurrentHand(List<String> los) {
        String strList = String.join(" ", los);
        System.out.println("your hand : " + strList);

    }

    // EFFECTS: provide instruction for the format of entering tiles
    private void displayMenu() {

        System.out.println("s1 = So1 , p2 = Pin2 , m3 = Man3");
        System.out.println("w1,2,3,4 = East , South , West, North");
        System.out.println("h1,2,3 = White, Green, Red");

    }
}
