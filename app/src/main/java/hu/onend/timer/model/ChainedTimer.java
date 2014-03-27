package hu.onend.timer.model;

public interface ChainedTimer extends Timer {

    public void setOnChainedTimerIsOverListener(OnChainedTimerIsOverListener chainedTimerIsOverListener);

    public interface OnChainedTimerIsOverListener {
        public void onChainedTimerIsOver(Timer timer);
    }
}
