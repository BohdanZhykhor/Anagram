package com.kdan.foxytask1anagram

class Anagram {
    fun convert(textField: String, filterField: String): String {
        val filterBlank = filterField.isBlank()
        val words = textField.split(" ")
        val regex = if (filterBlank) "[^a-zA-Zа-яА-Я]".toRegex() else {
            "[${filterField}]".toRegex()
        }
        var anagram = ""
        words.forEach { anagram += "${postReversed(it, regex)} " }
        return anagram.substringBeforeLast(' ')
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