package hu.onend.timer.test.model;

import org.junit.Assert;
import org.junit.Test;

import hu.onend.timer.model.Interval;
import hu.onend.timer.model.Loop;
import hu.onend.timer.model.Timer;

import static junit.framework.Assert.assertEquals;

public class LoopTest extends AbstractTimerTest {

    @Override
    protected Timer createTimer() {
        Loop loop = new Loop();
        loop.add(new Interval(1));
        loop.setLaps(5);

        return loop;
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
