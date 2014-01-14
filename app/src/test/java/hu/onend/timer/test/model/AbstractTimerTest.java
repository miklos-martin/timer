package hu.onend.timer.test.model;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import hu.onend.timer.model.Timer;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Base test case of all Timer implementations
 */
@Ignore
abstract public class AbstractTimerTest {

    private Timer timer;

    @Before
    public void setUp() {
        timer = createTimer();
    }

    /**
     * Returns a Timer instance with 5 sec total time
     */
    protected abstract Timer createTimer();

    @Test
    public void testIsOver() {
        assertFalse(timer.isOver());
    }

    @Test
    public void testTick() {
        assertFalse(timer.isOver());

        for (int i = 0; i < 5; i++) {
            timer.tick();
        }

        assertTrue(timer.isOver());
    }

    @Test
    public void testGetCurrentTime() {
        int current = 5;

        for (int i = 0; i < 5; i++) {
            assertEquals(current, timer.getCurrentTime());
            timer.tick();
            current--;
        }
    }

    @Test
    public void testReset() {
        assertEquals(5, timer.getCurrentTime());
        assertFalse(timer.isOver());

        for (int i = 0; i < 5; i++) {
            timer.tick();
        }

        assertEquals(0, timer.getCurrentTime());
        assertTrue(timer.isOver());

        timer.reset();
        assertEquals(5, timer.getCurrentTime());
        assertFalse(timer.isOver());
    }

    @Test
    public void testGetTotalTime() {
        assertEquals(5, timer.getCurrentTime());
        assertEquals(5, timer.getTotalTime());

        timer.tick();

        assertEquals(4, timer.getCurrentTime());
        assertEquals(5, timer.getTotalTime());
    }
}
