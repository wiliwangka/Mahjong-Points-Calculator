package model;
//represent the scoring system in Riichi Mahjong

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ScoreCalculator {
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

        tripletCount = 0;
        sanshokuCount = 0;
        sanshokotsuCount = 0;
        doubleyakumanCount = 0;
        yakumanCount = 0;
        winingMessages = new ArrayList<String>();
        initializehand();
        computeScore();
    }

    //modify this
    //Effect add tiles in closedhand and openedhand to hand
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
     * EFFECTS: at current stage: every yaku is included except shanshoku and shashokotsu
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

        score = yaku;
    }

    //Motify this
//EFFECT count the pair triples and koutsu
    private void pairntripletcounter() {
        for (Tile t : hand) {
            if (t.getCount() == 2 && !t.isInShuntsu()) {
                pairCount += 1;
            } else if (t.getCount() == 3 && !t.isInShuntsu()) {
                tripletCount += 1;

            } else if (t.getCount() == 4 && !t.isInShuntsu()) {
                koutsuCount += 1;
            }
        }
    }

    //Motify this
    // EFFECT computer score for hand that that doesn't have yakuman
    private void noYakuMan() {
        // six yaku
        purity();
//special yaku
        // three yaku
        junchantaiyao();
        if (!(winingMessages.contains("Chinitsu 清一色") || winingMessages.contains("Chinitsu 清一色 (opned)"))) {
            honitsu();
        }
        // two yaku
        sanshoku(); // todo
//        sanshokotsu();
        sankoutsu();
        toitoi();
        sananko();
        shosanen();
        honroto();
        sevenpairs();
        if (!winingMessages.contains("Honroutou 混老頭")) {
            chanta();
        }
        itsu();

        // one yaku
        tanyao();
        pinfu();
        iipeko();

        specialyaku();

    }

    //Motify this
    // EFFECT computer score for honor and wind tiplets
    private void specialyaku() {
        if (!(winingMessages.contains("Daisuushii 大四喜") || winingMessages.contains("Shousuushii 小四喜"))) {
            winds();
        }
        if (!(winingMessages.contains("Daisangen 大三元") || winingMessages.contains("Shousangen 小三元"))) {
            honors();
        }
    }


    //Modify this
// EFFECT compute yakue for winds
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
            winingMessages.add("Round Wind");
        }
        if (positionwindCount > 0) {
            yaku += 1;
            winingMessages.add("Self Wind");
        }
    }

    //Modify this
// EFFECT compute score for honors yaku
    private void honors() {
        for (Tile t : hand) {
            if (t.getCatergory().equals("Honor")) {
                if (t.getIdNum() == 1 && t.getCount() >= 3 && !winingMessages.contains("White 白")) {
                    yaku += 1;
                    winingMessages.add("White 白");
                } else if (t.getIdNum() == 2 && t.getCount() >= 3 && !winingMessages.contains("White 發")) {
                    yaku += 1;
                    winingMessages.add("White 發");
                } else if (t.getIdNum() == 3 && t.getCount() >= 3 && !winingMessages.contains("White 中")) {
                    yaku += 1;
                    winingMessages.add("White 中");
                }
            }
        }
    }


// one yaku


    //Modify this
// EFFECT determine if the hand contain tanyao yaku
    private void tanyao() {
        int endtileCount = 0;
        for (Tile t : hand) {
            if (t.getIdNum() == 1 || t.getIdNum() == 9 || t.getCatergory()
                    == "Honor" || t.getCatergory() == "Wind") {
                endtileCount += 1;
            }
        }

        if (endtileCount == 0) {
            yaku += 1;
            winingMessages.add("Tanyao 断么九");
        }
    }

    //Modify this
// EFFECT determine if the hand contain pinfu yaku
    private void pinfu() {
        if (openedhand.size() == 0) {
            int shungtsucount = 0;
            for (Tile t : closedhand) {
                if (t.startOfShuntsu()) {
                    shungtsucount += t.getstartofShuntsuCount();
                }
            }
            if (shungtsucount == 4) {
                yaku += 1;
                winingMessages.add("Pinfu 平和");
            }
        }
    }

    //Modify this
