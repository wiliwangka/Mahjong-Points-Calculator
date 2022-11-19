package model;
//represent the scoring system in Riichi Mahjong

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class ScoreCalculator {
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

    private int round;
    private int position;
    private int score;
    private int yaku;
    private int fu;
    private int koutsuCount;
    private int shuntsuCount;
    private int tripletCount;
    private int pairCount;
    private int eyeCount;

    private int yakumanCount;
    private int doubleyakumanCount;


    private int sanshokuCount;
    private int sanshokotsuCount;

    private ArrayList<String> winingMessages;

    private int endtileCount;
    private ArrayList<Tile> openedhand;
    private ArrayList<Tile> closedhand;

    private ArrayList<Tile> hand;

    /*
     * REQUIRES: h.size() =14 , 4>=r >=1 , 4>= p>=1
     * * MODIFIES this
     * EFFECTS: construct a scoring calculator with all component needed to get the final score
     */
    public ScoreCalculator(Mahjong m) {
        this.closedhand = m.getClosedhand();
        this.openedhand = m.getOpenedhand();
        this.round = m.getRound();
        this.position = m.getPosition();
        score = 0;
        yaku = 0;
        fu = 0;
        koutsuCount = 0;
        shuntsuCount = 0;
        pairCount = 0;
        eyeCount = 0;
        endtileCount = 0;
        tripletCount = 0;
        sanshokuCount = 0;
        sanshokotsuCount = 0;
        doubleyakumanCount = 0;
        yakumanCount = 0;
        winingMessages = new ArrayList<String>();
        initializehand();
        computeScore();
    }

    private void initializehand() {
        hand = new ArrayList<Tile>();
        for (Tile t : closedhand) {
            hand.add(t);
        }
        for (Tile s : openedhand) {
            hand.add(s);
        }
    }

    /*

     * * MODIFIES this
     * EFFECTS: at current stage:add up and indicate if the hand contain tanyao yaku
     ,if no yaku is presented than yaku = 0

     */
    public void computeScore() {
        pairntripletcounter();
        //double yakuman

        taSuushi();
        // yakuman
        suuankou();
        taisanyen();
        tsuiso();
        greenpurity();
        chunroto();
        gokusumuso();
        shosushi();
        fourkon();
        chuurenPoutou();

        if (yakumanCount == 0 && doubleyakumanCount == 0) {
            noYakuMan();
        }


//        for (Tile t : hand) {
//            if (t.getCount() == 2) {
//                pairCount += 1;
//                eyeCount += 1;
//            }
//
//            if (t.getIdNum() == 1 || t.getIdNum() == 9 || t.getCatergory() == "Honor" || t.getCatergory() == "Wind") {
//                endtileCount += 1;
//            }
//        }
//        if (endtileCount == 0) {
//            yaku += 1;
//        }
//        if (pairCount / 2 == 7) {
//            yaku += 1;
//        }
        // keep score = yaku for now as the scoring system is incomplete
        score = yaku;
    }

    private void pairntripletcounter() {
        for (Tile t : hand) {
            if (t.getCount() == 2 && !t.isInShuntsu()) {
                pairCount += 1;
            } else if (t.getCount() == 3 && !t.isInShuntsu()) {
                tripletCount += 1;

            } else if (t.getCount() == 3 && !t.isInShuntsu()) {
                koutsuCount += 1;
            }
        }
    }

    private void noYakuMan() {
        //special yaku
        winds();
        honors();
        // one yaku
        tanyao();
        closedhand();
        pinfu();
        iipeko();
        // two yaku
        sanshoku();
        sanshokotsu();
        sankoutsu();
        toitoi();
        sananko();
        shosanen();
        honroto();
        sevenpairs();
        chanku();
        itsu();
        sanrenko();
        // three yaku
        nipeko();
        shunchanta();
        ponitsu();
        isosanshungtsu();
        // six yaku
        purity();
    }

//special yaku

    private void riichi() {
    }

    private void dora() {
    }

    private void winds() {
        int roundwindCount = 0;
        int positionwindCount = 0;
        for (Tile t : hand) {
            if (t.getCatergory().equals("Wind")) {
                if (t.getIdNum() == round && t.getCount() == 3) {
                    roundwindCount += 1;
                }
                if (t.getIdNum() == position && t.getCount() == 3) {
                    positionwindCount += 1;

                }
            }
        }
        if (roundwindCount > 0) {
            yaku += 1;
            winingMessages.add("round wind");
        }
        if (positionwindCount > 0) {
            yaku += 1;
            winingMessages.add("position wind");
        }
    }

    private void honors() {
    }

    // one yaku
    private void tanyao() {
        //            if (t.getIdNum() == 1 || t.getIdNum() == 9 || t.getCatergory()
        //            == "Honor" || t.getCatergory() == "Wind") {
//                endtileCount += 1;
//            }
//        }
//        if (endtileCount == 0) {
//            yaku += 1;
//        }
    }

    private void closedhand() {
    }


    private void pinfu() {
    }

    private void iipeko() {
    }


    // two yaku

    private void sanshoku() {
    }

    private void sanshokotsu() {
    }

    private void sankoutsu() {
    }

    private void toitoi() {
    }

    private void sananko() {
        int ankoCount = 0;
        for (Tile t : closedhand) {
            if (t.getCount() == 3 && !t.isInShuntsu()) {
                tripletCount += 1;
            }
        }
        if (ankoCount / 4 == 3) {
            yaku += 2;
            winingMessages.add("Sanankou 三暗刻");
        }
    }

    private void shosanen() {
    }

    private void honroto() {
    }

    private void sevenpairs() {

    }

    private void chanku() {

    }


    private void itsu() {

    }

    private void sanrenko() {
    }

    // three yaku
    private void nipeko() {

    }

    private void shunchanta() {

    }

    private void ponitsu() {

    }

    private void isosanshungtsu() {

    }


    // six yaku

    //his hand is composed entirely of tiles from only one of the three suits. It is the only yaku set at 6 han
    private void purity() {
        boolean ispurity = true;
        String color = hand.get(1).getCatergory();
        for (Tile t : hand) {
            if (t.getCatergory().equals("Wind") || t.getCatergory().equals("Wind")) {
                ispurity = false;
            }
            if (!t.getCatergory().equals(color)) {
                ispurity = false;
            }
        }
        if (ispurity && openedhand.size() == 0) {
            yaku += 6;
            winingMessages.add("Chinitsu 清一色");
        } else if (ispurity && openedhand.size() > 0) {
            yaku += 5;
            winingMessages.add("Chinitsu 清一色 (opned)");
        }
    }

    // yakuman

    private void taisanyen() {
        boolean whitepresent = false;
        boolean greenpresent = false;
        boolean redpresent = false;


        for (Tile t : hand) {
            if (t.getCatergory().equals("Honor") && t.getIdNum() == 1 && t.getCount() >= 3) {
                whitepresent = true;
            } else if (t.getCatergory().equals("Honor") && t.getIdNum() == 2 && t.getCount() >= 3) {
                greenpresent = true;
            } else if (t.getCatergory().equals("Honor") && t.getIdNum() == 3 && t.getCount() >= 3) {
                redpresent = true;
            }

        }
        if (whitepresent && greenpresent && redpresent) {
            yakumanCount += 1;
            winingMessages.add("Daisangen 大三元");
        }
    }


    private void tsuiso() {
        int alphabettilescount = 0;
        for (Tile t : hand) {

            if (t.getCatergory() == "Honor" || t.getCatergory() == "Wind") {
                alphabettilescount += 1;
            }
        }
        if (alphabettilescount >= 14) {
            yakumanCount += 1;
            winingMessages.add("Tsuuiisou 字一色");
        }
    }

    //A hand composed entirely of green tiles: 2, 3, 4, 6 and 8 Sou and/or Hatsu.
    private void greenpurity() {
        int greentilescount = 0;
        for (Tile t : hand) {
            if (t.getCatergory().equals("So")) {
                if (t.getIdNum() == 2 || t.getIdNum() == 3 || t.getIdNum() == 4
                        || t.getIdNum() == 6 || t.getIdNum() == 8) {
                    greentilescount += 1;
                }
            } else if (t.getCatergory().equals("Honor")) {
                if (t.getIdNum() == 2) {
                    greentilescount += 1;
                }
            }
        }
        if (greentilescount >= 14) {
            yakumanCount += 1;
            winingMessages.add("Ryuuiisou 緑一色");
        }
    }

    //Every group of tiles are composed of terminal tiles.
    private void chunroto() {
        int endtilescount = 0;
        for (Tile t : hand) {
            if (t.getIdNum() == 1 || t.getIdNum() == 9 || t.getCatergory() == "Honor" || t.getCatergory() == "Wind") {
                endtilescount += 1;
            }
        }
        if (endtilescount >= 14 && tripletCount >= 0) {
            yakumanCount += 1;
            winingMessages.add("Chinroutou 清老頭");
        }

    }

    private void suuankou() {

        int ankoCount = 0;
        for (Tile t : closedhand) {
            if (t.getCount() == 3 && !t.isInShuntsu()) {
                tripletCount += 1;
            }
        }
        if (ankoCount / 4 == 4) {
            yakumanCount += 1;
            winingMessages.add("Suuankou 四暗刻");
        }
    }

    //This hand has one of each of the 13 different terminal and honor tiles plus one extra terminal or honour tile.
    private void gokusumuso() {
        if (hand.contains(s1) && hand.contains(s9) && hand.contains(m1) && hand.contains(m9)
                && hand.contains(p1) && hand.contains(p9) && hand.contains(w1) && hand.contains(w2)
                && hand.contains(w3) && hand.contains(w4) && hand.contains(h1) && hand.contains(h2)
                && hand.contains(h3)) {
            yakumanCount += 1;
            winingMessages.add("Kokushi musou 国士無双 ");
        }

    }

    //This hand has three groups (triplets or quads) of the wind tiles plus a pair of the fourth kind.
    @SuppressWarnings("methodlength")
    private void shosushi() {
        int eastcount = 0;
        int southcount = 0;
        int westcount = 0;
        int northcount = 0;
        for (Tile t : hand) {
            if (t.getCatergory().equals("Wind")) {
                if (t.getIdNum() == 1) {
                    eastcount = t.getCount();
                } else if (t.getIdNum() == 2) {
                    southcount = t.getCount();
                } else if (t.getIdNum() == 3) {
                    westcount = t.getCount();
                } else if (t.getIdNum() == 4) {
                    northcount = t.getCount();
                }
            }
        }
        if ((eastcount >= 3 && southcount >= 3 && westcount >= 3 && northcount == 2)
                || (eastcount >= 3 && southcount >= 3 && westcount == 2 && northcount >= 3)
                || (eastcount >= 3 && southcount == 2 && westcount >= 3 && northcount >= 3)
                || (eastcount == 2 && southcount >= 3 && westcount >= 3 && northcount >= 3)) {
            yakumanCount += 1;
            winingMessages.add("Shousuushii 小四喜");
        }
    }


    //Any hand with four calls of kan.
    private void fourkon() {
        if (koutsuCount == 4) {
            yakumanCount += 1;
            winingMessages.add(" Suukantsu 四槓子");
        }
    }

    //A hand consisting of the tiles 1112345678999 in the same suit plus any one extra tile in Man Tile.
    @SuppressWarnings("methodlength")
    private void chuurenPoutou() {
        if (openedhand.size() == 0) {
            if (hand.stream().filter(t -> t.getCatergory().equals("Man")).collect(Collectors.toList()).size() >= 14) {
                if (hand.stream().filter(o -> o.getIdNum() == 1).collect(Collectors.toList()).size() >= 3) {
                    if (hand.stream().filter(o -> o.getIdNum() == 2).collect(Collectors.toList()).size() >= 1) {
                        if (hand.stream().filter(o -> o.getIdNum() == 3).collect(Collectors.toList()).size() >= 1) {
                            if (hand.stream().filter(o -> o.getIdNum() == 4).collect(Collectors.toList()).size() >= 1) {
                                if (hand.stream().filter(o -> o.getIdNum() == 5)
                                        .collect(Collectors.toList()).size() >= 1) {
                                    if (hand.stream().filter(o -> o.getIdNum() == 6)
                                            .collect(Collectors.toList()).size() >= 1) {
                                        if (hand.stream().filter(o -> o.getIdNum() == 7)
                                                .collect(Collectors.toList()).size() >= 1) {
                                            if (hand.stream().filter(o -> o.getIdNum() == 8)
                                                    .collect(Collectors.toList()).size() >= 1) {
                                                if (hand.stream().filter(o -> o.getIdNum() == 9)
                                                        .collect(Collectors.toList()).size() >= 3) {
                                                    yakumanCount += 1;
                                                    winingMessages.add(" Chuuren poutou 九連宝燈");
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }


    // double yakuman


    //This hand has four groups (triplets or quads) of all four wind tiles.
    private void taSuushi() {
        boolean eastpresent = false;
        boolean southpresent = false;
        boolean westpresent = false;
        boolean northpresent = false;

        for (Tile t : hand) {
            if (t.getCatergory().equals("Wind") && t.getIdNum() == 1 && t.getCount() >= 3) {
                eastpresent = true;
            } else if (t.getCatergory().equals("Wind") && t.getIdNum() == 2 && t.getCount() >= 3) {
                southpresent = true;
            } else if (t.getCatergory().equals("Wind") && t.getIdNum() == 3 && t.getCount() >= 3) {
                westpresent = true;
            } else if (t.getCatergory().equals("Wind") && t.getIdNum() == 4 && t.getCount() >= 3) {
                northpresent = true;
            }

        }
        if (eastpresent && southpresent && westpresent && northpresent) {
            doubleyakumanCount += 1;
            winingMessages.add("Daisuushii 大四喜");
        }
    }


    ///getters and setters

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getYaku() {
        return yaku;
    }

    public void setYaku(int yaku) {
        this.yaku = yaku;
    }

    public int getFu() {
        return fu;
    }

    public void setFu(int fu) {
        this.fu = fu;
    }

    public int getKoutsuCount() {
        return koutsuCount;
    }

    public void setKoutsuCount(int koutsuCount) {
        this.koutsuCount = koutsuCount;
    }

    public int getShuntsuCount() {
        return shuntsuCount;
    }

    public void setShuntsuCount(int shuntsuCount) {
        this.shuntsuCount = shuntsuCount;
    }

    public int getTripletCount() {
        return tripletCount;
    }

    public void setTripletCount(int tripletCount) {
        this.tripletCount = tripletCount;
    }

    public int getPairCount() {
        return pairCount;
    }

    public void setPairCount(int pairCount) {
        this.pairCount = pairCount;
    }

    public int getEyeCount() {
        return eyeCount;
    }

    public void setEyeCount(int eyeCount) {
        this.eyeCount = eyeCount;
    }

    public int getYakumanCount() {
        return yakumanCount;
    }

    public void setYakumanCount(int yakumanCount) {
        this.yakumanCount = yakumanCount;
    }

    public int getDoubleyakumanCount() {
        return doubleyakumanCount;
    }

    public void setDoubleyakumanCount(int doubleyakumanCount) {
        this.doubleyakumanCount = doubleyakumanCount;
    }

    public int getSanshokuCount() {
        return sanshokuCount;
    }

    public void setSanshokuCount(int sanshokuCount) {
        this.sanshokuCount = sanshokuCount;
    }

    public int getSanshokotsuCount() {
        return sanshokotsuCount;
    }

    public void setSanshokotsuCount(int sanshokotsuCount) {
        this.sanshokotsuCount = sanshokotsuCount;
    }

    public ArrayList<String> getWiningMessages() {
        return winingMessages;
    }

    public void setWiningMessages(ArrayList<String> winingMessages) {
        this.winingMessages = winingMessages;
    }

    public int getEndtileCount() {
        return endtileCount;
    }

    public void setEndtileCount(int endtileCount) {
        this.endtileCount = endtileCount;
    }

    public ArrayList<Tile> getOpenedhand() {
        return openedhand;
    }

    public void setOpenedhand(ArrayList<Tile> openedhand) {
        this.openedhand = openedhand;
    }

    public ArrayList<Tile> getClosedhand() {
        return closedhand;
    }

    public void setClosedhand(ArrayList<Tile> closedhand) {
        this.closedhand = closedhand;
    }

    public ArrayList<Tile> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Tile> hand) {
        this.hand = hand;
    }
}
