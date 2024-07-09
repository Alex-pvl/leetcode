package solutions

fun containsDuplicate(nums: IntArray): Boolean {
	val seen: HashSet<Int> = HashSet()

	for (num in nums) {
		println(num)
		if (seen.contains(num)) {
			return true
		} else {
			seen.add(num)
		}
	}

	return false
}
