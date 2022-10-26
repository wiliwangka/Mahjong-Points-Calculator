package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

//represent game of the set of 14 tiles in user's hand and environment of current round
public class Mahjong {
    private int score;
    private ArrayList<Tile> hand;

    private ArrayList<String> userinput;

    private int round;
    private int position;

    private Tile s1 = new So(1);
    private Tile s2 = new So(2);
    private Tile s3 = new So(3);
    private Tile s4 = new So(4);
    private Tile s5 = new So(5);
    private Tile s6 = new So(6);
    private Tile s7 = new So(7);
    private Tile s8 = new So(8);
    private Tile s9 = new So(9);


    private Tile m1 = new Man(1);
    private Tile m2 = new Man(2);
    private Tile m3 = new Man(3);
    private Tile m4 = new Man(4);
    private Tile m5 = new Man(5);
    private Tile m6 = new Man(6);
    private Tile m7 = new Man(7);
    private Tile m8 = new Man(8);
    private Tile m9 = new Man(9);

    private Tile p1 = new Pin(1);
    private Tile p2 = new Pin(2);
    private Tile p3 = new Pin(3);
    private Tile p4 = new Pin(4);
    private Tile p5 = new Pin(5);
    private Tile p6 = new Pin(6);
    private Tile p7 = new Pin(7);
    private Tile p8 = new Pin(8);
    private Tile p9 = new Pin(9);

    private Tile w1 = new Wind(1);
    private Tile w2 = new Wind(2);
    private Tile w3 = new Wind(3);
    private Tile w4 = new Wind(4);

    private Tile h1 = new Honor(1);
    private Tile h2 = new Honor(2);
    private Tile h3 = new Honor(3);


    /*
     * REQUIRES: los.size() =14 , 4>=r >=1 , 4>= p>=1
     * * MODIFIES this
     * EFFECTS: construct a mahjong game with 14 tiles and round/ position number and final score from user input
     */
    public Mahjong(ArrayList<String> los, int r, int p) {
        userinput = los;
        round = r;
        position = p;
    }

    /*
     * * MODIFIES this
     * EFFECTS: translate userinput to arraylistoftile and run tile counters

     */
    public void mahjongGame() {
        losToArrayListofTiles(userinput);


        ScoreCalculator newgame = new ScoreCalculator(hand, round, position);
        newgame.computeScore();
        this.score = newgame.getScore();
    }
    /*
     * helper method of Mahjong
     * REQUIRES: los.size() =14
     * * MODIFIES this
     * EFFECTS: turn my hand from user entered strings to tiles objects and place them into arraylistoftiles
     */


    public void losToArrayListofTiles(ArrayList<String> los) {
        hand = new ArrayList<>();
        for (String s : los) {
            String[] part = s.split("(?<=\\D)(?=\\d)");
            String a = part[0];
            int b = Integer.parseInt(part[1]);

            if (a.equals("s")) {
                stringToTileForSo(b);
            } else if (a.equals("p")) {
                stringToTileForPin(b);

            } else if (a.equals("m")) {
                stringToTileForMan(b);

            } else if (a.equals("w")) {
                stringToTileForWind(b);

            } else if (a.equals("h")) {
                stringToTileForHonor(b);
            }
        }
    }

    //Effect;; construct a so object according to input and put it in hand

    public void stringToTileForSo(int id) {
        if (id == 1) {

            addtileandincreasecount(s1);
        } else if (id == 2) {
            addtileandincreasecount(s2);

        } else if (id == 3) {
            addtileandincreasecount(s3);
        } else if (id == 4) {

            addtileandincreasecount(s4);
        } else if (id == 5) {

            addtileandincreasecount(s5);
        } else if (id == 6) {

            addtileandincreasecount(s6);
        } else if (id == 7) {

            addtileandincreasecount(s7);
        } else if (id == 8) {

            addtileandincreasecount(s8);
        } else if (id == 9) {
            addtileandincreasecount(s9);
        }
    }


    public void stringToTileForMan(int id) {
        if (id == 1) {

            addtileandincreasecount(m1);
        } else if (id == 2) {
            addtileandincreasecount(m2);

        } else if (id == 3) {
            addtileandincreasecount(m3);
        } else if (id == 4) {

            addtileandincreasecount(m4);
        } else if (id == 5) {

            addtileandincreasecount(m5);
        } else if (id == 6) {

            addtileandincreasecount(m6);
        } else if (id == 7) {

            addtileandincreasecount(m7);
        } else if (id == 8) {

            addtileandincreasecount(m8);
        } else if (id == 9) {
            addtileandincreasecount(m9);
        }
    }

    public void stringToTileForPin(int id) {
        if (id == 1) {

            addtileandincreasecount(p1);
        } else if (id == 2) {
            addtileandincreasecount(p2);

        } else if (id == 3) {
            addtileandincreasecount(p3);
        } else if (id == 4) {

            addtileandincreasecount(p4);
        } else if (id == 5) {

            addtileandincreasecount(p5);
        } else if (id == 6) {

            addtileandincreasecount(p6);
        } else if (id == 7) {

            addtileandincreasecount(p7);
        } else if (id == 8) {

            addtileandincreasecount(p8);
        } else if (id == 9) {
            addtileandincreasecount(p9);
        }
    }


    public void stringToTileForHonor(int id) {
        if (id == 1) {

            addtileandincreasecount(h1);
        } else if (id == 2) {
            addtileandincreasecount(h2);

        } else if (id == 3) {
            addtileandincreasecount(h3);
        }
    }

    public void stringToTileForWind(int id) {
        if (id == 1) {

            addtileandincreasecount(w1);
        } else if (id == 2) {
            addtileandincreasecount(w2);

        } else if (id == 3) {
            addtileandincreasecount(w3);
        } else if (id == 4) {

            addtileandincreasecount(w4);
        }
    }

    /*
     * * MODIFIES this
     * EFFECTS: increase the number count of the tiles and add tile to the hand
     */
    public void addtileandincreasecount(Tile t) {

        t.increaseCount();
        hand.add(t);

    }

    /*
     * * MODIFIES this
     * EFFECTS: increase the number count of the tiles and return true if found duplicate else false
     */
//    public boolean countTile(Tile t) {
//
//        if (hand.contains(t)) {
//            return true;
//
//        } else {
//            return false;
//
//        }
////        Tile privioust;
////        for (Tile s : hand) {
////            if (hand.contains(s)) {
////                hand.remove(s);
////                s.increaseCount();
////            }
////
////            s.increaseCount();
////
////
////        }
//    }

    public int getScore() {
        return score;
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }


}
