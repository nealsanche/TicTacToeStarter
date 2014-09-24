package com.robotsandpencils.tictactoe.espresso;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.LargeTest;

import com.robotsandpencils.tictactoe.R;
import com.robotsandpencils.tictactoe.activities.GameActivity;

import static com.google.android.apps.common.testing.ui.espresso.Espresso.onView;
import static com.google.android.apps.common.testing.ui.espresso.assertion.ViewAssertions.matches;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withId;
import static com.google.android.apps.common.testing.ui.espresso.matcher.ViewMatchers.withText;

/**
 * This is just an example of getting an Espresso test working. You'd run Gradle with:
 * <p/>
 * ./gradlew connectedAndroidTest
 * <p/>
 * Then, you'd take a look at the output that is produced at:
 * <p/>
 * ./app/build/outputs/reports/androidTests/connected/index.html
 * <p/>
 * Created by neal on 2014-09-24.
 */
@LargeTest
public class GameActivityTest extends ActivityInstrumentationTestCase2<GameActivity> {

    public GameActivityTest() {
        super(GameActivity.class);
    }

    public GameActivityTest(Class<GameActivity> activityClass) {
        super(activityClass);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        // Espresso doesn't launch the activity so we need to do it ourselves
        getActivity();
    }

    public void testInitialText() {
        onView(withId(R.id.initial_text)).check(matches(withText(getActivity().getString(R.string.initial_info_text))));
    }
}
