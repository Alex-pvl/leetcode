package solutions

fun countBits(n: Int): IntArray {
	val ans = IntArray(n+1)
	ans[0] = 0
	for (i in (1..n)) {
		ans[i] = ans[i shr 1] + (i and 1)
	}
	return ans
}

fun main() {
	println(countBits(2).toList()) // [0,1,1]
	println(countBits(5).toList()) // [0,1,1,2,1,2]
}