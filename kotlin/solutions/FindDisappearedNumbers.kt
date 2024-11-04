package solutions

fun findDisappearedNumbers(nums: IntArray): List<Int> {
	val n = nums.size
	val map = mutableMapOf<Int, Boolean>()
	for (num in nums) {
		map[num] = true
	}
	val result = mutableListOf<Int>()
	for (i in (1..n)) {
		if (!map.containsKey(i)) {
			result.add(i)
		}
	}

	return result
}