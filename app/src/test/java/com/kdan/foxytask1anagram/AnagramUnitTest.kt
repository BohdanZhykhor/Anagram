package com.kdan.foxytask1anagram

import org.junit.Test

import org.junit.Assert.*


class AnagramUnitTest {

    @Test
    fun test1() {
        assertEquals("dednimxoF looc 24/7",
            Anagram.convert("Foxminded cool 24/7", ""))
    }

    @Test
    fun test2() {
        assertEquals("dcba hgfe",
            Anagram.convert("abcd efgh", ""))
    }

    @Test
    fun test3() {
        assertEquals("d1cba hgf!e",
            Anagram.convert("a1bcd efg!h", ""))
    }

    @Test
    fun test4() {
        assertEquals("dexdnimoF oocl 7/42",
            Anagram.convert("Foxminded cool 24/7", "xl"))
    }

    @Test
    fun test5() {
        assertEquals("dcba hgfe",
            Anagram.convert("abcd efgh", "xl"))
    }

    @Test
    fun test6() {
        assertEquals("a1bcd efglh",
            Anagram.convert("dcb1a hgfle", "xl"))
    }
}