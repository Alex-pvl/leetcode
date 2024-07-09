package solutions

fun topKFrequent(nums: IntArray, k: Int): IntArray {
	val counts: HashMap<Int, Int> = HashMap()

	val result = IntArray(k)

	nums.forEach {
		if (counts.contains(it)) {
			counts[it] = counts[it]!! + 1
		} else {
			counts[it] = 1
		}
	}

	val list: List<MutableMap.MutableEntry<Int, Int>> = counts.entries.toList().sortedByDescending { it.value }

	for (i in (0..<k)) {
		result[i] = list[i].key
	}

	return result
}

fun main() {
	println(topKFrequent(intArrayOf(4,1,-1,2,-1,2,3), 2))
}