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
abstract public class AbstractTimerTest implements Timer.OnTimerIsOverListener {

    protected Timer timer;
    protected int timerIsOverCalledTimes = 0;

    @Before
    public void setUp() {
        timer = createTimer();
        timer.setOnTimerIsOverListener(this);
        timerIsOverCalledTimes = 0;
    }

    @Override
    public void onTimerIsOver(Timer timer) {
        timerIsOverCalledTimes++;
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
        assertEquals(0, timerIsOverCalledTimes);

        for (int i = 0; i < 5; i++) {
            timer.tick();
        }

        assertTrue(timer.isOver());
        assertEquals(1, timerIsOverCalledTimes);
    }

    @Test(expected = RuntimeException.class)
    public void testTickThrowsException() {
        for (int i = 0; i < 5; i++) {
            timer.tick();
        }

        assertTrue(timer.isOver());
        timer.tick();
    }

    @Test
    public void testReset() {
        assertFalse(timer.isOver());

        for (int i = 0; i < 5; i++) {
            timer.tick();
        }

        assertTrue(timer.isOver());

        timer.reset();
        assertFalse(timer.isOver());
    }

    @Test
    public void testGetTotalTime() {
        assertEquals(5, timer.getTotalTime());

        timer.tick();

        assertEquals(5, timer.getTotalTime());
    }

    @Test
    public abstract void testGetCurrentTime();
}
