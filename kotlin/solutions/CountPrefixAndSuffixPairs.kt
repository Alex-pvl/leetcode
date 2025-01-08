package solutions

// O(n^2) & O(1)
fun countPrefixSuffixPairs(words: Array<String>): Int {
	var res = 0

	for (i in words.indices) {
		for (j in (i+1 until words.size)) {
			if (words[j].startsWith(words[i]) && words[j].endsWith(words[i])) {
				res++
			}
		}
	}

	return res
}

// O(n^2) & O(n)
class DualTrie {
	class Node {
		private val links = Array<Node?>(26) { null }

		fun contains(c: Char): Boolean {
			return links[c - 'a'] != null
		}

		fun put(c: Char, node: Node) {
			links[c - 'a'] = node
		}

		fun next(c: Char): Node? = links[c - 'a']
	}

	class Trie {
		private var root = Node()

		fun insert(word: String) {
			var node = root
			for (c in word) {
				if (!node.contains(c)) {
					node.put(c, Node())
				}
				node = node.next(c)!!
			}
		}

		fun startsWith(prefix: String): Boolean {
			var node = root
			for (c in prefix) {
				if (!node.contains(c)) {
					return false
				}
				node = node.next(c)!!
			}
			return true
		}
	}

	class Solution {
		fun countPrefixSuffixPairs(words: Array<String>): Int {
			var res = 0

			for (i in words.indices) {
				val prefixTrie = Trie()
				val suffixTrie = Trie()

				prefixTrie.insert(words[i])

				val revWord = words[i].reversed()
				suffixTrie.insert(revWord)

				for (j in (0 until i)) {
					if (words[j].length > words[i].length) continue

					val prefixWord = words[j]
					val revPrefixWord = prefixWord.reversed()

					if (prefixTrie.startsWith(prefixWord) && suffixTrie.startsWith(revPrefixWord)) {
						res++
					}
				}
			}

			return res
		}
	}
}
