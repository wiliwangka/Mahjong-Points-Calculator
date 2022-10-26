package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreCalculatorTest {
    private ArrayList<Tile> hand;

    @BeforeEach
    void runBefore() {
        hand = new ArrayList<Tile>();
        hand.add(new Man(8));
        hand.add(new Man(8));
        hand.add(new Man(8));
        hand.add(new So(7));
        hand.add(new So(6));
        hand.add(new So(8));
        hand.add(new Pin(2));
        hand.add(new Pin(2));
        hand.add(new Pin(2));
        hand.add(new So(5));
        hand.add(new So(6));
        hand.add(new So(7));
        hand.add(new Pin(8));
        hand.add(new Pin(8));

    }

    @Test
    void testConstructor() {
        ScoreCalculator riichi = new ScoreCalculator(hand, 1, 2);
        assertEquals(hand, riichi.getHand());
        assertEquals(1, riichi.getRound());
        assertEquals(2, riichi.getPosition());
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

       ArrayList<Tile> nokayu = new ArrayList<Tile>();
        nokayu.add(new Man(8));
        nokayu.add(new Man(8));
        nokayu.add(new Man(8));
        nokayu.add(new So(7));
        nokayu.add(new So(6));
        nokayu.add(new So(8));
        nokayu.add(new Pin(2));
        nokayu.add(new Pin(2));
        nokayu.add(new Pin(2));
        nokayu.add(new So(5));
        nokayu.add(new So(6));
        nokayu.add(new So(7));
        nokayu.add(new Wind(1));
        nokayu.add(new Wind(1));
        ScoreCalculator nokayugame = new ScoreCalculator(nokayu, 2, 3);
        nokayugame.computeScore();
        assertEquals(0, nokayugame.getYaku());
        assertEquals(1, nokayugame.getPairCount());
        assertEquals(1, nokayugame.getEyeCount());
    }

    @Test
    void testComputeScoreWithYaku() {

        ScoreCalculator nokayugame = new ScoreCalculator(hand, 2, 3);
        nokayugame.computeScore();
        assertEquals(1, nokayugame.getYaku());
    }

    @Test
    void testNoPairAndEye() {
        hand.clear();
        hand.add(new Man(8));
        hand.add(new Man(8));
        hand.add(new Man(8));
        hand.add(new So(7));
        hand.add(new So(6));
        hand.add(new So(8));
        hand.add(new Pin(2));
        hand.add(new Pin(2));
        hand.add(new Pin(2));
        hand.add(new So(5));
        hand.add(new So(6));
        hand.add(new So(7));
        hand.add(new Pin(8));
        hand.add(new Pin(8));
        hand.add(new Pin(8));
        ScoreCalculator nopairgame = new ScoreCalculator(hand, 2, 3);
        assertEquals(0, nopairgame.getPairCount());
        assertEquals(0, nopairgame.getEyeCount());
    }

    @Test
    void testMultiplePairAndEye() {
        hand.clear();
        hand.add(new Man(8));
        hand.add(new Man(8));
        hand.add(new Man(7));
        hand.add(new Man(7));
        hand.add(new So(6));
        hand.add(new So(6));
        hand.add(new Pin(2));
        hand.add(new Pin(2));
        hand.add(new Pin(2));
        hand.add(new So(5));
        hand.add(new So(6));
        hand.add(new So(7));
        hand.add(new Pin(8));
        hand.add(new Pin(8));
        hand.add(new Pin(8));
        ScoreCalculator nopairgame = new ScoreCalculator(hand, 2, 3);
        assertEquals(3, nopairgame.getPairCount());
        assertEquals(3, nopairgame.getEyeCount());
    }
    @Test
    void testsevenpairs() {
        hand.clear();
        hand.add(new Man(8));
        hand.add(new Man(8));
        hand.add(new Man(7));
        hand.add(new Man(7));
        hand.add(new So(6));
        hand.add(new So(6));
        hand.add(new Pin(2));
        hand.add(new Pin(2));
        hand.add(new So(5));
        hand.add(new So(5));
        hand.add(new So(6));
        hand.add(new So(6));
        hand.add(new Pin(8));
        hand.add(new Pin(8));

        ScoreCalculator nopairgame = new ScoreCalculator(hand, 2, 3);
        assertEquals(3, nopairgame.getPairCount());
        assertEquals(3, nopairgame.getEyeCount());
    }
}

