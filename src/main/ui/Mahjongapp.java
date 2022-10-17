package ui;

import model.Mahjong;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mahjongapp {
public int round;
public int position;

    public Mahjongapp() {
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
    private void entertiles() {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> currenthand = new ArrayList<String>();

        System.out.println("enter the tiles in the above format :");


               String t1 = scanner.next();
               currenthand.add(t1);
                 printCurrentHand(currenthand);

        String t2 = scanner.next();
        currenthand.add(t2);
        printCurrentHand(currenthand);

        String t3 = scanner.next();
         currenthand.add(t3);
        printCurrentHand(currenthand);

        String t4 = scanner.next();
        currenthand.add(t4);
        printCurrentHand(currenthand);

        String t5 = scanner.next();
       currenthand.add(t5);
        printCurrentHand(currenthand);

        String t6 = scanner.next();
         currenthand.add(t6);
        printCurrentHand(currenthand);

        String t7 = scanner.next();
        currenthand.add(t7);
        printCurrentHand(currenthand);

        String t8 = scanner.next();
         currenthand.add(t8);
        printCurrentHand(currenthand);

        String t9 = scanner.next();
       currenthand.add(t9);
        printCurrentHand(currenthand);

        String t10 = scanner.next();
         currenthand.add(t10);
        printCurrentHand(currenthand);

        String t11 = scanner.next();
       currenthand.add(t11);
        printCurrentHand(currenthand);

        String t12 = scanner.next();
        currenthand.add(t12);
        printCurrentHand(currenthand);

        String t13 = scanner.next();
         currenthand.add(t13);
        printCurrentHand(currenthand);

        String t14 = scanner.next();
        currenthand.add(t14);
        printCurrentHand(currenthand);


        System.out.println("enter restart if you enter the wrong hand otherwise enter any key");
        String commend = scanner.next();
        if (commend.equals("restart")){
            entertiles();
        }else{

           Mahjong game = new Mahjong(currenthand ,round, position);
         int score = game.getScore();
            System.out.println("your yaku is " + score);
        }



                }

    private void printCurrentHand(List<String> los) {
        String strList = String.join(" ", los);
            System.out.println("your hand : " + strList);

    }



    private void displayMenu(){

        System.out.println("s1 = So1 , p2 = Pin2 , m3 = Man3");
        System.out.println("w1,2,3,4 = East , South , West, North");
        System.out.println("h1,2,3 = White, Green, Red");

    }
}
