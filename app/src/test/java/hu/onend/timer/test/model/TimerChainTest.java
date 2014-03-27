package hu.onend.timer.test.model;

import hu.onend.timer.model.Interval;
import hu.onend.timer.model.Timer;
import hu.onend.timer.model.TimerChain;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class TimerChainTest extends AbstractChainedTimerTest {

    @Override
    protected Timer createTimer() {
        TimerChain timer = new TimerChain();
        timer.add(new Interval(2));
        timer.add(new Interval(2));
        timer.add(new Interval(1));

        return timer;
    }

    @Override
    public void testTick() {
        assertEquals(0, chainedTimers.size());
        super.testTick();
        assertEquals(3, chainedTimers.size());

        // As we put them in above
        assertEquals(2, chainedTimers.get(0).getTotalTime());
        assertEquals(2, chainedTimers.get(1).getTotalTime());
        assertEquals(1, chainedTimers.get(2).getTotalTime());
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
