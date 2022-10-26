package model;
//represent the scoring system in Riichi Mahjong

import java.util.ArrayList;

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
    private ArrayList<Tile> hand;

    /*
     * REQUIRES: h.size() =14 , 4>=r >=1 , 4>= p>=1
     * * MODIFIES this
     * EFFECTS: construct a scoring calculator with all component needed to get the final score
     */
    public ScoreCalculator(ArrayList<Tile> h, int r, int p) {
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

    /*

     * * MODIFIES this
     * EFFECTS: at current stage:add up and indicate if the hand contain tanyao yaku
     ,if no yaku is presented than yaku = 0

     */
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
        // keep score = yaku for now as the scoring system is incomplete
        score = yaku;
    }

    public int getScore() {
        return score;
    }

    public int getRound() {
        return round;
    }

    public int getPosition() {
        return position;
    }

    public int getYaku() {
        return yaku;
    }

    public int getFu() {
        return fu;
    }

    public int getKoutsuCount() {
        return koutsuCount;
    }

    public int getShuntsuCount() {
        return shuntsuCount;
    }

    public int getPairCount() {
        return pairCount;
    }

    public int getEyeCount() {
        return eyeCount;
    }

    public int getEndtileCount() {
        return endtileCount;
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }
}
