package hu.onend.timer.test.model;

import org.junit.Test;

import hu.onend.timer.model.Interval;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IntervalTest {

    @Test
    public void testIsOver() {
        Interval interval  = new Interval(5);
        assertFalse(interval.isOver());
    }

    @Test
    public void testTick() {
        Interval interval  = new Interval(5);
        assertFalse(interval.isOver());

        for (int i = 0; i < 5; i++) {
            interval.tick();
        }

        assertTrue(interval.isOver());
    }

    @Test
    public void testGetCurrentTime() {
        Interval interval = new Interval(5);
        int current = 5;

        for (int i = 0; i < 5; i++) {
            assertEquals(current, interval.getCurrentTime());
            interval.tick();
            current--;
        }
    }

    @Test
    public void testReset() {
        Interval interval = new Interval(5);
        assertEquals(5, interval.getCurrentTime());
        assertFalse(interval.isOver());

        for (int i = 0; i < 5; i++) {
            interval.tick();
        }

        assertEquals(0, interval.getCurrentTime());
        assertTrue(interval.isOver());

        interval.reset();
        assertEquals(5, interval.getCurrentTime());
        assertFalse(interval.isOver());
    }

    @Test
    public void testGetTotalTime() {
        Interval interval = new Interval(5);
        assertEquals(5, interval.getCurrentTime());
        assertEquals(5, interval.getTotalTime());

        interval.tick();

        assertEquals(4, interval.getCurrentTime());
        assertEquals(5, interval.getTotalTime());
    }
}
