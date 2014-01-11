package hu.onend.timer.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;

import hu.onend.timer.TimerActivity;

import static org.fest.assertions.api.ANDROID.assertThat;

@RunWith(RobolectricGradleTestRunner.class)
public class TimerActivityTest {

    private TimerActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.buildActivity( TimerActivity.class ).get();
    }

    @Test
    public void testPreconditions() {
        assertThat(activity).isNotNull();
    }
}
