package hu.onend.timer.model;

/**
 * Simple interval timer
 */
public class Interval implements Timer {

    private long seconds;
    private long current;

    public Interval( long seconds ) {
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
    public void tick() {
        --current;
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