// EFFECT determine if the hand contain iipeko yaku
    private void iipeko() {
        int iipekoCount = 0;
        if (openedhand.size() == 0) {
            for (Tile t : hand) {
                if (t.getstartofShuntsuCount() == 2) {
                    iipekoCount += 1;
                }
            }

            if (iipekoCount / 2 == 1) {
                yaku += 1;
                winingMessages.add("Iipeikou 一盃口");

            } else if (iipekoCount / 2 == 2) {
                nipeko();
            }
        }
    }


    // two yaku
    //Modify this
// EFFECT determine if the hand contain sanshoku yaku
    private void sanshoku() {
        //todo failure
        ArrayList<Tile> s = (ArrayList<Tile>) hand.stream()
                .filter(t -> t.startOfShuntsu()).collect(Collectors.toList());
        boolean sanshoku = false;
        final int firstnum = s.get(0).getIdNum();
        int num = 0;
        for (Tile t : s) {
            if (t.getIdNum() != firstnum) {
                num = t.getIdNum();
            }
        }
        final int secnum = num;
        ArrayList<Tile> s1 = (ArrayList<Tile>) s.stream().filter(t -> t.getIdNum() == firstnum)
                .collect(Collectors.toList());
        ArrayList<Tile> s2 = (ArrayList<Tile>) s.stream().filter(t -> t.getIdNum() == secnum)
                .collect(Collectors.toList());
        sanshokuhelper(s1, s2);
    }

    private void sanshokuhelper(ArrayList<Tile> s1, ArrayList<Tile> s2) {
        ArrayList<Tile> s;
        if (s1.size() > s2.size()) {
            s = s1;
        } else {
            s = s2;
        }
        if (s.size() >= 3) {
            if (!(s.get(0).getCatergory().equals(s.get(1).getCatergory())
                    && s.get(0).getCatergory().equals(s.get(2).getCatergory()))) {
                yaku += 2;
                winingMessages.add("Sanshoku doujun 三色同順");
            }
        }
    }

    //Modify this
// EFFECT determine if the hand contain sanshokotsu yaku
    private void sanshokotsu() {
        //todo failure
        ArrayList<Tile> s = (ArrayList<Tile>) hand.stream().filter(t -> t.getCount() == 3).collect(Collectors.toList());
        boolean sanshokotsu = false;
        final int firstnum = s.get(0).getIdNum();
        int num = 0;


        for (Tile t : s) {
            if (t.getIdNum() != firstnum) {
                num = t.getIdNum();
            }
        }
        final int secnum = num;
        ArrayList<Tile> s1 = (ArrayList<Tile>) s.stream().filter(t -> t.getIdNum() == firstnum)
                .collect(Collectors.toList());
        ArrayList<Tile> s2 = (ArrayList<Tile>) s.stream().filter(t -> t.getIdNum() == secnum)
                .collect(Collectors.toList());
        if (s1.size() == 9 || s2.size() == 9) {
            yaku += 2;
            winingMessages.add("Sanshoku doukou 三色同刻");
        }

    }

    //Modify this
// EFFECT determine if the hand contain sankoutsu yaku
    private void sankoutsu() {
        if (koutsuCount / 4 == 3) {
            yaku += 2;
            winingMessages.add("Sankantsu 三槓子");
        }
    }

    //Modify this
// EFFECT determine if the hand contain toitoi  yaku
    private void toitoi() {
        if (tripletCount / 3 + koutsuCount / 4 >= 4) {
            yaku += 2;
            winingMessages.add("Toitoi 対々和 ");


        }

    }

    //Modify this
// EFFECT determine if the hand contain sananko yaku
    private void sananko() {

        int ankoCount = 0;
        for (Tile t : closedhand) {
            if (t.getCount() == 3 && !t.isInShuntsu()) {
                ankoCount += 1;
            }
        }
        if (ankoCount / 3 == 3) {
            yaku += 2;
            winingMessages.add("Sanankou 三暗刻");
        }
    }

    //Modify this
