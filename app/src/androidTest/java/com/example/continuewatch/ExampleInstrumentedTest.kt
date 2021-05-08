package com.example.continuewatch


import android.os.SystemClock
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.activityScenarioRule
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.uiautomator.UiDevice

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ContinueWatchTest {
    @get:Rule
    val rule = activityScenarioRule<MainActivity>()

    @Test
    fun correctCount() {
        val scenario = rule.scenario
        SystemClock.sleep(2000)
        Espresso.onView(ViewMatchers.withId(R.id.textSecondsElapsed))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
        SystemClock.sleep(1000)
        Espresso.onView(ViewMatchers.withId(R.id.textSecondsElapsed))
            .check(ViewAssertions.matches(ViewMatchers.withText("2")))
    }

//    @Test
//    fun correctCountOrientation() {
//        val scenario = rule.scenario
//        SystemClock.sleep(2000)
//        Espresso.onView(ViewMatchers.withId(R.id.textSecondsElapsed))
//            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
//        mainRule.activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
//        SystemClock.sleep(2000)
//        Espresso.onView(ViewMatchers.withId(R.id.textSecondsElapsed))
//            .check(ViewAssertions.matches(ViewMatchers.withText("2")))
//    }

//    @Test
//    fun correctCountBlockScreen() {
//        val uiDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation())
//        val scenario = rule.scenario
//        SystemClock.sleep(2000)
//        Espresso.onView(ViewMatchers.withId(R.id.textSecondsElapsed))
//            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
//        uiDevice.sleep()
//        SystemClock.sleep(2000)
//        uiDevice.wakeUp()
//        Espresso.onView(ViewMatchers.withId(R.id.textSecondsElapsed))
//            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
//    }
}
