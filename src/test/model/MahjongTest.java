package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.concurrent.ScheduledFuture;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MahjongTest {
//    private ArrayList<String> openedinput;
//    private ArrayList<String> closedinput;
//    private Mahjong game;
//
//    private ScoreCalculator score;
//
//
//    @BeforeEach
//    void runBefore() {
//        closedinput = new ArrayList<>();
//        openedinput = new ArrayList<>();
//
//    }
//
//    @Test
//    void testMahjongNoScore() {
//        openedinput.add("s2");
//        openedinput.add("s2");
//        openedinput.add("s2");
//
//        closedinput.add("m3");
//        closedinput.add("m4");
//        closedinput.add("m5");
//        closedinput.add("p6");
//        closedinput.add("p7");
//        closedinput.add("p8");
//
//        openedinput.add("h1");
//        openedinput.add("h2");
//        openedinput.add("h3");
//        openedinput.add("w1");
//        openedinput.add("w2");
//        game = new Mahjong(closedinput, openedinput, 1, 1);
//     score = new ScoreCalculator(game);
//        assertEquals(0, score.getScore());
//    }
//
//    @Test
//    void testMahjongWithScore() {
////
////        openedinput.add("s2");
////        openedinput.add("s2");
////        openedinput.add("s2");
//
//        closedinput.add("w1");
//        closedinput.add("w1");
//        closedinput.add("w1");
//
//
//        game = new Mahjong(closedinput, openedinput, 1, 1);
//       score = new ScoreCalculator(game);
//        assertEquals(2, score.getScore());
//    }

//    @Test
//    void testCountTiles() {
//        openedinput.add("w2");
//        openedinput.add("w3");
//        openedinput.add("w4");
//        openedinput.add("m2");
//        openedinput.add("m2");
//        openedinput.add("h1");
//        game = new Mahjong(openedinput, 1, 1);
//        game.mahjongGame();
//        assertEquals(3, game.getHand().get(0).getCount());
//        assertTrue(2 == game.getHand().get(1).getIdNum() && game.getHand().get(1).getCatergory().equals("So"));
//        assertEquals(1, game.getHand().get(3).getCount());
//        assertTrue(3 == game.getHand().get(3).getIdNum() && game.getHand().get(3).getCatergory().equals("Man"));
//        assertEquals(1, game.getHand().get(14).getCount());
//        assertTrue(1 == game.getHand().get(14).getIdNum() && game.getHand().get(14).getCatergory().equals("Honor"));
//
//
//        assertEquals(0, new Wind(4).getCount());
//
//    }
//
//    @Test
//    void testVariantofTiles() {
//        openedinput.clear();
//        openedinput.add("s1");
//        openedinput.add("s5");
//        openedinput.add("s9");
//        openedinput.add("m1");
//        openedinput.add("m9");
//        openedinput.add("p1");
//        openedinput.add("p2");
//        openedinput.add("p3");
//        openedinput.add("p9");
//        openedinput.add("w2");
//        openedinput.add("w3");
//        openedinput.add("w4");
//        openedinput.add("w1");
//        openedinput.add("h3");
//        game = new Mahjong(openedinput, 1, 1);
//        game.mahjongGame();
//        assertEquals(0, game.getScore());
//        assertEquals (9 , game.getHand().get(2).getIdNum());
//        assertEquals (9 , game.getHand().get(4).getIdNum());
//        assertEquals (9 , game.getHand().get(8).getIdNum());
//        assertEquals (3 , game.getHand().get(13).getIdNum());
//        assertEquals (4 , game.getHand().get(11).getIdNum());
//
//        assertEquals ("Honor" , game.getHand().get(13).getCatergory());
//        assertEquals(0, game.getScore());
//    }
//
//    @Test
//    void testNoDuplicateTiles() {
//        openedinput.clear();
//        openedinput.add("s2");
//        openedinput.add("s3");
//        openedinput.add("s4");
//        openedinput.add("m3");
//        openedinput.add("m4");
//        openedinput.add("m5");
//        openedinput.add("s6");
//        openedinput.add("s7");
//        openedinput.add("s8");
//        openedinput.add("p4");
//        openedinput.add("p5");
//        openedinput.add("p6");
//        openedinput.add("h2");
//        openedinput.add("h3");
//        game = new Mahjong(openedinput, 1, 1);
//        game.mahjongGame();
//        assertEquals(1, game.getHand().get(1).getCount());
//        assertTrue(2 == game.getHand().get(0).getIdNum() && game.getHand().get(0).getCatergory().equals("So"));
//
//    }
//    @Test
//    void testInvalidTilesEnter(){
//        openedinput.clear();
//        openedinput.add("s10");
//        openedinput.add("p10");
//        openedinput.add("m10");
//        openedinput.add("w5");
//        openedinput.add("h4");
//        openedinput.add("S1");
//        openedinput.add("P1");
//        openedinput.add("M1");
//        openedinput.add("W1");
//        openedinput.add("H1");
//        game = new Mahjong(openedinput, 1, 1);
//        game.mahjongGame();
//        assertEquals(0, game.getHand().size());
//
//
//    }

}