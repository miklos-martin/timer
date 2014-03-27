package hu.onend.timer.model;

import java.io.Serializable;

/**
 * Timer interface
 */
public interface Timer extends Serializable {

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

    /**
     * Sets the isOverListener
     *
     * @param listener
     */
    public void setOnTimerIsOverListener(OnTimerIsOverListener listener);

    public interface OnTimerIsOverListener {
        public void onTimerIsOver(Timer timer);
    }
}
