package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreCalculatorTest {
    private ArrayList<String> openedinput;
    private ArrayList<String> closedinput;
    private Mahjong game;


    @BeforeEach
    void runBefore() {
        closedinput = new ArrayList<>();
        openedinput = new ArrayList<>();


//        closedhand = new ArrayList<Tile>();
//        closedhand.add(new Man(8));
//        closedhand.add(new Man(8));
//        closedhand.add(new Man(8));
//        closedhand.add(new So(7));
//        closedhand.add(new So(6));
//        closedhand.add(new So(8));
//        closedhand.add(new Pin(2));
//        closedhand.add(new Pin(2));
//        closedhand.add(new Pin(2));
//
//
//        openedhand.add(new So(5));
//        openedhand.add(new So(6));
//        openedhand.add(new So(7));
//        openedhand.add(new Pin(8));
//        openedhand.add(new Pin(8));


    }

    @Test
    void testConstructor() {
        openedinput.add("s2");
        openedinput.add("s2");
        openedinput.add("s2");
        openedinput.add("h1");
        openedinput.add("h2");
        openedinput.add("h3");
        openedinput.add("w1");
        openedinput.add("w2");
        closedinput.add("m3");
        closedinput.add("m4");
        closedinput.add("m5");
        closedinput.add("p6");
        closedinput.add("p7");
        closedinput.add("p8");
        game = new Mahjong(closedinput, openedinput, 1, 1);
        ScoreCalculator riichi = new ScoreCalculator(game);
        assertEquals(riichi.getClosedhand() , game.getClosedhand());
        assertEquals(1, riichi.getRound());
        assertEquals(1, riichi.getPosition());
        assertEquals(0, riichi.getYaku());
        assertEquals(0, riichi.getScore());
        assertEquals(0, riichi.getFu());
        assertEquals(0, riichi.getKoutsuCount());
        assertEquals(0, riichi.getShuntsuCount());
        assertEquals(0, riichi.getPairCount());
        assertEquals(0, riichi.getEyeCount());
        assertEquals(0, riichi.getEndtileCount());

    }

    @Test
    void testComputeScoreWithNoYaku() {
        openedinput.add("s2");
        openedinput.add("s2");
        openedinput.add("s2");
        openedinput.add("h1");
        openedinput.add("h2");
        openedinput.add("h3");
        openedinput.add("w1");
        openedinput.add("w2");

        closedinput.add("m3");
        closedinput.add("m4");
        closedinput.add("m5");
        closedinput.add("p6");
        closedinput.add("p7");
        closedinput.add("p8");
        game = new Mahjong(closedinput, openedinput, 1, 1);
        ScoreCalculator nokayugame = new ScoreCalculator(game);

        assertEquals(0, nokayugame.getYaku());

    }
//
//    @Test
//    void testComputeScoreWithYaku() {
//
//        ScoreCalculator nokayugame = new ScoreCalculator(hand, 2, 3);
//        nokayugame.computeScore();
//        assertEquals(1, nokayugame.getYaku());
//    }
//
//    @Test
//    void testNoPairAndEye() {
//        hand.clear();
//        hand.add(new Man(8));
//        hand.add(new Man(8));
//        hand.add(new Man(8));
//        hand.add(new So(7));
//        hand.add(new So(6));
//        hand.add(new So(8));
//        hand.add(new Pin(2));
//        hand.add(new Pin(2));
//        hand.add(new Pin(2));
//        hand.add(new So(5));
//        hand.add(new So(6));
//        hand.add(new So(7));
//        hand.add(new Pin(8));
//        hand.add(new Pin(8));
//        hand.add(new Pin(8));
//        ScoreCalculator nopairgame = new ScoreCalculator(hand, 2, 3);
//        nopairgame.computeScore();
//        assertEquals(0, nopairgame.getPairCount());
//        assertEquals(0, nopairgame.getEyeCount());
//    }
//
//    //    @Test
////    void testMultiplePairAndEye() {
////        hand.clear();
////        hand.add(new Man(8));
////        hand.add(new Man(8));
////        hand.add(new Man(7));
////        hand.add(new Man(7));
////        hand.add(new So(6));
////        hand.add(new So(6));
////        hand.add(new Pin(2));
////        hand.add(new Pin(2));
////        hand.add(new Pin(2));
////        hand.add(new So(5));
////        hand.add(new So(6));
////        hand.add(new So(7));
////        hand.add(new Pin(8));
////        hand.add(new Pin(8));
////        hand.add(new Pin(8));
////        ScoreCalculator nopairgame = new ScoreCalculator(hand, 2, 3);
////        nopairgame.computeScore();
////        assertEquals(3, nopairgame.getPairCount());
////        assertEquals(3, nopairgame.getEyeCount());
////    }
//    @Test
//    void testsevenpairs() {
//        ArrayList<String> handforsevenpairs = new ArrayList<String>();
//        handforsevenpairs.add("m8");
//        handforsevenpairs.add("m8");
//        handforsevenpairs.add("m7");
//        handforsevenpairs.add("m7");
//        handforsevenpairs.add("m6");
//        handforsevenpairs.add("m6");
//        handforsevenpairs.add("m5");
//        handforsevenpairs.add("m5");
//        handforsevenpairs.add("m4");
//        handforsevenpairs.add("m4");
//        handforsevenpairs.add("m3");
//        handforsevenpairs.add("m3");
//        handforsevenpairs.add("m2");
//        handforsevenpairs.add("m2");
//
//        Mahjong newgame = new Mahjong(handforsevenpairs, 1, 2);
//        newgame.mahjongGame();
//        ArrayList<Tile> handforcalculator = newgame.getHand();
//
//
//        ScoreCalculator game = new ScoreCalculator(handforcalculator, 2, 3);
//        game.computeScore();
//        assertEquals(2, game.getYaku());
//        assertEquals(14, game.getPairCount());
//        assertEquals(14, game.getEyeCount());
//    }
}

