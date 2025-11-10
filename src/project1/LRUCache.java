package project1;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {

	private final int capacity;

	public LRUCache(int capacity) {
		super(capacity, 0.75f, true);
		this.capacity = capacity;
	}

	@Override
	public boolean removeEldestEntry(Map.Entry<K, V> entry) {

		return size() > capacity;
	}

	public V get(Object key) {
		return super.get(key);
	}

	public V put(K key, V value) {

		return super.put(key, value);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