// EFFECT determine if the hand contain shosanen yaku
    private void shosanen() {

        int whitecount = 0;
        int greencount = 0;
        int redcount = 0;

        for (Tile t : hand) {
            if (t.getCatergory().equals("Honor")) {
                if (t.getIdNum() == 1) {
                    whitecount = t.getCount();
                } else if (t.getIdNum() == 2) {
                    greencount = t.getCount();
                } else if (t.getIdNum() == 3) {
                    redcount = t.getCount();
                }
            }
        }
        if ((whitecount >= 3 && greencount >= 3 && redcount >= 3)
                || (whitecount >= 3 && greencount >= 3 && redcount == 2)
                || (whitecount >= 3 && greencount == 2 && redcount >= 3)
                || (whitecount == 2 && greencount >= 3 && redcount >= 3)) {
            yakumanCount += 1;
            winingMessages.add("Shousangen 小三元");
        }

    }

    //Modify this
// EFFECT determine if the hand contain honroto yaku
    private void honroto() {

        boolean chanku = true;
        for (Tile t : hand) {
            if (!(t.getCatergory().equals("Wind") || t.getCatergory().equals("Honor"))) {
                if (!(t.getIdNum() == 1 || t.getIdNum() == 9)) {
                    chanku = false;
                }
            }
        }

        if (chanku) {
            yaku += 2;
            winingMessages.add("Honroutou 混老頭");
        }
    }

    //Modify this
// EFFECT determine if the hand contain sevenpairs yaku
    private void sevenpairs() {
        if (openedhand.size() == 0) {
            if (pairCount / 2 == 7) {
                yaku += 2;
                winingMessages.add("Chiitoitsu 七対子");
            }
        }
    }

    //Modify this
// EFFECT determine if the hand contain chanta  yaku
    private void chanta() {
        //todo failure prodiction
        boolean chanta = true;
        for (Tile t : hand) {
            if (!(t.getCatergory().equals("Wind") || t.getCatergory().equals("Honor"))) {
                if (!(t.getIdNum() == 1 || t.getIdNum() == 9)) {
                    if (!(t.getIdNum() == 2 || t.getIdNum() == 3 || t.getIdNum() == 7 || t.getIdNum() == 8)) {
                        chanta = false;
                    }
                    if (!t.isInShuntsu()) {
                        chanta = false;
                    }
                }
            }
        }
        if (chanta && openedhand.size() == 0) {
            yaku += 2;
            winingMessages.add("Chanta 混全帯么九");
        } else if (chanta) {
            yaku += 1;
            winingMessages.add("Chanta 混全帯么九 (opened)");
        }
    }

    //Modify this
// EFFECT determine if the hand contain itsu yaku
    private void itsu() {
        //todo fail to detect itsu
        ArrayList<Tile> manhand = new ArrayList<Tile>();
        ArrayList<Tile> sohand = new ArrayList<Tile>();
        ArrayList<Tile> pinhand = new ArrayList<Tile>();
        for (Tile t : hand) {

            if (t.getCatergory().equals("Man")) {
                manhand.add(t);
            } else if (t.getCatergory().equals("So")) {
                sohand.add(t);
            } else if (t.getCatergory().equals("Pin")) {
                pinhand.add(t);
            }
        }
        if (itsuhelper(manhand) || itsuhelper(sohand) || itsuhelper(pinhand)) {
            if (openedhand.size() == 0) {
                yaku += 2;
                winingMessages.add("Ittsu 一気通貫");
            } else {
                yaku += 1;
                winingMessages.add("Ittsu 一気通貫 (opned)");
            }
        }
    }

    // require the Tile in ArrayList with the same .getCategory() value
    //Modify this
