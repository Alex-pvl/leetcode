package solutions

fun waysToSplitArray(nums: IntArray): Int {
	val n = nums.size
	var totalSum = 0L
	for (num in nums) {
		totalSum += num
	}

	var leftSum = 0L
	var count = 0
	for (i in 0 until n - 1) {
		leftSum += nums[i]
		val rightSum = totalSum - leftSum
		if (leftSum >= rightSum) {
			count++
		}
	}

	return count
}