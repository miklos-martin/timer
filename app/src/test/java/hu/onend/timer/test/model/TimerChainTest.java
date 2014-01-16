package hu.onend.timer.test.model;

import hu.onend.timer.model.Interval;
import hu.onend.timer.model.Timer;
import hu.onend.timer.model.TimerChain;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimerChainTest extends AbstractTimerTest {

    @Override
    protected Timer createTimer() {
        TimerChain timer = new TimerChain();
        timer.add(new Interval(2));
        timer.add(new Interval(2));
        timer.add(new Interval(1));

        return timer;
    }

    @Override
    public void testGetCurrentTime() {
        // 2 - 2 - 1
        assertEquals(2, timer.getCurrentTime());
        timer.tick();
        timer.tick();
        assertEquals(2, timer.getCurrentTime());
        assertFalse(timer.isOver());
        timer.tick();
        timer.tick();
        assertEquals(1, timer.getCurrentTime());
        timer.tick();
        assertEquals(0, timer.getCurrentTime());
        assertTrue(timer.isOver());
    }
}
