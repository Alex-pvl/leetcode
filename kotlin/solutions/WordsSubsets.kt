package solutions

fun wordSubsets(words1: Array<String>, words2: Array<String>): List<String> {
    val targetFreq = IntArray(26)
    for (word in words2) {
        val freq = word.getFrequencies()
        for (i in 0..25) {
            targetFreq[i] = maxOf(targetFreq[i], freq[i])
        }
    }

    return words1.filter { word ->
        val freq = word.getFrequencies()
        freq.zip(targetFreq).all { (wordCount, targetCount) -> wordCount >= targetCount }
    }
}

private fun String.getFrequencies(): IntArray {
    val freq = IntArray(26)
    for (c in this) {
        freq[c - 'a']++
    }
    return freq
}

fun main() {
    println(wordSubsets(arrayOf("amazon", "apple", "facebook", "google", "leetcode"), arrayOf("oo", "e")))
}