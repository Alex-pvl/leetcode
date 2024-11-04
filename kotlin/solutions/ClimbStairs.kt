package solutions

fun climbStairs(n: Int): Int {
	val cache = IntArray(n+1)
	for (i in (0..n)) {
		cache[i] = -1
	}
	return run(0, n, cache)
}

private fun run(step: Int, n: Int, cache: IntArray): Int {
	if (step > n) return 0
	if (step == n) return 1
	if (cache[step] != -1) return cache[step]
	cache[step] = run(step + 1, n, cache) + run(step + 2, n, cache)
	return cache[step]
}

fun main() {
	println(climbStairs(4))
}