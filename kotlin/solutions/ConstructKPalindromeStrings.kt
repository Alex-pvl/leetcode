package solutions

fun canConstruct(s: String, k: Int): Boolean {
    val charCount = IntArray(26)
    for (char in s) {
        charCount[char - 'a']++
    }
    var oddCount = 0
    for (count in charCount) {
        if (count % 2 != 0) oddCount++
    }
    return oddCount <= k && k <= s.length
}

fun canConstruct2(s: String, k: Int) = s.groupingBy { it }.eachCount().count { it.value % 2 != 0 } <= k && k <= s.length

fun main() {
    println(canConstruct("annabelle", 2))
}