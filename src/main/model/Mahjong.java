package model;

import java.util.ArrayList;
import java.util.HashSet;

//represent game of the set of 14 tiles in user's hand and environment of current round
public class Mahjong {
    private int score;
// add hashset<tile> as a field
    /*
     * REQUIRES: los.size() =14 , 4>=r >=1 , 4>= p>=1
     * * MODIFIES this
     * EFFECTS: construct a mahjong game with 14 tiles and round/ position number and final score from user input
     */
    public Mahjong(ArrayList<String> los, int r, int p) {
        HashSet<Tile> hand = losToMahjongHashset(los);
        countTile(hand);

        ScoreCalculator newgame = new ScoreCalculator(hand, r, p);
        newgame.computeScore();
        this.score = newgame.getScore();
    }

    /*
     * helper method of Mahjong
     * REQUIRES: los.size() =14
     * * MODIFIES this
     * EFFECTS: turn my hand from user entered strings to tiles objects and place them into hashset
     */
    public HashSet<Tile> losToMahjongHashset(ArrayList<String> los) {
        HashSet<Tile> myhands = new HashSet<>();
        for (String s : los) {
            String[] part = s.split("(?<=\\D)(?=\\d)");
            String a = part[0];
            int b = Integer.parseInt(part[1]);
            if (a.equals("s")) {
                Tile sotsu = new So(b);
                myhands.add(sotsu);
            } else if (a.equals("p")) {
                Tile pintsu = new Pin(b);
                myhands.add(pintsu);

            } else if (a.equals("m")) {
                Tile mantsu = new Man(b);
                myhands.add(mantsu);

            } else if (a.equals("w")) {
                Tile wind = new Wind(b);
                myhands.add(wind);

            } else if (a.equals("h")) {
                Tile honor = new Honor(b);
                myhands.add(honor);
            }
        }
        return myhands;
    }

    /*
     * REQUIRES: hand.size() =14
     * * MODIFIES this
     * EFFECTS: increase the number count of the tiles and remove duplicate
     */
    public void countTile(HashSet<Tile> hand) {
        for (Tile s : hand) {
            if (s.getCount() >= 1) {
                hand.remove(s);
                s.increaseCount();
            }
            s.increaseCount();

        }
    }

    public int getScore() {
        return score;
    }
}
