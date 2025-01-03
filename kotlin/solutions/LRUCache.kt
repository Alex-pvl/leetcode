package solutions

class LRUCache(private val capacity: Int) {
	private val cache = LinkedHashMap<Int, Int>(capacity, 0.75f, true)

	fun get(key: Int): Int = cache[key] ?: -1

	fun put(key: Int, value: Int) {
		if (cache.size >= capacity && !cache.containsKey(key)) {
			val eldestKey = cache.keys.iterator().next()
			cache.remove(eldestKey)
		}
		cache[key] = value
	}
}