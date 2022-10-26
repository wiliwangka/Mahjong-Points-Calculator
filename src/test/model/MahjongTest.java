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
        userInput.add("s6");
        userInput.add("s7");
        userInput.add("s8");


        game = new Mahjong(userInput, 1, 1);
    }

    @Test
    void testMahjongNoScore() {
        userInput.add("h1");
        userInput.add("h1");
        userInput.add("h1");
        userInput.add("w1");
        userInput.add("w1");

        assertEquals(0, game.getScore());
    }

    @Test
    void testMahjongWithScore() {
        userInput.add("s4");
        userInput.add("s4");
        userInput.add("s4");
        userInput.add("m2");
        userInput.add("m2");

        assertEquals(1, game.getScore());
    }

    @Test
    void testCountTiles () {
        userInput.add("s4");
        userInput.add("s4");
        userInput.add("s4");
        userInput.add("m2");
        userInput.add("m2");
     assertEquals (3, game.getHand().get(1).getCount());
     assertTrue(2==game.getHand().get(1).getIdNum() && game.getHand().get(1).getCatergory().equals("So"));
     assertEquals (1, game.getHand().get(2).getCount());
        assertTrue(3==game.getHand().get(1).getIdNum() && game.getHand().get(1).getCatergory().equals("Man"));

    }


}