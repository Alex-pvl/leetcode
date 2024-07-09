package solutions

fun groupAnagrams(strs: Array<String>): List<List<String>> {
	if (strs.size == 1) return listOf(strs.toList())

	val result: MutableList<List<String>> = mutableListOf()

	val seen: HashMap<String, MutableList<String>> = HashMap()

	strs.forEach {
		val sorted = it.toCharArray().sorted().joinToString()

		if (seen.contains(sorted)) {
			seen[sorted]!!.add(it)
		} else {
			seen[sorted] = mutableListOf(it)
		}

	}

	for (collection in seen.values) {
		result.add(collection)
	}

	return result
}

fun main() {
	groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
}