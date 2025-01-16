package solutions

fun xorAllNums(nums1: IntArray, nums2: IntArray): Int {
	var xor1 = 0
	var xor2 = 0

	if (nums2.size % 2 != 0) {
		for (num in nums1) {
			xor1 = xor1 xor num
		}
	}

	if (nums1.size % 2 != 0) {
		for (num in nums2) {
			xor2 = xor2 xor num
		}
	}

	return xor1 xor xor2
}

fun main() {
	println(xorAllNums(intArrayOf(2, 1, 3), intArrayOf(10, 2, 5, 0))) // 13
	println(xorAllNums(intArrayOf(1, 2), intArrayOf(3, 4))) // 0
}