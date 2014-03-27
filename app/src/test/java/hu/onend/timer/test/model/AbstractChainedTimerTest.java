package hu.onend.timer.test.model;

import org.junit.Ignore;

import java.util.ArrayList;
import java.util.List;

import hu.onend.timer.model.ChainedTimer;
import hu.onend.timer.model.Timer;

/**
 * Abstract test case for all ChainedTimer implementations
 */
@Ignore
abstract public class AbstractChainedTimerTest extends AbstractTimerTest implements ChainedTimer.OnChainedTimerIsOverListener {

    protected List<Timer> chainedTimers;

    @Override
    public void setUp() {
        super.setUp();

        chainedTimers = new ArrayList<Timer>();
        ((ChainedTimer) timer).setOnChainedTimerIsOverListener(this);
    }

    @Override
    public void onChainedTimerIsOver(Timer timer) {
        chainedTimers.add(timer);
    }
}
