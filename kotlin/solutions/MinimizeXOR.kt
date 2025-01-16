package solutions

fun minimizeXor(num1: Int, num2: Int): Int {
	val setBitsCount = Integer.bitCount(num2)
	var x = 0
	var bitsToSet = setBitsCount

	for (i in 31 downTo 0) {
		if (bitsToSet > 0 && (num1 and (1 shl i)) != 0) {
			x = x or (1 shl i)
			bitsToSet--
		}
	}

	for (i in 0 until 32) {
		if (bitsToSet > 0 && (x and (1 shl i)) == 0) {
			x = x or (1 shl i)
			bitsToSet--
		}
	}

	return x
}


fun main() {
	println(minimizeXor(3, 5)) // 3
	println(minimizeXor(1, 12)) // 3
}