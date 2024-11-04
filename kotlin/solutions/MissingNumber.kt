package solutions

	fun missingNumber(nums: IntArray): Int {
		val n = nums.size
		val map = mutableMapOf<Int, Boolean>()
		for (num in nums) {
			map[num] = true
		}
		for (i in (0..n)) {
			if (!map.containsKey(i)) {
				return i
			}
		}

		return n
	}