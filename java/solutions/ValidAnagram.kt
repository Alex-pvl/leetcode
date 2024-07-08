package solutions

import java.util.*

class ValidAnagram {
	companion object {
		fun isAnagram(s: String, t: String): Boolean {
			val x1 = s.toCharArray()
			val x2 = t.toCharArray()

			x1.sort()
			x2.sort()

			return x1.contentEquals(x2)
		}
	}

}

fun main() {
	print(ValidAnagram.isAnagram("anagram", "nagaram"))
}