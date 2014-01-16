package hu.onend.timer.model;

/**
 * Timer interface
 */
public interface Timer {

    /**
     * Returns the total time
     */
    public long getTotalTime();

    /**
     * Tells, whether the given timer is over or not
     */
    public boolean isOver();

    /**
     * Ticks the timer
     */
    public void tick() throws RuntimeException;

    /**
     * Returns the getCurrentTime seconds, where the timer is at
     */
    public long getCurrentTime();

    /**
     * Resets the timer
     */
    public void reset();
}