// EFFECT check the present of 1-9 tiles for a single color
    @SuppressWarnings("methodlength")
    private boolean itsuhelper(ArrayList<Tile> hand) {
        boolean onecheck = false;
        boolean twocheck = false;
        boolean threecheck = false;
        boolean fourcheck = false;
        boolean fivecheck = false;
        boolean sixcheck = false;
        boolean sevencheck = false;
        boolean eightcheck = false;
        boolean ninecheck = false;
        if (hand.size() < 9) {
            return false;
        }
        for (Tile t : hand) {
            if (t.isInShuntsu()) {
                switch (t.getIdNum()) {
                    case 1:
                        onecheck = true;
                        break;
                    case 2:
                        twocheck = true;
                        break;
                    case 3:
                        threecheck = true;
                        break;
                    case 4:
                        fourcheck = true;
                        break;
                    case 5:
                        fivecheck = true;
                        break;
                    case 6:
                        sixcheck = true;
                        break;
                    case 7:
                        sevencheck = true;
                        break;
                    case 8:
                        eightcheck = true;
                        break;
                    case 9:
                        ninecheck = true;
                        break;
                }
            }
        }
        if (onecheck && twocheck && threecheck && fourcheck
                && fivecheck && sixcheck && sevencheck && eightcheck && ninecheck) {
            return true;
        }
        return false;
    }

    // three yaku


    //Modify this
// EFFECT determine if the hand contain nipeko yaku
    private void nipeko() {
        //todo no sever pair when have nipeko //chanta will trigger this ???
        yaku += 3;
        winingMessages.add("Ryanpeikou 二盃口");

    }

    //Modify this
// EFFECT determine if the hand contain junchantaiyao  yaku
    private void junchantaiyao() {
        boolean junchanta = true;
        for (Tile t : hand) {
            if (t.getCatergory().equals("Wind") || t.getCatergory().equals("Honor")) {
                junchanta = false;
            }
            if (!(t.getIdNum() == 1 || t.getIdNum() == 9)) {
                if (!(t.getIdNum() == 2 || t.getIdNum() == 3 || t.getIdNum() == 7 || t.getIdNum() == 8)
                        || !t.isInShuntsu()) {
                    junchanta = false;
                }
            }
        }

        if (junchanta && openedhand.size() == 0) {
            yaku += 3;
            winingMessages.add("Junchan taiyao 純全帯么");
        } else if (junchanta && openedhand.size() > 0) {
            yaku += 2;
            winingMessages.add("Junchan taiyao 純全帯么 (opned)");
        }

    }

    //Modify this
// EFFECT determine if the hand contain honitsu yaku
    private void honitsu() {
        boolean ispure = true;
        String color = "";
        for (Tile t : hand) {
            if (!(t.getCatergory().equals("Wind") || t.getCatergory().equals("Honor"))) {
                color = t.getCatergory();
                break;
            }
        }

        for (Tile t : hand) {
            if (!(t.getCatergory().equals("Wind") || t.getCatergory().equals("Honor"))) {
                if (!t.getCatergory().equals(color)) {
                    ispure = false;
                }
            }
        }
        if (ispure && openedhand.size() == 0) {
            yaku += 3;
            winingMessages.add("Honitsu 混一色");
        } else if (ispure && openedhand.size() > 0) {
            yaku += 2;
            winingMessages.add("Honitsu 混一色 (opned)");
        }
    }


    // six yaku
    //Modify this
