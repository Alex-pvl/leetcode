package solutions

fun twoSum(nums: IntArray, target: Int): IntArray {
	val seen: HashMap<Int, Int> = HashMap()

	nums.forEachIndexed { index, i ->
		val x = target - i

		if (seen.contains(x)) {
			return intArrayOf(index, seen[x]!!)
		}

		seen.put(i, index)
	}

	return intArrayOf()
}

fun main() {
	println(twoSum(intArrayOf(2,7,11,15), 9))
}