package solutions

class NumArray(val nums: IntArray) {
	private val preSum = nums.copyOf()

	init {
		for (i in 1 until nums.size) {
			preSum[i] += preSum[i-1]
	}
	}

	fun sumRange(left: Int, right: Int): Int {
		if (left == 0) return preSum[right]
		return preSum[right] - preSum[left-1]
	}

}

fun main() {
	val numArray = NumArray(intArrayOf(-2, 0, 3, -5, 2, -1))
	println(numArray.sumRange(0, 2))
	println(numArray.sumRange(2, 5))
	println(numArray.sumRange(0, 5))
}