package solutions

fun reverseList(head: ListNode?): ListNode? {
	var prev: ListNode? = null
	var curr = head

	while (curr != null) {
		val nextTemp = curr.next
		curr.next = prev
		prev = curr
		curr = nextTemp
	}

	return prev
}