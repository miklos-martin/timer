package hu.onend.timer.test.model;

import org.junit.Assert;
import org.junit.Test;

import hu.onend.timer.model.Interval;
import hu.onend.timer.model.Loop;
import hu.onend.timer.model.Timer;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

public class LoopTest extends AbstractChainedTimerTest {

    @Override
    protected Timer createTimer() {
        Loop loop = new Loop();
        loop.add(new Interval(1));
        loop.setLaps(5);

        return loop;
    }

    @Override
    public void testTick() {
        assertEquals(0, chainedTimers.size());
        super.testTick();
        assertEquals(5, chainedTimers.size());

        for (Timer internalTimer : chainedTimers) {
            assertTrue(internalTimer instanceof Interval);
            assertEquals(1, internalTimer.getTotalTime());
        }
    }

    @Override
    public void testGetCurrentTime() {
        for (int i = 0; i < 5; i++) {
            Assert.assertEquals(1, timer.getCurrentTime());
            timer.tick();
        }
    }

    @Test
    public void testGetLaps() {
        assertEquals(5, ((Loop) timer).getLaps());
    }
}
