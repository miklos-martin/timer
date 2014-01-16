package hu.onend.timer.test.model;

import hu.onend.timer.model.Interval;
import hu.onend.timer.model.Timer;

import static org.junit.Assert.assertEquals;

public class IntervalTest extends AbstractTimerTest {

    @Override
    protected Timer createTimer() {
        return new Interval(5);
    }

    @Override
    public void testGetCurrentTime() {
        int current = 5;

        for (int i = 0; i < 5; i++) {
            assertEquals(current, timer.getCurrentTime());
            timer.tick();
            current--;
        }
    }
}
