package com.robotsandpencils.tictactoe;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

/**
 * This is a sample Robolectric unit test. This would be run with:
 * ./gradle testDebug
 * <p/>
 * and the output would be found at:
 * <p/>
 * ./app/build/test-report/debug/index.html
 */
@Config(emulateSdk = 18)
@RunWith(RobolectricTestRunner.class)
public class ExampleUnitTest {

    @Test
    public void failingTest() {
        Assert.assertTrue(false);
    }
}