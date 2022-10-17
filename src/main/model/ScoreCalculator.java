package model;

import java.util.HashSet;

public class ScoreCalculator {
    private int round;
    private int position;
    private int score;
    private int yaku;
    private int fu;
    private int koutsuCount;
    private int shuntsuCount;
    private int pairCount;
    private int eyeCount;

    private int endtileCount;
    private HashSet<Tile> hand;

    public ScoreCalculator(HashSet<Tile> h, int r, int p) {
        this.hand = h;
        this.round = r;
        this.position = p;
        score = 0;
        yaku = 0;
        fu = 0;
        koutsuCount = 0;
        shuntsuCount = 0;
        pairCount = 0;
        eyeCount = 0;
        endtileCount = 0;


    }

    public void computeScore() {
        for (Tile t : hand) {
            if (t.getCount() == 2) {
                pairCount += 1;
                eyeCount += 1;
            }
            if (t.getIdNum() == 1 || t.getIdNum() == 9 || t.getCatergory() == "Honor" || t.getCatergory() == "Wind") {
                endtileCount += 1;
            }
        }
        if (endtileCount == 0) {
            yaku += 1;
        }
        // keep score = yaku for now when scoring system is incomplete
        score = yaku;
    }

    public int getScore() {
        return score;
    }
}
