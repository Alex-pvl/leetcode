package solutions

	fun stringMatching(words: Array<String>): List<String> {
		val res = mutableListOf<String>()

		for (word in words) {
			if (words.filter { it != word }.any { word in it }) {
				res.add(word)
			}
		}

		return res
	}

fun main() {
	println(stringMatching(arrayOf("mass","as","hero","superhero")))
}