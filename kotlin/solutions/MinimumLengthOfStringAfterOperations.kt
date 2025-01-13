package solutions

fun minimumLength(s: String): Int {
	val freq = IntArray(26)
	for (ch in s) {
		freq[ch - 'a']++
	}

	var answer = 0
	for (f in freq) {
		answer += when {
			f == 0 -> continue
			f % 2 == 0 -> 2
			else -> 1
		}
	}
	return answer
}

fun main() {
	println(minimumLength("abaacbcbb"))
	println(minimumLength("aa"))
}