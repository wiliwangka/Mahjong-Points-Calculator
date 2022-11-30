package persistence;

import org.junit.jupiter.api.Test;
import ui.Mahjongapp;

import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class HandWriterTest {
//    @Test
//    void testReaderNonExistentFile() {
//        HandReader reader = new HandReader("./data/noSuchFile.json");
//        try {
//            Mahjongapp app = reader.read();
//            fail("IOException expected");
//        } catch (IOException e) {
//            // pass if check exception
//        }
//    }
//
//
//    @Test
//    void testWriterInvalidFile() {
//        try {
//            Mahjongapp app = new Mahjongapp();
//            ArrayList<String> hand = new ArrayList<String>();
//            hand.add("s1");
//            app.setClosedhand(hand);
//            HandWriter writer = new HandWriter("./data/my\0illegal:fileName.json");
//            writer.open();
//            fail("IOException was expected");
//        } catch (IOException e) {
//            // valid if catch exception
//        }
//    }

//    @Test
//    void testWriterEmptyHand() {
//        try {
//
//            Mahjongapp app = new Mahjongapp();
//            HandWriter writer = new HandWriter("./data/testWriterEmptyHand.json");
//            writer.open();
//            writer.write(app);
//            writer.close();
//
//            HandReader reader = new HandReader("./data/testWriterEmptyHand.json");
//            app = reader.read();
//            assertEquals(0, app.getClosedhand().size());
//            assertEquals(0, app.getOpenedhand().size());
//        } catch (IOException e) {
//            fail("Exception should not have been thrown");
//        }
//    }
//
//
//    @Test
//    void testWriterGeneralWorkroom() {
//        try {
//            ArrayList<String> hand = new ArrayList<String>();
//            for (int i = 0; i < 9; i++) {
//                hand.add("s" + (i + 1));
//            }
//            for (int i = 0; i < 3; i++) {
//                hand.add("w1");
//            }
//            hand.add("h2");
//            hand.add("h2");
//            Mahjongapp app = new Mahjongapp();
//            app.setClosedhand(hand);
//            HandWriter writer = new HandWriter("./data/testWriterGeneralHand.json");
//            writer.open();
//            writer.write(app);
//            writer.close();
//
//            HandReader reader = new HandReader("./data/testWriterGeneralHand.json");
//            app = reader.read();
//            assertEquals("s1", app.getClosedhand().get(0));
//            assertEquals("s9",app.getClosedhand().get(8));
//            assertEquals("h2", app.getClosedhand().get(13));
//            assertEquals(14, app.getClosedhand().size());
//
//
//        } catch (IOException e) {
//            fail("Exception should not have been thrown");
//        }
//    }
}
