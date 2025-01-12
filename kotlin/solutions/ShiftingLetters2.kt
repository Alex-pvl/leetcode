package solutions

class ShiftOperations(
	val startIdx: Int,
	val endIdx: Int,
	val direction: Int,
)

fun shiftingLetters(s: String, shifts: Array<IntArray>): String {
	val operations = shifts.map { ShiftOperations(
		startIdx = it.first(),
		endIdx = it[1],
		direction = it.last()
	) }

	val chars = s.toCharArray()
	for (o in operations) {
		for (i in (o.startIdx..o.endIdx)) {
			if (o.direction == 1) {
				chars[i] = if (chars[i] == 'z') 'a' else chars[i] + 1
			} else {
				chars[i] = if (chars[i] == 'a') 'z' else chars[i] - 1
			}
		}
	}

	return String(chars)
}

fun shiftingLetters2(s: String, shifts: Array<IntArray>): String {
	val n = s.length
	val shift = IntArray(n+1)

	for (shiftOp in shifts) {
		val start = shiftOp.first()
		val end = shiftOp[1]
		val direction = shiftOp.last()

		shift[start] += if (direction == 1) 1 else -1
		if (end + 1 < n) {
			shift[end+1] -= if (direction == 1) 1 else -1
		}
	}

	var curShift = 0
	for (i in s.indices) {
		curShift += shift[i]
		shift[i] = curShift
	}

	val chars = s.toCharArray()
	for (i in s.indices) {
		val newShift = (shift[i] % 26 + 26) % 26
		chars[i] = 'a' + (s[i] - 'a' + newShift) % 26
	}
	return String(chars)
}

fun main() {
	println(shiftingLetters2("abc", arrayOf(intArrayOf(0,1,0), intArrayOf(1,2,1), intArrayOf(0,2,1))))
	println(shiftingLetters("dztz", arrayOf(intArrayOf(0,0,0), intArrayOf(1,1,1))))
}