package persistence;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HandReaderTest {
    @Test
    void testReaderNonExistentFile() {
        HandReader reader = new HandReader("./data/noSuchFile.json");
        try {
            ArrayList<String> hand = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass if check exception
        }
    }



    @Test
    void testReaderEmptyHand() {
        HandReader reader = new HandReader("./data/testReaderEmptyHand.json");
        try {




            ArrayList<String> hand = reader.read();
            assertEquals(0, hand.size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        HandReader reader = new HandReader("./data/testReaderrGeneralHand.json");
        try {

            ArrayList<String> hand = reader.read();
            assertEquals("m1", hand.get(0));
            assertEquals("m9", hand.get(8));
            assertEquals("h1", hand.get(13));
            assertEquals("w2", hand.get(10));
            assertEquals("m3", hand.get(2));
            assertEquals("m6", hand.get(5));
            assertEquals(14, hand.size());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}