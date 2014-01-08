package hu.onend.timer.test;

import android.test.ActivityInstrumentationTestCase2;

import hu.onend.timer.TimerActivity;

public class TimerActivityTest extends ActivityInstrumentationTestCase2<TimerActivity> {

    private TimerActivity activity;

    public TimerActivityTest(Class<TimerActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        activity = getActivity();
    }

    public void testPreconditions() {
        assertNotNull( activity );
    }
}
