package solutions

fun isPalindrome(head: ListNode?): Boolean {
	var slow = head
	var fast = head

	while (fast?.next != null) {
		slow = slow?.next
		fast = fast.next?.next
	}

	slow = reverseList(slow)
	fast = head

	while (slow != null) {
		if (slow.`val` != fast?.`val`) {
			return false
		}
		slow = slow.next
		fast = fast.next
	}

	return true
}