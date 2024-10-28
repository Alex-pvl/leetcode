package solutions

fun maxProfit(prices: IntArray): Int {
	var l = 0
	var r = 1
	var maxProfit = 0

	while (r < prices.size) {
		if (prices[l] < prices[r]) {
			val profit = prices[r] - prices[l]
			if (profit > maxProfit) {
				maxProfit = profit
			}
		} else {
			l = r
		}
		r++
	}

	return maxProfit
}