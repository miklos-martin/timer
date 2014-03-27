package hu.onend.timer.model;

abstract public class AbstractChainedTimer extends AbstractTimer implements ChainedTimer {

    protected OnChainedTimerIsOverListener chainedTimerIsOverListener;

    @Override
    public void setOnChainedTimerIsOverListener(OnChainedTimerIsOverListener chainedTimerIsOverListener) {
        this.chainedTimerIsOverListener = chainedTimerIsOverListener;
    }
}
