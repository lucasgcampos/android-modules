package lucascampos.modules.test.extension

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.matcher.ViewMatchers

import android.support.test.espresso.matcher.ViewMatchers.withId
import org.hamcrest.CoreMatchers.not

fun Int.isDisplayed(id: Int) {
    onView(withId(id)).check(matches(ViewMatchers.isDisplayed()))
}

fun Int.isNotDisplayed(id: Int) {
    onView(withId(id)).check(matches(not(ViewMatchers.isDisplayed())))
}
