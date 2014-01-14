package hu.onend.timer.test.model;

import hu.onend.timer.model.Interval;
import hu.onend.timer.model.Timer;

public class IntervalTest extends AbstractTimerTest {

    @Override
    protected Timer createTimer() {
        return new Interval(5);
    }
}
