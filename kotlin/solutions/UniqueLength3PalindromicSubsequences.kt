package solutions

fun countPalindromicSubsequence(s: String): Int {
	val first = IntArray(26) { -1 }
	val last = IntArray(26) { -1 }
	val n = s.length

	for (i in 0 until n) {
		val ch = s[i] - 'a'
		if (first[ch] == -1) {
			first[ch] = i
		}
		last[ch] = i
	}

	val result = mutableSetOf<String>()

	for (i in 0 until 26) {
		if (first[i] != -1 && last[i] != -1 && first[i] < last[i]) {
			val left = first[i]
			val right = last[i]
			val middleSet = mutableSetOf<Char>()

			for (j in left + 1 until right) {
				middleSet.add(s[j])
			}

			for (ch in middleSet) {
				result.add("" + ('a' + i) + ch + ('a' + i))
			}
		}
	}

	return result.size
}

fun main() {
	println(countPalindromicSubsequence("aabca"))
	println(countPalindromicSubsequence("adc"))
	println(countPalindromicSubsequence("bbcbaba"))
}