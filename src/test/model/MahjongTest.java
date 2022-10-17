package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MahjongTest {
    private ArrayList<String> userInput;


    @BeforeEach
    void runBefore() {
        userInput = new ArrayList<String>();
    }

    @Test
    void testMahjongnoscore() {
        userInput.add("s2");
        userInput.add("s2");
        userInput.add("s2");
        userInput.add("m3");
        userInput.add("m4");
        userInput.add("m5");
        userInput.add("s6");
        userInput.add("s6");
        userInput.add("s6");
        userInput.add("s7");
        userInput.add("s8");
        userInput.add("s9");
        userInput.add("w1");
        userInput.add("w1");
        Mahjong game = new Mahjong(userInput, 1, 1);
        assertEquals(0, game.getScore());
    }

    @Test
    void testMahjongWithScore() {
        userInput.add("s2");
        userInput.add("s2");
        userInput.add("s2");
        userInput.add("m3");
        userInput.add("m4");
        userInput.add("m5");
        userInput.add("s6");
        userInput.add("s6");
        userInput.add("s6");
        userInput.add("p2");
        userInput.add("p3");
        userInput.add("p4");
        userInput.add("p8");
        userInput.add("p8");
        Mahjong game = new Mahjong(userInput, 1, 1);
        assertEquals(1, game.getScore());
    }

}