package solutions

fun productExceptSelf(nums: IntArray): IntArray {
	val n = nums.size

	val prefix = IntArray(n)
	val suffix = IntArray(n)
	val product = IntArray(n)

	prefix[0] = 1
	for (i in (1..<n)) {
		prefix[i] = nums[i-1] * prefix[i-1]
	}

	suffix[n-1] = 1
	for (i in (n-2 downTo 0)) {
		suffix[i] = nums[i+1] * suffix[i+1]
	}

	for (i in (0..<n)) {
		product[i] = prefix[i] * suffix[i]
	}

	return product
}

fun main() {
	println(productExceptSelf(intArrayOf(1,2,3,4)))
	println(productExceptSelf(intArrayOf(-1,1,0,-3,3)))
}