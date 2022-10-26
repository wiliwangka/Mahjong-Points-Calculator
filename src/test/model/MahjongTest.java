package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MahjongTest {
    private ArrayList<String> userInput;
    private Mahjong game;


    @BeforeEach
    void runBefore() {
        userInput = new ArrayList<>();
        userInput.add("s2");
        userInput.add("s2");
        userInput.add("s2");
        userInput.add("m3");
        userInput.add("m4");
        userInput.add("m5");
        userInput.add("p6");
        userInput.add("p7");
        userInput.add("p8");


    }

    @Test
    void testMahjongNoScore() {
        userInput.add("h1");
        userInput.add("h2");
        userInput.add("h3");
        userInput.add("w1");
        userInput.add("w2");
        game = new Mahjong(userInput, 1, 1);
        game.mahjongGame();
        assertEquals(0, game.getScore());
    }

    @Test
    void testMahjongWithScore() {
        userInput.add("s4");
        userInput.add("s4");
        userInput.add("s4");
        userInput.add("m2");
        userInput.add("m2");
        game = new Mahjong(userInput, 1, 1);
        game.mahjongGame();
        assertEquals(1, game.getScore());
    }

    @Test
    void testCountTiles() {
        userInput.add("w2");
        userInput.add("w3");
        userInput.add("w4");
        userInput.add("m2");
        userInput.add("m2");
        game = new Mahjong(userInput, 1, 1);
        game.mahjongGame();
        assertEquals(3, game.getHand().get(0).getCount());
        assertTrue(2 == game.getHand().get(1).getIdNum() && game.getHand().get(1).getCatergory().equals("So"));
        assertEquals(1, game.getHand().get(3).getCount());
        assertTrue(3 == game.getHand().get(3).getIdNum() && game.getHand().get(3).getCatergory().equals("Man"));

        assertEquals(0, new Wind(4).getCount());

    }

    @Test
    void testVariantofTiles() {
        userInput.clear();
        userInput.add("s1");
        userInput.add("s5");
        userInput.add("s9");
        userInput.add("m1");
        userInput.add("m9");
        userInput.add("p1");
        userInput.add("p2");
        userInput.add("p3");
        userInput.add("p9");
        userInput.add("w2");
        userInput.add("w3");
        userInput.add("w4");
        userInput.add("w1");
        userInput.add("h3");
        game = new Mahjong(userInput, 1, 1);
        game.mahjongGame();
        assertEquals(0, game.getScore());
    }

    @Test
    void testNoDuplicateTiles() {
        userInput.clear();
        userInput.add("s2");
        userInput.add("s3");
        userInput.add("s4");
        userInput.add("m3");
        userInput.add("m4");
        userInput.add("m5");
        userInput.add("s6");
        userInput.add("s7");
        userInput.add("s8");
        userInput.add("p4");
        userInput.add("p5");
        userInput.add("p6");
        userInput.add("h2");
        userInput.add("h3");
        game = new Mahjong(userInput, 1, 1);
        game.mahjongGame();
        assertEquals(1, game.getHand().get(1).getCount());
        assertTrue(2 == game.getHand().get(0).getIdNum() && game.getHand().get(0).getCatergory().equals("So"));

    }

}