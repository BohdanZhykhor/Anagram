package com.kdan.foxytask1anagram

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.Matchers.containsString
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.Rule

@RunWith(AndroidJUnit4::class)
class AnagramTest {

    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test1() {
        onView(withId(R.id.text_field))
            .perform(typeText("Foxminded cool 24/7"))

        onView(withId(R.id.anagram))
            .check(matches(withText(containsString("dednimxoF looc 24/7"))))
    }

    @Test
    fun test2() {
        onView(withId(R.id.text_field))
            .perform(typeText("abcd efgh"))

        onView(withId(R.id.anagram))
            .check(matches(withText(containsString("dcba hgfe"))))
    }

    @Test
    fun test3() {
        onView(withId(R.id.text_field))
            .perform(typeText("a1bcd efg!h"))

        onView(withId(R.id.anagram))
            .check(matches(withText(containsString("d1cba hgf!e"))))
    }

    @Test
    fun test4() {
        onView(withId(R.id.text_field))
            .perform(typeText("Foxminded cool 24/7"))

        onView(withId(R.id.filter_field))
            .perform(typeText("xl"))

        onView(withId(R.id.anagram))
            .check(matches(withText(containsString("dexdnimoF oocl 7/42"))))
    }

    @Test
    fun test5() {
        onView(withId(R.id.text_field))
            .perform(typeText("abcd efgh"))

        onView(withId(R.id.filter_field))
            .perform(typeText("xl"))

        onView(withId(R.id.anagram))
            .check(matches(withText(containsString("dcba hgfe"))))
    }

    @Test
    fun test6() {
        onView(withId(R.id.text_field))
            .perform(typeText("a1bcd efglh"))

        onView(withId(R.id.filter_field))
            .perform(typeText("xl"))

        onView(withId(R.id.anagram))
            .check(matches(withText(containsString("dcb1a hgfle"))))
    }
//hvv
}
