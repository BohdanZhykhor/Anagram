package com.kdan.foxytask1anagram

import com.kdan.foxytask1anagram.databinding.ActivityMainBinding

class Anagram (private val binding: ActivityMainBinding) {
    fun convert() {
        val filterBlank = binding.filterField.text.isBlank()
        val words = binding.textField.text.toString().split(" ")
        val regex = if (filterBlank) "[^a-zA-Z]".toRegex() else {
            "[${binding.filterField.text}]".toRegex()
        }
        var anagram = ""
        words.forEach { anagram += "${postReversed(it, regex)} " }
        binding.anagram.text = anagram.substringBeforeLast(' ')
    }


    private fun postReversed (word: String, regex: Regex): String {
        val anagram = preReversed(word, regex)
        var index = word.lastIndex
        word.forEach {
            if (!it.toString().contains(regex)) {
                while (anagram[index] != "") {
                    --index
                    if (index < 0) return anagram.joinToString("")
                }
                anagram[index] = it.toString()
                --index
                if (index < 0) return anagram.joinToString("")
            }
        }
        return anagram.joinToString("")
    }


    private fun preReversed (word: String, regex: Regex): MutableList<String> {
        val anagram = MutableList(word.length) { "" }
        var index = 0
        word.forEach {
            if (it.toString().contains(regex)) {
                anagram[index] = it.toString()
            }
            ++index
        }
        return anagram
    }
}