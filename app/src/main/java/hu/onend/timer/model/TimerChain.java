package hu.onend.timer.model;

import java.util.ArrayList;
import java.util.List;

public class TimerChain extends AbstractChainedTimer {

    protected List<Timer> elements;

    protected int currentElement;

    public TimerChain() {
        this(new ArrayList<Timer>());
    }

    public TimerChain(List<Timer> elements) {
        this.elements = elements;
        reset();
    }

    @Override
    public long getTotalTime() {
        long totalTime = 0;
        for (Timer elem : elements) {
            totalTime += elem.getTotalTime();
        }

        return totalTime;
    }

    @Override
    public boolean isOver() {

        if (!elements.isEmpty()) {
            return getCurrentElement().isOver() && !hasNext();
        }

        return true;
    }

    @Override
    public void tick() throws RuntimeException {
        if (isOver())
            throw new RuntimeException("Can not call tick() on an expired Timer");

        Timer current = getCurrentElement();
        current.tick();
        if (current.isOver()) {
            if (chainedTimerIsOverListener != null)
                chainedTimerIsOverListener.onChainedTimerIsOver(current);

            next();
        }

        if (isOverListener != null && isOver())
            isOverListener.onTimerIsOver(this);
    }

    @Override
    public long getCurrentTime() {
        return getCurrentElement().getCurrentTime();
    }

    @Override
    public void reset() {
        currentElement = 0;
        for (Timer timer : elements) {
            timer.reset();
        }
    }

    public void add(Timer timer) {
        elements.add(timer);
    }

    private void next() {
        if (hasNext())
            currentElement++;
    }

    private boolean hasNext() {

        try {
            elements.get(currentElement + 1);
            return true;
        } catch (IndexOutOfBoundsException e) {
            return false;
        }
    }

    private Timer getCurrentElement() {
        return elements.get(currentElement);
    }
}
