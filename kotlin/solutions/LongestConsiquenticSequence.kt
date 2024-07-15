package solutions

fun longestConsecutive(nums: IntArray): Int {
	val set: MutableSet<Int> = mutableSetOf()
	set.addAll(nums.toList())

	var longestStreak = 0

	set.forEach {
		if ((it - 1) !in set) {
			var cur = it
			var curStreak = 1

			while (cur + 1 in set) {
				cur++
				curStreak++
			}

			longestStreak = longestStreak.coerceAtLeast(curStreak)
		}
	}

	return longestStreak
}

fun main() {
	println(longestConsecutive(intArrayOf(100,4,200,1,3,2)))
	println(longestConsecutive(intArrayOf(0,3,7,2,5,8,4,6,0,1)))
}