package solutions

import kotlin.math.abs

fun minOperations(boxes: String): IntArray {
	val onesArr = boxes.withIndex()
		.filter { it.value == '1' }
		.map { it.index }

	return boxes.indices
		.map { idx ->
			onesArr.sumOf { abs(it - idx) }
		}.toIntArray()
}

fun minOperations2(boxes: String): IntArray {
	val res = IntArray(boxes.length)
	var ballsToLeft = 0; var movesToLeft = 0
	var ballsToRight = 0; var movesToRight = 0

	for (i in boxes.indices) {
		res[i] += movesToLeft
		ballsToLeft += Character.getNumericValue(boxes[i])
		movesToLeft += ballsToLeft

		val j = boxes.length - 1 - i
		res[j] += movesToRight
		ballsToRight += Character.getNumericValue(boxes[j])
		movesToRight += ballsToRight
	}

	return res
}

fun minOperations3(boxes: String): IntArray {
	val n = boxes.length

	val left = IntArray(n)
	val right = IntArray(n)
	val res = IntArray(n)

	var leftOnes = Character.getNumericValue(boxes.first())
	for (i in 1 until n) {
		left[i] = left[i-1] + leftOnes
		leftOnes += Character.getNumericValue(boxes[i])
	}

	var rightOnes = Character.getNumericValue(boxes.last())
	for (i in n-2 downTo 0) {
		right[i] = right[i+1] + rightOnes
		rightOnes += Character.getNumericValue(boxes[i])
	}

	for (i in boxes.indices) {
		res[i] = left[i] + right[i]
	}

	return res
}

fun main() {
	println(minOperations3("110").toList())
	println(minOperations3("001011").toList())
}