// EFFECT determine if the hand contain purity  yaku
    //this hand is composed entirely of tiles from only one of the three suits. It is the only yaku set at 6 han
    private void purity() {
        boolean ispurity = true;
        String color = hand.get(1).getCatergory();
        for (Tile t : hand) {
            if (t.getCatergory().equals("Wind") || t.getCatergory().equals("Honor")) {
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


    //Modify this
// EFFECT determine if the hand contain taisanyen  yaku
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

    //Modify this
// EFFECT determine if the hand contain tsuiso yaku
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

    //Modify this
// EFFECT determine if the hand contain greenpurity yaku
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

    //Modify this
// EFFECT determine if the hand contain chunroto  yaku
    //Every group of tiles are composed of terminal tiles.
    private void chunroto() {
        int endtilescount = 0;
        for (Tile t : hand) {
            if (t.getCatergory().equals("Man") || t.getCatergory().equals("So") || t.getCatergory().equals("Pin")) {
                if (t.getIdNum() == 1 || t.getIdNum() == 9) {
                    endtilescount += 1;
                }
            }
        }
        if (endtilescount >= 14 && tripletCount + koutsuCount >= 4) {
            yakumanCount += 1;
            winingMessages.add("Chinroutou 清老頭");
        }

    }

    //Modify this
// EFFECT determine if the hand contain suuankou yaku
    private void suuankou() {

        int ankoCount = 0;
        for (Tile t : closedhand) {
            if (t.getCount() == 3 && !t.isInShuntsu()) {
                ankoCount += 1;
            }
        }
        if (ankoCount / 3 == 4) {
            yakumanCount += 1;
            winingMessages.add("Suuankou 四暗刻");
        }
    }

    //Modify this
// EFFECT determine if the hand contain kokushi musou yaku
    //This hand has one of each of the 13 different terminal and honor tiles plus one extra terminal or honour tile.
    private void gokusumuso() {
        if (hand.contains(new So(1)) && hand.contains(new So(9)) && hand.contains(new Man(1))
                && hand.contains(new Man(9)) && hand.contains(new Pin(1))
                && hand.contains(new Pin(9)) && hand.contains(new Wind(1))
                && hand.contains(new Wind(2)) && hand.contains(new Wind(3))
                && hand.contains(new Wind(4)) && hand.contains(new Honor(1))
                && hand.contains(new Honor(2)) && hand.contains(new Honor(3))) {
            yakumanCount += 1;
            winingMessages.add("Kokushi musou 国士無双 ");
        }

    }

    //Modify this
// EFFECT determine if the hand contain shosushi yaku
    //This hand has three groups (triplets or quads) of the wind tiles plus a pair of the fourth kind.
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
        shoosuushiihelper(eastcount, southcount, westcount, northcount);
    }

    //Modify this
// EFFECT helper method for soosuushii , check if east, south ,west,north is present and set score and wining message
    private void shoosuushiihelper(int eastcount, int southcount, int westcount, int northcount) {
        if ((eastcount >= 3 && southcount >= 3 && westcount >= 3 && northcount == 2)
                || (eastcount >= 3 && southcount >= 3 && westcount == 2 && northcount >= 3)
                || (eastcount >= 3 && southcount == 2 && westcount >= 3 && northcount >= 3)
                || (eastcount == 2 && southcount >= 3 && westcount >= 3 && northcount >= 3)) {
            yakumanCount += 1;
            winingMessages.add("Shousuushii 小四喜");
        }
    }

    //Modify this
// EFFECT determine if the hand contain suukantsu yaku
    //Any hand with four calls of kan.
    private void fourkon() {
        if (koutsuCount == 16) {
            yakumanCount += 1;
            winingMessages.add(" Suukantsu 四槓子");
        }
    }

    //Modify this
// EFFECT determine if the hand contain chuurenpoutou yaku
    //A hand consisting of the tiles 1112345678999 in the same suit plus any one extra tile in Man Tile.
    private void chuurenPoutou() {
        if (openedhand.size() == 0
                && hand.stream().filter(t -> t.getCatergory().equals("Man")).collect(Collectors.toList()).size() >= 14
                && hand.stream().filter(o -> o.getIdNum() == 1).collect(Collectors.toList()).size() >= 3
                && hand.stream().filter(o -> o.getIdNum() == 2).collect(Collectors.toList()).size() >= 1
                && hand.stream().filter(o -> o.getIdNum() == 3).collect(Collectors.toList()).size() >= 1
                && hand.stream().filter(o -> o.getIdNum() == 4).collect(Collectors.toList()).size() >= 1
                && hand.stream().filter(o -> o.getIdNum() == 5).collect(Collectors.toList()).size() >= 1
                && hand.stream().filter(o -> o.getIdNum() == 6).collect(Collectors.toList()).size() >= 1
                && hand.stream().filter(o -> o.getIdNum() == 7).collect(Collectors.toList()).size() >= 1
                && hand.stream().filter(o -> o.getIdNum() == 8).collect(Collectors.toList()).size() >= 1
                && hand.stream().filter(o -> o.getIdNum() == 9).collect(Collectors.toList()).size() >= 3) {
            yakumanCount += 1;
            winingMessages.add(" Chuuren poutou 九連宝燈");
        }
    }


    // double yakuman

    //Modify this
// EFFECT determine if the hand contain tasuushi  yaku
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
