package persistence;

import org.junit.jupiter.api.Test;
import ui.Mahjongapp;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HandReaderTest {
    @Test
    void testReaderNonExistentFile() {
        HandReader reader = new HandReader("./data/noSuchFile.json");
        try {
            Mahjongapp app = reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass if check exception
        }
    }


    @Test
    void testReaderEmptyHand() {
        HandReader reader = new HandReader("./data/testReaderEmptyHand.json");
        try {


            Mahjongapp app = reader.read();
            assertEquals(0, app.getOpenedhand().size());
            assertEquals(0, app.getClosedhand().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralWorkRoom() {
        HandReader reader = new HandReader("./data/testReaderrGeneralHand.json");
        try {

            Mahjongapp app= reader.read();
            assertEquals("m1", app.getClosedhand().get(0));
            assertEquals("m9", app.getClosedhand().get(8));
            assertEquals("h1", app.getClosedhand().get(13));
            assertEquals("w2", app.getClosedhand().get(10));
            assertEquals("m3", app.getClosedhand().get(2));
            assertEquals("m6", app.getClosedhand().get(5));
            assertEquals(14, app.getClosedhand().size());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}
