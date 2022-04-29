package benhamida.jassem.ocsorange.ui.search_program

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import benhamida.jassem.ocsorange.R
import benhamida.jassem.ocsorange.ui.MainActivity
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class SearchProgramFragmentTest {

    @get: Rule
    val activityRule : ActivityScenarioRule<MainActivity> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun testIsFragementVisibleOnAppLaunch(){
        onView(withId(R.id.programs_list_rv)).check(matches(isDisplayed()))
    }

    @Test
    fun testCallApiOpenScreenDetails(){
        onView(withId(R.id.search_program_et)).perform(typeText("game"))

        onView(withId(R.id.search_program_btn)).perform(click())

        runBlocking {
            delay(5000)
        }

        onView(withId(R.id.programs_list_rv)).perform(RecyclerViewActions.actionOnItemAtPosition<ProgramsListAdapter.DataViewHolder>(0, click()))

        onView(withId(R.id.program_title)).check(matches(isDisplayed()))
    }


}