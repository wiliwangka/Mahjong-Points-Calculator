package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;


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
        w.increaseCount();
        assertEquals(1, w.getCount());
        w.decreaseCount();
        assertEquals(0, w.getCount());
        assertFalse(w.isStartShuntsu());
    }


    @Test
    void testHonorConstructor() {

        assertEquals(2, h.getIdNum());
        assertEquals("Honor", h.getCatergory());
        assertEquals(0, h.getCount());
        h.increaseCount();
        assertEquals(1, h.getCount());
        h.decreaseCount();
        assertEquals(0, h.getCount());
        assertFalse(h.isStartShuntsu());
    }

    @Test
    void testPinConstructor() {

        assertEquals(3, p.getIdNum());
        assertEquals("Pin", p.getCatergory());
        assertEquals(0, p.getCount());
        p.increaseCount();
        assertEquals(1, p.getCount());
        p.decreaseCount();
        assertEquals(0, p.getCount());
        assertFalse(p.isStartShuntsu());
    }

    @Test
    void testSoConstructor() {

        assertEquals(4, s.getIdNum());
        assertEquals("So", s.getCatergory());
        assertEquals(0, s.getCount());
        s.increaseCount();
        assertEquals(1, s.getCount());
        s.decreaseCount();
        assertEquals(0, s.getCount());
        assertFalse(s.isStartShuntsu());
    }

    @Test
    void testManConstructor() {

        assertEquals(5, m.getIdNum());
        assertEquals("Man", m.getCatergory());
        assertEquals(0, m.getCount());
        m.increaseCount();
        assertEquals(1, m.getCount());
        m.decreaseCount();
        assertEquals(0, m.getCount());
        assertFalse(m.isStartShuntsu());
    }

    @Test
    void testStartOfShuntsu() {
        assertFalse(w.startOfShuntsu());
        assertFalse(h.startOfShuntsu());
        assertFalse(p.startOfShuntsu());
        assertFalse(s.startOfShuntsu());
        assertFalse(m.startOfShuntsu());

    }
}
