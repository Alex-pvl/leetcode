package solutions

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
	var l1 = list1
	var l2 = list2
	val dummy = ListNode(0)
	var current = dummy

	while (l1 != null && l2 != null) {
		if (l1.`val` < l2.`val`) {
			current.next = l1
			l1 = l1.next
		} else {
			current.next = l2
			l2 = l2.next
		}
		current = current.next!!
	}

	if (l1 != null) {
		current.next = l1
	} else {
		current.next = l2
	}

	return dummy.next
}

fun mergeTwoLists2(list1: ListNode?, list2: ListNode?): ListNode? {
	if (list1 == null) {
		return list2
	}

	if (list2 == null) {
		return list1
	}

	if (list1.`val` <= list2.`val`) {
		list1.next = mergeTwoLists2(list1.next, list2)
		return list1
	} else {
		list2.next = mergeTwoLists2(list1, list2.next)
		return list2
	}
}

fun main() {
	val list1 = ListNode(1)
	list1.next = ListNode(2)
	list1.next!!.next = ListNode(4)

	val list2 = ListNode(1)
	list2.next = ListNode(3)
	list2.next!!.next = ListNode(4)

	var result = mergeTwoLists(list1, list2)
	while (result != null) {
		println(result.`val`)
		result = result.next
	}
}