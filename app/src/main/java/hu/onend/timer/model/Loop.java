package hu.onend.timer.model;

public class Loop extends TimerChain {

    private int laps;
    private int currentLap = 1;

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @Override
    public long getTotalTime() {
        return super.getTotalTime() * laps;
    }

    @Override
    public boolean isOver() {
        return super.isOver() && currentLap == laps;
    }

    @Override
    public void tick() throws RuntimeException {
        super.tick();
        if (super.isOver() && !isOver()) {
            lap();
        }
    }

    @Override
    public void reset() {
        super.reset();
        currentLap = 1;
    }

    private void lap() {
        super.reset();
        currentLap++;
    }
}
