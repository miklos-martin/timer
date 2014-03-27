package hu.onend.timer.model;

abstract public class AbstractTimer implements Timer {

    protected OnTimerIsOverListener isOverListener;

    @Override
    public void setOnTimerIsOverListener(OnTimerIsOverListener isOverListener) {
        this.isOverListener = isOverListener;
    }
}
