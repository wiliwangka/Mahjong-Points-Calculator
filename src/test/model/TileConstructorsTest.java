package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;


public class TileConstructorsTest {
    private Wind w;
    private Honor h;
    private Pin p;
    private So s;
    private Man m;

    @BeforeEach
    void runBefore() {
        w = new Wind(1);
        h = new Honor(2);
        p = new Pin(3);
        s = new So(4);
        m = new Man(5);
    }

    @Test
    void testWindConstructor() {

        assertEquals(1, w.getIdNum());
        assertEquals("Wind", w.getCatergory());
        assertEquals(0, w.getCount());
    }


    @Test
    void testHonorConstructor() {

        assertEquals(2, h.getIdNum());
        assertEquals("Honor", h.getCatergory());
        assertEquals(0, h.getCount());
    }

    @Test
    void testPinConstructor() {

        assertEquals(3, p.getIdNum());
        assertEquals("Pin", p.getCatergory());
        assertEquals(0, p.getCount());
    }

    @Test
    void testSoConstructor() {

        assertEquals(4, s.getIdNum());
        assertEquals("So", s.getCatergory());
        assertEquals(0, s.getCount());
    }

    @Test
    void testManConstructor() {

        assertEquals(5, m.getIdNum());
        assertEquals("Man", m.getCatergory());
        assertEquals(0, m.getCount());
    }
}
