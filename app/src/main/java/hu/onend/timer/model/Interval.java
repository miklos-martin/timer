package hu.onend.timer.model;

/**
 * Simple interval timer
 */
public class Interval extends AbstractTimer {

    private long seconds;
    private long current;

    public Interval(long seconds) {
        this.seconds = seconds;
        reset();
    }

    @Override
    public long getTotalTime() {
        return seconds;
    }

    @Override
    public boolean isOver() {
        return current == 0;
    }

    @Override
    public void tick() throws RuntimeException {
        if (isOver())
            throw new RuntimeException("Can not call tick() on an expired Timer");

        --current;

        if (isOverListener != null && isOver())
            isOverListener.onTimerIsOver(this);
    }

    @Override
    public long getCurrentTime() {
        return current;
    }

    @Override
    public void reset() {
        current = seconds;
    }
}
